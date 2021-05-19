package com.bsoft.office.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Xuhui Lin
 * @Date 2020/6/4 15:55
 * @Description 用于导出时需保存导出日志的注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequiredExportLog {
    boolean value() default true;
}
