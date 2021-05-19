package com.bsoft.office.common.annotation;

import java.lang.annotation.*;

/**
 * @Author: xucl
 * @DateTime: 2021/2/4 17:52
 * @Description: 用户操作记录
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented
public @interface OperLog {
    String operType() default "";//操作类型
    String operDesc() default "";//操作描述
}
