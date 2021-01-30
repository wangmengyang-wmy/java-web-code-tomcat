package com.alibaba.utils;



import com.alibaba.entity.User;

import java.util.concurrent.ConcurrentHashMap;

public class Constants {
    public static final ConcurrentHashMap<String, User> USER_MAP = new ConcurrentHashMap<>();
    static {
        USER_MAP.put("1",new User("张三","123456","1"));
        USER_MAP.put("2",new User("李四","123456","2"));
        USER_MAP.put("3",new User("王二","123456","3"));
        USER_MAP.put("4",new User("麻子","123456","4"));
    }
}
