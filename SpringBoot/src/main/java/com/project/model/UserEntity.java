package com.project.model;

/**
 * Created by wangchangyuan on 2017/11/3.
 */
public class UserEntity {
    private int id;
    private String user_name;
    private int age;

    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", age=" + age +
                '}';
    }
}
