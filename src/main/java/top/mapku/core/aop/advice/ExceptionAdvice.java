package top.mapku.core.aop.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.mapku.core.aop.exception.*;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(CodeException.class)
    public CodeException codeError(CodeException e) {
        return e;
    }

    @ExceptionHandler(AuthException.class)
    public AuthException authException(AuthException e) {
        return e;
    }

    @ExceptionHandler(LoginException.class)
    public LoginException loginException(LoginException e) {
        return e;
    }

    @ExceptionHandler(EmptyException.class)
    public EmptyException emptyException(EmptyException e) {
        return e;
    }

    @ExceptionHandler(DuplicateException.class)
    public DuplicateException duplicateException(DuplicateException e) {
        return e;
    }

    @ExceptionHandler(LackException.class)
    public LackException lackException(LackException e) {
        return e;
    }
}
