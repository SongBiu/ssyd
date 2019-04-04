package top.mapku.core.aop.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.mapku.core.aop.annotation.Message;
import top.mapku.core.entity.Response;


/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (RuntimeException.class.isAssignableFrom(o.getClass())) {
            return Response.fail(((RuntimeException) o).getMessage());
        }
        Message message = methodParameter.getMethod().getAnnotation(Message.class);
        if (null == message) {
            return Response.success(o);
        }
        return Response.info(o, message.value());
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }
}