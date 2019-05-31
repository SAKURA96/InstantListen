package com.example.library.annotation;

import com.example.library.type.NetType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//作用在方法之上
@Target({ElementType.METHOD})
//jvm运行时，通过反射获取该注解的值
@Retention(RetentionPolicy.RUNTIME)
public @interface Network {
    NetType netType() default NetType.AUTO;
}
