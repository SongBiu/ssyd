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
        HttpSession session = request.getSession();
        if (null == cookies || null == session) {
            throw new AuthException();
        }
        Cookie cookie = getLoginCookie(cookies);
        if (null != session.getAttribute(Constant.COOKIE_SESSION_ID) &&
                session.getAttribute(Constant.COOKIE_SESSION_ID).equals(cookie.getValue())) {
            return true;
        }
        if (login(cookie.getValue(), session)) {
            return true;
        }
        throw new AuthException();
    }

    private static Cookie getLoginCookie(Cookie[] cookies) {
        for (Cookie cookie: cookies) {
            if (Constant.COOKIE_SESSION_ID.equals(cookie.getName())) {
                return cookie;
            }
        }
        throw new AuthException();
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