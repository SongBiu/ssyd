package top.mapku.core.aop.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.mapku.core.aop.annotation.Message;
import top.mapku.core.aop.exception.*;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(CodeException.class)
    @Message(fail = "验证码错误")
    public CodeException codeError(CodeException e) {
        return e;
    }

    @ExceptionHandler(AuthException.class)
    @Message(fail = "身份验证失败，请先登录")
    public AuthException authException(AuthException e) {
        return e;
    }

    @ExceptionHandler(LoginException.class)
    @Message(fail = "登陆信息错误，请确认信息后重新登陆")
    public LoginException loginException(LoginException e) {
        return e;
    }

    @ExceptionHandler(EmptyException.class)
    @Message(fail = "获取信息失败")
    public EmptyException emptyException(EmptyException e) {
        return e;
    }

    @ExceptionHandler(DuplicateException.class)
    @Message(fail = "数据重复")
    public DuplicateException duplicateException(DuplicateException e) {
        return e;
    }

    @ExceptionHandler(LackException.class)
    @Message(fail = "所需要消耗的资源不足")
    public LackException lackException(LackException e) {
        return e;
    }
}
