package com.project.controller;

import com.project.model.ModelingTaskInfo;
import com.project.service.impl.ModelingEntityService;
import com.hikvision.dataminingprocedure.service.Business.impl.BusinessAnalysisService;
import com.project.util.DataTypeConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangchangyuan on 2017/9/20.
 */
@Controller
public class ModelingController {

    private static final String INDEX_VIEW = "modelingTask/index";
    @Autowired
    private ModelingTaskService modelingTaskService;
    @Autowired
    private BusinessAnalysisService businessAnalysisService;
    @Autowired
    private ModelingEntityService modelingEntityService;
    @Autowired
    private AlgoParamService algoParamService;
    @Autowired
    private AlgorithmInfoService algorithmInfoService;
    @Autowired
    private TaskAlgoMeasureKPIMappingService taskAlgoMeasureKPIMappingService;
    @Autowired
    private TaskAlgoParamMapService taskAlgoParamMapService;

    /******************************************* ModelingTaskInfoController控制器 **************************************************************/
    //select 展示数据
    @RequestMapping(value = {"model/index", "model/index/"}, method = RequestMethod.GET)
    public String selectModelTask(Model model) {
        model.addAttribute("modelingTasks", modelingTaskService.selectAll());
        model.addAttribute("algos", algorithmInfoService.selectAll());
        model.addAttribute("businessTopics", businessAnalysisService.selectAll());
        model.addAttribute("modelEntitys", modelingEntityService.selectAll());
        return INDEX_VIEW;
    }

    //增加数据到数据库  insert
    @ResponseBody
    @RequestMapping(value = {"/model/task"}, method = RequestMethod.POST)
    public void addModelTask(String task){
        System.out.println("task: " + task);
        ModelingTaskInfo modelingTaskInfo = DataTypeConvert.String2ModelingTask(task);
        System.out.println(modelingTaskInfo);
        modelingTaskService.insertModelingTask(modelingTaskInfo);
    }

    //删除一条modelTaskInfo数据
    @ResponseBody
    @RequestMapping(value = {"/model/deleteModelTask"}, method = RequestMethod.POST)
    public void delModelTask(String record){
        System.out.println("record: " + record);
        ModelingTaskInfo modelingTaskInfo = DataTypeConvert.String2ModelingTask(record);
        System.out.println(modelingTaskInfo);
        modelingTaskService.deleteModelTask(modelingTaskInfo);
    }

    //更新一条modelTaskInfo数据
    @ResponseBody
    @RequestMapping(value = {"/model/updateModelTask"}, method = RequestMethod.POST)
    public void updateModelTask(String modelRecord){
        System.out.println("modelRecord: " + modelRecord);
        ModelingTaskInfo modelingTaskInfo = DataTypeConvert.String2ModelingTask(modelRecord);
        System.out.println(modelingTaskInfo);
        modelingTaskService.updateModelTask(modelingTaskInfo);
    }

/****************************************** ModelingEntityController控制器 ***************************************************************/

    //select 展示数据
    @RequestMapping(value = {"modelEntity/index", "modelEntity/index/"}, method = RequestMethod.GET)
    public String selectEntity(Model model) {
        model.addAttribute("modelingEntities", modelingEntityService.selectAll());
        return "modelingTask/entity";
    }

    //add增加数据
    @ResponseBody
    @RequestMapping(value = {"/modelEntity/entity"}, method = RequestMethod.POST)
    public void addModelEntity(String entity){
        System.out.println("entity: " + entity);
        ModelingEntity modelingEntity = DataTypeConvert.String2ModelingEntity(entity);
        System.out.println(modelingEntity);
        modelingEntityService.insertModelingEntity(modelingEntity);
    }
    //删除一条modelTaskInfo数据
    @ResponseBody
    @RequestMapping(value = {"/modelEntity/deleteModelEntity"}, method = RequestMethod.POST)
    public void delModelEntity(String record){
        System.out.println("record: " + record);
        ModelingEntity modelingEntity = DataTypeConvert.String2ModelingEntity(record);
        System.out.println(modelingEntity);
        modelingEntityService.deleteModelingEntity(modelingEntity);
    }

    //更新一条modelingEntity数据
    @ResponseBody
    @RequestMapping(value = {"/modelEntity/updateModelEntity"}, method = RequestMethod.POST)
    public void updateModelEntity(String ModelEntity){
        System.out.println("ModelEntity: " + ModelEntity);
        ModelingEntity modelingEntity = DataTypeConvert.String2ModelingEntity(ModelEntity);
        System.out.println(modelingEntity);
        modelingEntityService.updateModeingEntity(modelingEntity);
    }

