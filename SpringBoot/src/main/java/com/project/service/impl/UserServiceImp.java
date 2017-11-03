package com.project.service.impl;

import com.project.dao.UserDao;
import com.project.model.UserEntity;
import com.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by wangchangyuan on 2017/11/3.
 */
@Service
public class UserServiceImp implements IUserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<UserEntity> selectUserInfo(){
        return userDao.selectUser();
    }
    @Override
    public int insertUserInfo(UserEntity userEntity){
        return userDao.insertUser(userEntity);
    }
}
