package top.mapku.controller;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.mapku.core.aop.annotation.Message;
import top.mapku.core.aop.annotation.NotAuth;
import top.mapku.core.dto.UserDto;
import top.mapku.core.service.UserService;
import top.mapku.core.service.impl.UserServiceImpl;
import top.mapku.utils.Auth;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@RestController
@RequestMapping("/wxapp/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/{jsonCode}")
    @Message(success = "登陆成功", fail = "获取登录信息失败")
    @NotAuth
    public UserDto login(@PathVariable String jsonCode, @RequestParam String name, @RequestParam String avatarUrl, HttpSession session) {
        return userService.login(jsonCode, name, avatarUrl, session);
    }


    @GetMapping("")
    @Message(success = "获取用户信息成功", fail = "获取用户信息失败")
    public UserDto getUserById(@CookieValue("id") String id) {
        return userService.getUserById(id);
    }

}
