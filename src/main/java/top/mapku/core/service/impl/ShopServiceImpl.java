package top.mapku.core.service.impl;

import org.springframework.stereotype.Component;
import top.mapku.core.aop.exception.LackException;
import top.mapku.core.entity.User;
import top.mapku.core.mapper.ShopMapper;
import top.mapku.core.aop.exception.CodeException;
import top.mapku.core.mapper.UserMapper;
import top.mapku.core.service.ShopService;
import top.mapku.utils.Constant;

import javax.annotation.Resource;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Component
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopMapper shopMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean verify(String userId, String code) {
        boolean codeEqual = shopMapper.selectCodeByUserId(userId).equals(code);
        if (!codeEqual) {
            throw new CodeException();
        }
        return true;
    }

    @Override
    public void buyPostcard(String userId) {
        User user = userMapper.selectUserById(userId);
        if (user.getScore() < Constant.PRICE_POSTCARD) {
            throw new LackException();
        }
        user.setPostcard(user.getPostcard() + 1);
        user.setScore(user.getScore() - Constant.PRICE_POSTCARD);
        shopMapper.updateShop(user);
    }

    @Override
    public void buyVoucher(String userId) {
        User user = userMapper.selectUserById(userId);
        if (user.getScore() < Constant.PRICE_VOUCHER) {
            throw new LackException();
        }
        user.setPostcard(user.getPostcard() + 1);
        user.setScore(user.getScore() - Constant.PRICE_VOUCHER);
        shopMapper.updateShop(user);
    }

    @Override
    public void usePostcard(String userId) {
        User user = userMapper.selectUserById(userId);
        if (user.getPostcard() < 1) {
            throw new LackException();
        }
        user.setPostcard(user.getPostcard() - 1);
        shopMapper.updateShop(user);
    }

    @Override
    public void useVoucher(String userId) {
        User user = userMapper.selectUserById(userId);
        if (user.getVoucher() < 1) {
            throw new LackException();
        }
        user.setPostcard(user.getVoucher() - 1);
        shopMapper.updateShop(user);
    }
}
