package com.qg.common.mysqlsharding.anno;


import java.lang.annotation.*;

/**
 * 将要切换的Mapper加入此注解
 * @author qig
 * @date 2021年2月25日
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
public @interface Sharding {
}
