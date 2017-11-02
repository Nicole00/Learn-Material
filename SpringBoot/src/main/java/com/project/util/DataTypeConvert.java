package com.project.util;

import com.project.model.ModelingTaskInfo;
import com.hikvision.dataminingprocedure.model.business.BusinessAnalysisTopicEntity;
import com.hikvision.dataminingprocedure.model.business.BusinessPlatformEntity;
import com.hikvision.dataminingprocedure.model.business.RowKeyParamMappingEntity;
import com.hikvision.dataminingprocedure.model.business.RowKeyRuleEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangchangyuan on 2017/9/22.
 */
public class DataTypeConvert {

    //将String 转换为map
    public static Map<String, String> covert2Map(String dataString){
        System.out.println(dataString);
        int len = dataString.length();
        String[] dataArray = dataString.substring(1,len-1).split(",");
        int nums = dataArray.length;
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<nums; i++){
            String[] key_value = dataArray[i].split("\":\"");
            String key = key_value[0].substring(1, key_value[0].length());
            String value = key_value[1].substring(0, key_value[1].length()-1);
            map.put(key, value);
        }
        return map;
    }

    public static ModelingTaskInfo String2ModelingTask(String dataString){
        Map<String, String> map = covert2Map(dataString);
        ModelingTaskInfo modelingTaskInfo = new ModelingTaskInfo();
        modelingTaskInfo.setTask_id(Integer.parseInt(map.get("task_id")));
        modelingTaskInfo.setTask_name(map.get("task_name"));
        modelingTaskInfo.setTask_desc(map.get("task_desc"));
        modelingTaskInfo.setTask_create_time(map.get("task_create_time"));
        modelingTaskInfo.setTask_exec_time(map.get("task_exec_time"));
        modelingTaskInfo.setTask_end_time(map.get("task_end_time"));
        modelingTaskInfo.setTask_state(map.get("task_state"));
        modelingTaskInfo.setMiningtask_type(map.get("miningtask_type"));
        if(map.get("algo_id").equals("") || map.get("algo_id") == null) ;
        else
            modelingTaskInfo.setAlgo_id(Integer.parseInt(map.get("algo_id")));

        modelingTaskInfo.setBusiness_analysis_topic_id(map.get("business_analysis_topic_id"));

        if(map.get("entity_id").equals("") || map.get("entity_id") == null) ;
        else
            modelingTaskInfo.setEntity_id(Integer.parseInt(map.get("entity_id")));

        return modelingTaskInfo;
    }


    public static BusinessAnalysisTopicEntity String2BusinessTopic(String dataString){
        Map<String, String> map = covert2Map(dataString);
        BusinessAnalysisTopicEntity businessAnalysisTopicEntity = new BusinessAnalysisTopicEntity();
        businessAnalysisTopicEntity.setBusiness_analysis_topic_id(Integer.parseInt(map.get("business_analysis_topic_id")));
        businessAnalysisTopicEntity.setBusiness_platform_id(Integer.parseInt(map.get("business_platform_id")));
        businessAnalysisTopicEntity.setBusiness_analysis_name(map.get("business_analysis_name"));
        businessAnalysisTopicEntity.setBusiness_analysis_desc(map.get("business_analysis_desc"));

        return businessAnalysisTopicEntity;
    }


    public static ModelingEntity String2ModelingEntity(String dataString){
        Map<String, String> map = covert2Map(dataString);
        ModelingEntity modelingEntity = new ModelingEntity();
        modelingEntity.setEntity_id(Integer.parseInt(map.get("entity_id")));
        modelingEntity.setModel_entity(map.get("model_entity"));
        modelingEntity.setModel_entity_path(map.get("model_entity_path"));

        return modelingEntity;
    }

    public static BusinessPlatformEntity String2BusinessPlatform(String dataString){
        Map<String, String> map = covert2Map(dataString);
        BusinessPlatformEntity businessPlatformEntity = new BusinessPlatformEntity();
        businessPlatformEntity.setBusiness_platform_id(Integer.parseInt(map.get("business_platform_id")));
        businessPlatformEntity.setPlatform_name(map.get("platform_name"));
        businessPlatformEntity.setPlatform_desc(map.get("platform_desc"));
        businessPlatformEntity.setPlatform_parent_id(map.get("platform_parent_id"));
        businessPlatformEntity.setPlatform_inherit_path(map.get("platform_inherit_path"));
        return businessPlatformEntity;
    }

    public static RowKeyRuleEntity String2RowKeyRule(String dataString){
        Map<String, String> map = covert2Map(dataString);
        RowKeyRuleEntity rowKeyRuleEntity = new RowKeyRuleEntity();
        rowKeyRuleEntity.setRow_key_rule_id(Integer.parseInt(map.get("row_key_rule_id")));
        rowKeyRuleEntity.setRule_name(map.get("rule_name"));
        rowKeyRuleEntity.setRule_clazz(map.get("rule_clazz"));
        rowKeyRuleEntity.setRule_desc(map.get("rule_desc"));
        rowKeyRuleEntity.setRule_default_value(map.get("rule_default_value"));
        return rowKeyRuleEntity;
    }

    public static RowKeyParamMappingEntity String2RowkeyParamMap(String dataString){
        Map<String, String> map = covert2Map(dataString);
        RowKeyParamMappingEntity rowKeyParamMappingEntity = new RowKeyParamMappingEntity();
        rowKeyParamMappingEntity.setMapping_id(Integer.parseInt(map.get("mapping_id")));
        rowKeyParamMappingEntity.setParam_index(map.get("param_index"));
        rowKeyParamMappingEntity.setTransform_id(Integer.parseInt(map.get("transform_id")));
        rowKeyParamMappingEntity.setFeature_attr_id(Integer.parseInt(map.get("feature_attr_id")));
        rowKeyParamMappingEntity.setRow_key_rule_id(Integer.parseInt(map.get("row_key_rule_id")));
        rowKeyParamMappingEntity.setResult_attr_id(Integer.parseInt(map.get("result_attr_id")));
        return rowKeyParamMappingEntity;
    }

    public static AlgorithmTypeEntity String2AlgoType(String dataString){
        Map<String, String> map = covert2Map(dataString);
        AlgorithmTypeEntity algorithmTypeEntity = new AlgorithmTypeEntity();
        algorithmTypeEntity.setAlgorithm_type_id(Integer.parseInt(map.get("algorithm_type_id")));
        algorithmTypeEntity.setAlgorithm_name(map.get("algorithm_name"));
        algorithmTypeEntity.setAlgorithm_desc(map.get("algorithm_desc"));
        return algorithmTypeEntity;
    }

    public static AlgorithmInfo String2Algo(String dataString){
        Map<String, String> map = covert2Map(dataString);
        AlgorithmInfo algorithmInfo = new AlgorithmInfo();
        algorithmInfo.setAlgo_id(Integer.parseInt(map.get("algo_id")));
        algorithmInfo.setAlgo_name(map.get("algo_name"));
        algorithmInfo.setAlgo_desc(map.get("algo_desc"));
        algorithmInfo.setAlgorithm_type_id(Integer.parseInt(map.get("algorithm_type_id")));
        return algorithmInfo;
    }

    public static AlgoParam String2AlgoParam(String dataString){
        Map<String, String> map = covert2Map(dataString);
        AlgoParam algoParam = new AlgoParam();
        algoParam.setAlgo_param_id(Integer.parseInt(map.get("algo_param_id")));
        algoParam.setParam_name(map.get("param_name"));
        algoParam.setParam_default_value(map.get("param_default_value"));
        algoParam.setAlgo_id(Integer.parseInt(map.get("algo_id")));
        algoParam.setParam_type(map.get("param_type"));
        return algoParam;
    }

    public static TaskAlgoMeasureKPIMapping String2MeasureKPI(String dataString){
        Map<String, String> map = covert2Map(dataString);
        TaskAlgoMeasureKPIMapping taskAlgoMeasureKPIMapping = new TaskAlgoMeasureKPIMapping();
        taskAlgoMeasureKPIMapping.setTask_kpi_mapping_id(Integer.parseInt(map.get("task_kpi_mapping_id")));
        taskAlgoMeasureKPIMapping.setTask_id(Integer.parseInt(map.get("task_id")));
        taskAlgoMeasureKPIMapping.setAlgo_measurement_kpi_id(1);
//        taskAlgoMeasureKPIMapping.setAlgo_measurement_kpi_id(Integer.parseInt(map.get("algo_measurement_kpi_id")));
        taskAlgoMeasureKPIMapping.setKpi_value(map.get("kpi_value"));
        return taskAlgoMeasureKPIMapping;
    }

    public static TaskAlgoParamMapEntity String2AlgoParamMap(String dataString){
        Map<String, String> map = covert2Map(dataString);
        TaskAlgoParamMapEntity taskAlgoParamMapEntity = new TaskAlgoParamMapEntity();
        taskAlgoParamMapEntity.setTask_algo_mapping_id(Integer.parseInt(map.get("task_algo_mapping_id")));
        taskAlgoParamMapEntity.setParam_value(map.get("param_value"));
        taskAlgoParamMapEntity.setTask_id(Integer.parseInt(map.get("task_id")));
        taskAlgoParamMapEntity.setAlgo_param_id(Integer.parseInt(map.get("algo_param_id")));
        return taskAlgoParamMapEntity;
    }

    //#########################################特征工程部分的数据转换###############################################


    public static FeatureTaskMappingEntity String2FeatureTaskMap(String dataString){
        Map<String, String> map = covert2Map(dataString);
        FeatureTaskMappingEntity featureTaskMappingEntity = new FeatureTaskMappingEntity();
        featureTaskMappingEntity.setFeature_task_mapping_id(Integer.parseInt(map.get("feature_task_mapping_id")));
        featureTaskMappingEntity.setTask_id(Integer.parseInt(map.get("task_id")));
        featureTaskMappingEntity.setEnable_flag(map.get("enable_flag"));
        featureTaskMappingEntity.setFeature_flag(Integer.parseInt(map.get("feature_flag")));
        featureTaskMappingEntity.setFeature_attr_id(Integer.parseInt(map.get("feature_attr_id")));
        return featureTaskMappingEntity;
    }

    public static FeatureManageEntity String2FeatureManage(String dataString){
        Map<String, String> map = covert2Map(dataString);
        FeatureManageEntity featureManageEntity = new FeatureManageEntity();
        featureManageEntity.setFeature_manage_id(Integer.parseInt(map.get("feature_manage_id")));
        featureManageEntity.setFeature_manage_version(map.get("feature_manage_version"));
        featureManageEntity.setFeature_manage_name(map.get("feature_manage_name"));
        featureManageEntity.setFeature_manage_desc(map.get("feature_manage_desc"));
        featureManageEntity.setBusiness_analysis_topic_id(map.get("business_analysis_topic_id"));
        featureManageEntity.setFeature_manage_type(map.get("feature_manage_type"));
        return featureManageEntity;
    }

    public static FeatureAttrEntity String2FeatureAttr(String dataString){
        Map<String, String> map = covert2Map(dataString);
        FeatureAttrEntity featureAttrEntity = new FeatureAttrEntity();
        featureAttrEntity.setFeature_attr_id(Integer.parseInt(map.get("feature_attr_id")));
        featureAttrEntity.setFeature_name(map.get("feature_name"));
        featureAttrEntity.setFeature_desc(map.get("feature_desc"));
        featureAttrEntity.setFeature_type(map.get("feature_type"));
        featureAttrEntity.setFeature_manage_id(Integer.parseInt(map.get("feature_manage_id")));
        return featureAttrEntity;
    }

    public static FeatureDataPathEntity String2FeatureDataPath(String dataString){
        Map<String, String> map = covert2Map(dataString);
        FeatureDataPathEntity featureDataPathEntity = new FeatureDataPathEntity();
        featureDataPathEntity.setFeature_data_path_id(Integer.parseInt(map.get("feature_data_path_id")));
        featureDataPathEntity.setCreate_time(map.get("create_time"));
        featureDataPathEntity.setIncre_path(map.get("incre_path"));
        featureDataPathEntity.setFull_path(map.get("full_path"));
        featureDataPathEntity.setFeature_manage_id(Integer.parseInt(map.get("feature_manage_id")));
        featureDataPathEntity.setData_source_type(map.get("data_source_type"));
//        featureDataPathEntity.setFeature_data_pathcol(map.get("feature_data_pathcol"));
        featureDataPathEntity.setPath_type(map.get("path_type"));
        return featureDataPathEntity;
    }


    public static RowKeyTransformEntity String2RowKeyTrans(String dataString){
        Map<String, String> map = covert2Map(dataString);
        RowKeyTransformEntity rowKeyTransformEntity = new RowKeyTransformEntity();
        rowKeyTransformEntity.setTransform_id(Integer.parseInt(map.get("transform_id")));
        rowKeyTransformEntity.setRule_id(map.get("rule_id"));
        rowKeyTransformEntity.setFeature_manage_id(Integer.parseInt(map.get("feature_manage_id")));
        rowKeyTransformEntity.setTask_id(Integer.parseInt(map.get("task_id")));
        return rowKeyTransformEntity;
    }


    public static FeatureCodeEntity String2FeatureCode(String dataString){
        Map<String, String> map = covert2Map(dataString);
        FeatureCodeEntity featureCodeEntity = new FeatureCodeEntity();
        featureCodeEntity.setFeature_flag(Integer.parseInt(map.get("feature_flag")));
        featureCodeEntity.setFeature_desc(map.get("feature_desc"));
        featureCodeEntity.setFeature_name(map.get("feature_name"));
        return featureCodeEntity;
    }

    public static FeatureStoreRelEntity String2FeatureStore(String dataString){
        Map<String, String> map = covert2Map(dataString);
        FeatureStoreRelEntity featureStoreRelEntity = new FeatureStoreRelEntity();
        featureStoreRelEntity.setRel_id(Integer.parseInt(map.get("rel_id")));
        featureStoreRelEntity.setFeature_manage_id(Integer.parseInt(map.get("feature_manage_id")));
        featureStoreRelEntity.setStore_medium_info_id(Integer.parseInt(map.get("store_medium_info_id")));
        return featureStoreRelEntity;
    }

    //######################################### 模型结果部分的数据转换###############################################
    public static StoreMediumInfoEntity String2StoreMedium(String dataString){
        Map<String, String> map = covert2Map(dataString);
        StoreMediumInfoEntity storeMediumInfoEntity = new StoreMediumInfoEntity();
        storeMediumInfoEntity.setStore_medium_info_id(Integer.parseInt(map.get("store_medium_info_id")));
        storeMediumInfoEntity.setStore_medium_table_name(map.get("store_medium_table_name"));
        storeMediumInfoEntity.setStore_medium_table_desc(map.get("store_medium_table_desc"));
        return storeMediumInfoEntity;
    }

    public static ModelingResultPathEntity String2ModelResultPath(String dataString){
        Map<String, String> map = covert2Map(dataString);
        ModelingResultPathEntity modelingResultPathEntity = new ModelingResultPathEntity();
        modelingResultPathEntity.setModeling_result_path_id(Integer.parseInt(map.get("modeling_result_path_id")));
        modelingResultPathEntity.setCreate_time(map.get("create_time"));
        modelingResultPathEntity.setIncre_path(map.get("incre_path"));
        modelingResultPathEntity.setFull_path(map.get("full_path"));
        modelingResultPathEntity.setTask_id(Integer.parseInt(map.get("task_id")));
        return modelingResultPathEntity;
    }

    public static ResultAttrEntity String2ResultAttr (String dataString){
        Map<String, String> map = covert2Map(dataString);
        ResultAttrEntity resultAttrEntity = new ResultAttrEntity();
        resultAttrEntity.setResult_attr_id(Integer.parseInt(map.get("result_attr_id")));
        resultAttrEntity.setResult_attr_name(map.get("result_attr_name"));
        resultAttrEntity.setResult_attr_desc(map.get("result_attr_desc"));
        resultAttrEntity.setResult_attr_index(map.get("result_attr_index"));
        resultAttrEntity.setModeling_result_path_id(Integer.parseInt(map.get("modeling_result_path_id")));
        return resultAttrEntity;
    }

    public static TaskStoreRelEntity String2TaskStoreRel(String dataString){
        Map<String, String> map = covert2Map(dataString);
        TaskStoreRelEntity taskStoreRelEntity = new TaskStoreRelEntity();
        taskStoreRelEntity.setRel_id(Integer.parseInt(map.get("rel_id")));
        taskStoreRelEntity.setTask_id(Integer.parseInt(map.get("task_id")));
        taskStoreRelEntity.setStore_medium_info(Integer.parseInt(map.get("store_medium_info")));
        return taskStoreRelEntity;
    }

    public static StoreMediumInfoColFamilyEntity String2StoreMediumCF(String dataString){
        Map<String, String> map = covert2Map(dataString);
        StoreMediumInfoColFamilyEntity storeMediumInfoColFamilyEntity = new StoreMediumInfoColFamilyEntity();
        storeMediumInfoColFamilyEntity.setCol_id(Integer.parseInt(map.get("col_id")));
        storeMediumInfoColFamilyEntity.setCol_family_name(map.get("col_family_name"));
        storeMediumInfoColFamilyEntity.setCol_family_desc(map.get("col_family_desc"));
        storeMediumInfoColFamilyEntity.setStore_medium_info(Integer.parseInt(map.get("store_medium_info")));
        return storeMediumInfoColFamilyEntity;
    }

}
