package com.project.dao;

import com.project.model.User;

import java.util.List;

/**
 * Created by wuyi5 on 2017/9/6.
 */
public interface UserDao {
    List<User> select();
}
