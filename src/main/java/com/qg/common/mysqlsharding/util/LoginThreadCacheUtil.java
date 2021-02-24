package com.qg.common.mysqlsharding.util;

import com.qg.common.mysqlsharding.model.User;

public class LoginThreadCacheUtil {

    private LoginThreadCacheUtil(){}

    static ThreadLocal<User> threadLocal = new ThreadLocal<>();

    public static void setUser(User user){
        threadLocal.set(user);
    }

    public static User getUser(){
        return threadLocal.get();
    }
}
