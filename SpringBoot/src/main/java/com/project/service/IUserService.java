package com.project.service;

import com.project.model.UserEntity;
import java.util.List;
/**
 * Created by wangchangyuan on 2017/11/3.
 */
public interface IUserService {
    List<UserEntity> selectUserInfo();
    int insertUserInfo(UserEntity userEntity);
}
