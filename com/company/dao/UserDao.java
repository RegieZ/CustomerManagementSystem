package com.company.dao;

import com.company.domain.User;
import com.company.util.DataUtils;

import java.util.List;

public class UserDao {

    public List<User> findAll() {
        // 调用数据库查询
        List<User> list = DataUtils.readAll();
        return list;
    }
}
