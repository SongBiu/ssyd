package top.mapku.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.mapku.core.aop.exception.AuthException;
import top.mapku.core.entity.User;
import top.mapku.core.service.UserService;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

@Component
public class Auth {
    @Autowired
    UserService userService;

    private static Auth auth;

    @PostConstruct
    public void init() {
        auth = this;
        auth.userService = this.userService;
    }

    public static Boolean checkAuth(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            throw new AuthException();
        }
        HttpSession session = request.getSession();
        for (Cookie cookie : cookies) {
            if (cookie.getPath().equals("/wxapp") &&
                    Constant.COOKIE_SESSION_ID.equals(cookie.getName())) {
                if (session.getAttribute(Constant.COOKIE_SESSION_ID).equals(cookie.getValue())) {
                    return true;
                } else {
                    throw new AuthException();
                }
            }
        }
        return true;
    }

    public static boolean login(String id, HttpSession session) {
        User user = auth.userService.getUserById(id);
        if (null == user) {
            return false;
        }
        session.setAttribute(Constant.COOKIE_SESSION_ID, id);
        return true;
    }
}