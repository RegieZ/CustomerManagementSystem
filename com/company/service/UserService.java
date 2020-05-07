package com.company.service;

import com.company.dao.UserDao;
import com.company.domain.User;

import java.util.List;

public class UserService {

    UserDao userDao = new UserDao();

    public List<User> findAll() {
        // 调用dao查询
        //  List<User> list = userDao.findAll();
        return userDao.findAll();
    }

    public void add(User user) {
        // 调用dao添加
        userDao.add(user);
    }

    public void delete(String id) {
        userDao.delete(id);
    }

    public User findById(String id){
        // 调用dao，根据id查询
        return userDao.findById(id);
    }

    public void update(User newUser){
        userDao.update(newUser);
    }
}
