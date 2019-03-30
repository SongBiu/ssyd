package top.mapku.core.aop.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.mapku.core.aop.annotation.Message;
import top.mapku.core.aop.Response;

import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;


/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Message annotationMessage = methodParameter.getMethod().getAnnotation(Message.class);
        if (null != o && o.getClass().isAssignableFrom(RuntimeException.class)) {
            return Response.fail(annotationMessage.fail());
        }
        return Response.success(o, annotationMessage.success());
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }
}