package com.project.service.impl;

import com.project.dao.UserDao;
import com.project.model.User;
import com.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuyi5 on 2017/9/6.
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void allUsers() {
        List<User> users = userDao.select();
        for(User user : users) {
            System.out.println(user);
        }
    }
}
