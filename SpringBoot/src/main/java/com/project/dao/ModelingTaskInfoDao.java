package com.project.dao;

import com.project.model.ModelingTaskInfo;

import java.util.List;

/**
 * Created by wangchangyuan on 2017/9/20.
 */
public interface ModelingTaskInfoDao {
    //ModelingTaskInfoDao
    List<ModelingTaskInfo> selectAllModel();
    int insertModel(ModelingTaskInfo modelingTaskInfo);
    int deleteModelTaskInfo(ModelingTaskInfo modelingTaskInfo);
    int updateModelTaskInfo(ModelingTaskInfo modelingTaskInfo);
}
