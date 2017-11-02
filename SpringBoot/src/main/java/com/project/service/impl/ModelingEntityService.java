package com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by wangchangyuan on 2017/9/20.
 */
@Service
public class ModelingEntityService implements IModelingEntityService{
    @Autowired
    ModelingEntityDao modelingEntityDao;

    @Override
    public List<ModelingEntity> selectAll(){
        return modelingEntityDao.selectAllModelEntity();
    }

    @Override
    public int insertModelingEntity(ModelingEntity modelingEntity){
        return modelingEntityDao.insertEntity(modelingEntity);
    }

    @Override
    public int deleteModelingEntity(ModelingEntity modelingEntity){
        return modelingEntityDao.deleteEntity(modelingEntity);
    }
    @Override
    public int updateModeingEntity(ModelingEntity modelingEntity){
        return modelingEntityDao.updateEntity(modelingEntity);
    }
}
