package top.mapku.core.aop.interceptor;

import org.apache.ibatis.plugin.Intercepts;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.mapku.core.aop.annotation.NotAuth;
import top.mapku.core.aop.exception.AuthException;
import top.mapku.utils.Auth;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        NotAuth notAuth = ((HandlerMethod) handler).getMethod().getAnnotation(NotAuth.class);
        if (null == notAuth) {
            Auth.checkAuth(request);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
