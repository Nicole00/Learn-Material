package com.project.service;

import com.project.model.ModelingTaskInfo;

import java.util.List;

/**
 * Created by wangchangyuan on 2017/9/20.
 */
public interface IModelingTaskService {
    List<ModelingTaskInfo> selectAll();
    int insertModelingTask(ModelingTaskInfo modelingTaskInfo);
    int deleteModelTask(ModelingTaskInfo modelingTaskInfo);
    int updateModelTask(ModelingTaskInfo modelingTaskInfo);
}
