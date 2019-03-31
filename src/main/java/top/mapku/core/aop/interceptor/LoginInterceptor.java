package top.mapku.core.aop.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.mapku.core.aop.annotation.Auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */


public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // pass for api docs
        if (org.springframework.web.servlet.resource.ResourceHttpRequestHandler.class == handler.getClass()) {
            return true;
        }
        Auth auth = ((HandlerMethod) handler).getMethod().getAnnotation(Auth.class);
        if (null != auth) {
            top.mapku.utils.Auth.checkAuth(request);
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
