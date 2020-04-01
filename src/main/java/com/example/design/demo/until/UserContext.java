package com.example.design.demo.until;

import com.example.design.demo.pojo.User;
/*
存放user全局变量，用来获得userid值，
 */
public class UserContext {
    private static ThreadLocal<User> userHolder = new ThreadLocal<User>();

    public static void setUser(User user) {
        userHolder.set(user);
    }

    public static User getUser() {
        return userHolder.get();
    }
}
