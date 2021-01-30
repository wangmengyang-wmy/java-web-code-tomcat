package com.alibaba.dao;

import com.alibaba.entity.User;

import java.util.List;

public interface UserDao {
    boolean login(String name, String password);
    boolean register(User user);
    List<User> getUserAll();//返回用户信息集合
    boolean delete(String id);//根据id删除
    boolean update(User user);
}
