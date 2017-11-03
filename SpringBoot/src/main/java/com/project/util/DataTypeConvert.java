package com.project.util;

import com.project.model.UserEntity;

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

    public static UserEntity String2User(String dataString){
        Map<String, String> map = covert2Map(dataString);
        UserEntity userEntity = new UserEntity();
        userEntity.setId(Integer.parseInt(map.get("id")));
        userEntity.setUser_name(map.get("user_name"));
        if(map.get("age").equals("") || map.get("age") == null);
        else
            userEntity.setAge(Integer.parseInt(map.get("age")));

        return userEntity;
    }

}
