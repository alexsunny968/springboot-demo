package cn.unisolution.demo.interfacer;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2018/2/24.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented

public @interface Access {

    String[] value() default {};

    String[] authorities() default {};

    String[] roles() default {};
}
