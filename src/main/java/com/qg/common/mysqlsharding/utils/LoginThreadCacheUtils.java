package com.qg.common.mysqlsharding.utils;

import com.qg.common.mysqlsharding.model.User;

/**
 * 用户缓存类
 */
public class LoginThreadCacheUtils {

    private LoginThreadCacheUtils(){}

    static ThreadLocal<User> threadLocal = new ThreadLocal<>();

    public static void setUser(User user){
        threadLocal.set(user);
    }

    /**
     * 将要切换的数据源放入用户中
     * @param sqlSessionBeanName 数据源对应名称
     */
    public static void setUser(String sqlSessionBeanName){
        threadLocal.set(User.UserBuilder.anUser().sqlSessionBeanName(sqlSessionBeanName).build());
    }

    public static User getUser(){
        return threadLocal.get();
    }
}
