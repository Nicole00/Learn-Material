package com.project.dao;

import com.project.model.UserEntity;
import java.util.List;
/**
 * Created by wangchangyuan on 2017/11/3.
 */
public interface UserDao {
    List<UserEntity> selectUser();
    int insertUser(UserEntity userEntity);
}
