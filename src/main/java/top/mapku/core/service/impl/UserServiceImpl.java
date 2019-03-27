package top.mapku.core.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import top.mapku.core.mapper.UserMapper;
import top.mapku.core.entity.User;
import top.mapku.core.service.UserService;
import top.mapku.utils.Auth;
import top.mapku.utils.WxUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Component
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "user", key = "#id")
    public User getUserById(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    @Cacheable(value = "userFromTeam", key = "#teamId")
    public List<User> getUsersByTeamId(Integer teamId) {
        return null;
    }

    @Override
    public User login(String jsonCode, String name, String avatarUrl, HttpSession session) {
        String id = WxUtils.getOpenid(jsonCode);
        if (!Auth.login(id, session)) {
            userMapper.addUser(new User(id, name, avatarUrl));
        } else {
            userMapper.updateUser(new User(id, name, avatarUrl));
        }
        return userMapper.selectUserById(id);
    }
}
