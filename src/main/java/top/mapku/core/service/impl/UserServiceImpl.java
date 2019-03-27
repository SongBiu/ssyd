package top.mapku.core.service.impl;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import top.mapku.core.dto.OpenIdDto;
import top.mapku.core.mapper.UserMapper;
import top.mapku.core.dto.UserDto;
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
    public UserDto getUserById(String id) {
        return userMapper.selectUserById(id);
    }

    @Override
    @Cacheable(value = "userFromTeam", key = "#teamId")
    public List<UserDto> getUsersByTeamId(Integer teamId) {
        return null;
    }

    @Override
    public UserDto login(String jsonCode, String name, String avatarUrl, HttpSession session) {
        String id = WxUtils.getOpenid(jsonCode);
        if (!Auth.login(id, session)) {
            userMapper.addUser(new UserDto(id, name, avatarUrl));
        } else {
            userMapper.updateUser(new UserDto(id, name, avatarUrl));
        }
        return userMapper.selectUserById(id);
    }
}