    /*********************************************************************************************************/
    //AlgoParamController控制器
    @RequestMapping(value = {"algo_param/index", "algo_param/index/"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("algoParams", algoParamService.selectAll());
        model.addAttribute("algoInfos", algorithmInfoService.selectAll());
        return "algoParam/index";
    }

    //获取表单数据 并插入数据库
    @ResponseBody
    @RequestMapping(value = {"/algo_param/param"}, method = RequestMethod.POST)
    public void addAlgorithmParam(String params){
        System.out.println("params: " + params);
        AlgoParam algoParam = DataTypeConvert.String2AlgoParam(params);
        System.out.println(algoParam);
        algoParamService.insertAlgoParam(algoParam);
    }

    //删除一条AlgoInfo数据
    @ResponseBody
    @RequestMapping(value = {"/algo_param/deleteAlgoParam"}, method = RequestMethod.POST)
    public void delAlgorithmParam(String record){
        System.out.println("record: " + record);
        AlgoParam algoParam = DataTypeConvert.String2AlgoParam(record);
        System.out.println(algoParam);
        algoParamService.deleteAlgoParam(algoParam);
    }

    //更新一条AlgoInfo数据
    @ResponseBody
    @RequestMapping(value = {"/algo_param/updateAlgoParam"}, method = RequestMethod.POST)
    public void updateAlgorithmParam(String AlgoParam){
        System.out.println("AlgoParam: " + AlgoParam);
        AlgoParam algoParam = DataTypeConvert.String2AlgoParam(AlgoParam);
        System.out.println(algoParam);
        algoParamService.updateAlgoParam(algoParam);
    }



    /***************************************** AlgorithmInfoController的控制器 ****************************************************************/
    //select 展示数据
    @RequestMapping(value = {"algoInfo/index", "algoInfo/index/"}, method = RequestMethod.GET)
    public String selectAlgoInfo(Model model) {
        model.addAttribute("Algorithms", algorithmInfoService.selectAll());
        model.addAttribute("algorithmTypes", algorithmInfoService.selectType());
        return "algoParam/info";
    }

    //获取表单数据 并插入数据库
    @ResponseBody
    @RequestMapping(value = {"/algoInfo/algoInfo"}, method = RequestMethod.POST)
    public void addAlgoInfo(String algoInfo){
        System.out.println("algoInfo: " + algoInfo);
        AlgorithmInfo algorithmInfo = DataTypeConvert.String2Algo(algoInfo);
        System.out.println(algorithmInfo);
        algorithmInfoService.insertAlgorithm(algorithmInfo);
    }

    //删除一条AlgoInfo数据
    @ResponseBody
    @RequestMapping(value = {"/algoInfo/deleteAlgoInfo"}, method = RequestMethod.POST)
    public void delAlgoInfo(String record){
        System.out.println("record: " + record);
        AlgorithmInfo algorithmInfo = DataTypeConvert.String2Algo(record);
        System.out.println(algorithmInfo);
        algorithmInfoService.deleteAlgorithm(algorithmInfo);
    }

    //更新一条AlgoInfo数据
    @ResponseBody
    @RequestMapping(value = {"/algoInfo/updateAlgoInfo"}, method = RequestMethod.POST)
    public void updateAlgoInfo(String AlgoInfo){
        System.out.println("AlgoInfo: " + AlgoInfo);
        AlgorithmInfo algorithmInfo = DataTypeConvert.String2Algo(AlgoInfo);
        System.out.println(algorithmInfo);
        algorithmInfoService.updateAlgorithm(algorithmInfo);
    }

    /******************************************* algorithm_type 的Controller **************************************************************/
    //select 展示数据
    @GetMapping(value = {"algoInfo/type"})
    public String selectType(Model model){
        model.addAttribute("AlgoTypes", algorithmInfoService.selectType());
        return "algoParam/type";
    }


    @ResponseBody
    @RequestMapping(value = {"/algoInfo/type"}, method = RequestMethod.POST)
    public void addAlgoType(String algoTypes){
        System.out.println("algoTypes: " + algoTypes);
        AlgorithmTypeEntity algorithmTypeEntity = DataTypeConvert.String2AlgoType(algoTypes);
        System.out.println(algorithmTypeEntity);
        algorithmInfoService.insertType(algorithmTypeEntity);
    }

    //删除一条AlgoType数据
    @ResponseBody
    @RequestMapping(value = {"/algoInfo/deleteAlgoType"}, method = RequestMethod.POST)
    public void delAlgoType(String record){
        System.out.println("record: " + record);
        AlgorithmTypeEntity algorithmTypeEntity = DataTypeConvert.String2AlgoType(record);
        System.out.println(algorithmTypeEntity);
        algorithmInfoService.deleteAlgorithmType(algorithmTypeEntity);
    }

    //更新一条AlgoType数据
    @ResponseBody
    @RequestMapping(value = {"/algoInfo/updateAlgoType"}, method = RequestMethod.POST)
    public void updateAlgoType(String AlgoType){
        System.out.println("AlgoType: " + AlgoType);
        AlgorithmTypeEntity algorithmTypeEntity = DataTypeConvert.String2AlgoType(AlgoType);
        System.out.println(algorithmTypeEntity);
        algorithmInfoService.updateAlgorithmType(algorithmTypeEntity);
    }


    /*********************************************************************************************************/
    //TaskAlgoMeasureKPIMappingController控制器
    @RequestMapping(value = {"algo_kpi/index", "algo_kpi/index/"}, method = RequestMethod.GET)
    public String selectKPIMapping(Model model) {
        model.addAttribute("KPIMappings", taskAlgoMeasureKPIMappingService.selectAll());
        model.addAttribute("tasks", modelingTaskService.selectAll());
        return "modelingTask/kpi";
    }

    //获取表单数据 并插入数据库
    @ResponseBody
    @RequestMapping(value = {"/algo_kpi/kpi"}, method = RequestMethod.POST)
    public void addKPIMapping(String kpis){
        System.out.println("kpis: " + kpis);
        TaskAlgoMeasureKPIMapping taskAlgoMeasureKPIMapping = DataTypeConvert.String2MeasureKPI(kpis);
        System.out.println(taskAlgoMeasureKPIMapping);
        taskAlgoMeasureKPIMappingService.insertKPIMap(taskAlgoMeasureKPIMapping);
    }

    //删除一条KPIMapping数据
    @ResponseBody
    @RequestMapping(value = {"/algo_kpi/deleteKPIMap"}, method = RequestMethod.POST)
    public void delKPIMapping(String record){
        System.out.println("record: " + record);
        TaskAlgoMeasureKPIMapping taskAlgoMeasureKPIMapping = DataTypeConvert.String2MeasureKPI(record);
        System.out.println(taskAlgoMeasureKPIMapping);
        taskAlgoMeasureKPIMappingService.deleteKPIMap(taskAlgoMeasureKPIMapping);
    }

    //更新一条KPIMapping数据
    @ResponseBody
    @RequestMapping(value = {"/algo_kpi/updateKPIMap"}, method = RequestMethod.POST)
    public void updateKPIMapping(String KPIMap){
        System.out.println("KPIMap: " + KPIMap);
        TaskAlgoMeasureKPIMapping taskAlgoMeasureKPIMapping = DataTypeConvert.String2MeasureKPI(KPIMap);
        System.out.println(taskAlgoMeasureKPIMapping);
        taskAlgoMeasureKPIMappingService.updateKPIMap(taskAlgoMeasureKPIMapping);
    }


    /************************************** TaskAlgoParamMappingController控制器 ********************************/
    //select TaskAlgoParamMap数据
    @RequestMapping(value = {"model/algoParamMap", "model/algoParamMap/"}, method = RequestMethod.GET)
    public String selectTaskAlgoParamMap(Model model) {
        model.addAttribute("algoParams", algoParamService.selectAll());
        model.addAttribute("tasks", modelingTaskService.selectAll());
        model.addAttribute("algoParamMaps", taskAlgoParamMapService.selectTaskAlgoParam());
        return "algoParam/algoParamMap";
    }

    //获取表单数据 并插入数据库
    @ResponseBody
    @RequestMapping(value = {"/model/addAlgoParamMap"}, method = RequestMethod.POST)
    public void addTaskAlgoParamMap(String TaskAlgoParamMaps){
        System.out.println("TaskAlgoParamMaps: " + TaskAlgoParamMaps);
        TaskAlgoParamMapEntity taskAlgoParamMapEntity = DataTypeConvert.String2AlgoParamMap(TaskAlgoParamMaps);
        System.out.println(taskAlgoParamMapEntity);
        taskAlgoParamMapService.insertTaskAlgoParam(taskAlgoParamMapEntity);
    }

    //删除一条AlgoParamMap数据
    @ResponseBody
    @RequestMapping(value = {"/model/deleteAlgoParamMap"}, method = RequestMethod.POST)
    public void delTaskAlgoParamMap(String record){
        System.out.println("record: " + record);
        TaskAlgoParamMapEntity taskAlgoParamMapEntity = DataTypeConvert.String2AlgoParamMap(record);
        System.out.println(taskAlgoParamMapEntity);
        taskAlgoParamMapService.deleteTaskAlgoParam(taskAlgoParamMapEntity);
    }

    //更新一条AlgoParamMapg数据
    @ResponseBody
    @RequestMapping(value = {"/model/updateAlgoParamMap"}, method = RequestMethod.POST)
    public void updateTaskAlgoParamMap(String TaskAlgoParamMaps){
        System.out.println("TaskAlgoParamMaps: " + TaskAlgoParamMaps);
        TaskAlgoParamMapEntity taskAlgoParamMapEntity = DataTypeConvert.String2AlgoParamMap(TaskAlgoParamMaps);
        System.out.println(taskAlgoParamMapEntity);
        taskAlgoParamMapService.updateTaskAlgoParam(taskAlgoParamMapEntity);
    }

}
