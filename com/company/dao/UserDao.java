package com.company.dao;

import com.company.domain.User;
import com.company.util.DataUtils;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class UserDao {

    public List<User> findAll() {
        // 调用数据库查询
        List<User> list = DataUtils.readAll();
        return list;
    }

    public void add(User user) {
        // 1.调用数据库查询
        List<User> list = DataUtils.readAll();
        // 2. List添加User
        list.add(user);
        // 3. 新的List集合覆盖数据库
        DataUtils.writeAll(list);
    }

    public void delete(String id) {
        // 1.查询所有
        List<User> list = DataUtils.readAll();
        // 2.遍历
        for (User user : list) {
            // 查找有无此ID记录，可避免修改异常
            if (user.getId().equalsIgnoreCase(id)) {
                list.remove(user);
                break;
            }
        }
        // 3.将删完的list覆盖数据库
        DataUtils.writeAll(list);
    }

    public User findById(String id) {
        User returnUser = null;
        // 1.查询所有
        List<User> list = DataUtils.readAll();
        // 2.遍历
        for (User user : list) {
            if (user.getId().equalsIgnoreCase(id)) {
                returnUser = user;
            }
        }
        // 3.返回
        return returnUser;
    }

    public void update(User newUser) {
        // 1.查询所有
        List<User> list = DataUtils.readAll();
        // 2遍历
        for (User user : list) {
            // 判断ID是否一致
            if (user.getId().equalsIgnoreCase(newUser.getId())) {
                try {
                    // 3.新的数据，覆盖旧的
                   /* user.setName(newUser.getName());
                    user.setAge(newUser.getAge());*/
                    BeanUtils.copyProperties(user, newUser);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        // 4.覆盖原有的数据库
        DataUtils.writeAll(list);
    }
}
