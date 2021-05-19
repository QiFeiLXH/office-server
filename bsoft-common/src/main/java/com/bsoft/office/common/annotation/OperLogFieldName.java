package com.bsoft.office.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: xucl
 * @DateTime: 2021/2/5 13:43
 * @Description: 用户操作日志操作 ，返回字段的名称
 */
@Target(ElementType.FIELD) //注解放置的目标位置
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented
public @interface OperLogFieldName {
    String value() default "";
}
