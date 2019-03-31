package top.mapku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.mapku.core.aop.annotation.Message;
import top.mapku.core.aop.annotation.Auth;
import top.mapku.core.entity.User;
import top.mapku.core.service.UserService;

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
    @Auth
    public User login(@PathVariable String jsonCode, @RequestParam String name, @RequestParam String avatarUrl, HttpSession session) {
        return userService.login(jsonCode, name, avatarUrl, session);
    }

    @GetMapping("")
    @Message(success = "获取用户信息成功", fail = "获取用户信息失败")
    @Auth
    public User getUserById(@CookieValue("id") String id) {
        return userService.getUserById(id);
    }

}
