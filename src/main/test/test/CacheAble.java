package test;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)  // 定义注解的保留策略
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.METHOD})         // 定义注解的作用目标
public @interface CacheAble {  // 自定义注解
    String name();
    int id() default 0;
    Class<Long> gid();
}
