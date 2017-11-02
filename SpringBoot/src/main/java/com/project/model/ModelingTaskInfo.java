package com.project.model;

/**
 * Created by wangchangyuan on 2017/9/20.
 */
public class ModelingTaskInfo {
    private int task_id;
    private String task_name;
    private String task_desc;
    private String task_create_time;
    private String task_exec_time;
    private String task_end_time;
    private String task_state;
    private String miningtask_type;
    private int algo_id;
    private String business_analysis_topic_id;
    private int entity_id;

    public int getTask_id() {
        return task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public String getTask_desc() {
        return task_desc;
    }

    public String getTask_create_time() {
        return task_create_time;
    }

    public String getTask_exec_time() {
        return task_exec_time;
    }

    public String getTask_end_time() {
        return task_end_time;
    }

    public String getTask_state() {
        return task_state;
    }

    public String getMiningtask_type() {
        return miningtask_type;
    }

    public int getAlgo_id() {
        return algo_id;
    }

    public String getBusiness_analysis_topic_id() {
        return business_analysis_topic_id;
    }

    public int getEntity_id() {
        return entity_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public void setTask_desc(String task_desc) {
        this.task_desc = task_desc;
    }

    public void setTask_create_time(String task_create_time) {
        this.task_create_time = task_create_time;
    }

    public void setTask_exec_time(String task_exec_time) {
        this.task_exec_time = task_exec_time;
    }

    public void setTask_end_time(String task_end_time) {
        this.task_end_time = task_end_time;
    }

    public void setTask_state(String task_state) {
        this.task_state = task_state;
    }

    public void setMiningtask_type(String miningtask_type) {
        this.miningtask_type = miningtask_type;
    }

    public void setAlgo_id(int algo_id) {
        this.algo_id = algo_id;
    }

    public void setBusiness_analysis_topic_id(String business_analysis_topic_id) {
        this.business_analysis_topic_id = business_analysis_topic_id;
    }

    public void setEntity_id(int entity_id) {
        this.entity_id = entity_id;
    }

    @Override
    public String toString() {
        return "ModelingTaskInfo{" +
                "task_id=" + task_id +
                ", task_name='" + task_name + '\'' +
                ", task_desc='" + task_desc + '\'' +
                ", task_create_time='" + task_create_time + '\'' +
                ", task_exec_time='" + task_exec_time + '\'' +
                ", task_end_time='" + task_end_time + '\'' +
                ", task_state='" + task_state + '\'' +
                ", miningtask_type='" + miningtask_type + '\'' +
                ", algo_id=" + algo_id +
                ", business_analysis_topic_id='" + business_analysis_topic_id + '\'' +
                ", entity_id=" + entity_id +
                '}';
    }
}
