package top.mapku.core.aop.annotation;

import java.lang.annotation.*;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
@Documented
public @interface Message {
    String fail();

    String success() default "";
}
