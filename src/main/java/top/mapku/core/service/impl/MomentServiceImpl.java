package top.mapku.core.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import top.mapku.core.aop.exception.DuplicateException;
import top.mapku.core.entity.Good;
import top.mapku.core.entity.Moment;
import top.mapku.core.entity.User;
import top.mapku.core.mapper.GoodMapper;
import top.mapku.core.mapper.MomentMapper;
import top.mapku.core.mapper.UserMapper;
import top.mapku.core.service.MomentService;
import top.mapku.utils.Constant;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.lang.Math;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Component
public class MomentServiceImpl implements MomentService {
    @Resource
    private MomentMapper momentMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private GoodMapper goodMapper;

    @Override
    public List<Moment> getAllMoments() {
        return momentMapper.selectAllMoments();
    }

    @Override
    public void deleteMoment(Integer momentId) {
        momentMapper.delteMoment(momentId);
    }

    @Override
    public void addMoment(Moment moment) {
        User user = userMapper.selectUserById(moment.getUserId());
        Boolean inOneWeek = new Date().getTime() - user.getRegistrationDate().getTime() < 7 * 1000 * Constant.SECONDS_ONE_DAY;
        Integer score = getScore(moment.getBag(), inOneWeek);
        user.setScore(user.getScore() + score);
        userMapper.updateUser(user);
        momentMapper.insertMoment(moment);
        User inviter = userMapper.selectInviter(user);
        if (isFirstMoment(user) && null != inviter) {
            rewardInviter(inviter);
        }
    }

    @Override
    public void giveGood(Good good) {
        if (null != goodMapper.selectGood(good)) {
            throw new DuplicateException();
        }
        Moment moment = momentMapper.selectMomentById(good.getMomentId());
        moment.setGood(moment.getGood() + 1);
        momentMapper.updateGood(moment);
        goodMapper.insertGood(good);
    }

    @Override
    public void deleteGood(Good good) {
        if (null == goodMapper.selectGood(good)) {
            throw new DuplicateException();
        }
        Moment moment = momentMapper.selectMomentById(good.getMomentId());
        moment.setGood(moment.getGood() - 1);
        momentMapper.updateGood(moment);
        goodMapper.deleteGood(good);
    }

    private Integer getScore(Integer bag, Boolean inOneWeek) {
        Integer result = 2;
        if (inOneWeek) {
            result = 3;
        }
        result = Math.min(Constant.MAX_SCORE_PER_MOMENT, result + bag);
        return result;
    }

    private Boolean isFirstMoment(User user) {
        return momentMapper.selectMomentsByUserId(user.getUserId()).isEmpty();
    }

    private void rewardInviter(User user) {
        user.setScore(user.getScore() + Constant.REWARD_SCORE);
        userMapper.updateUser(user);
    }

}
