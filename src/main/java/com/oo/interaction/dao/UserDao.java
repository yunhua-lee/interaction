package com.oo.interaction.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用户Dao
 */
public class UserDao {
    //用ConcurrentHashMap模拟实现存储,实际开发项目中需要使用数据库或Redis之类的存储系统
    private static final Map<Integer, AtomicInteger> userCount= new ConcurrentHashMap<>();

    public static Integer getUserUnlikeCount(Integer userId){

        AtomicInteger countObj = userCount.get(userId);
        if(countObj == null){
            return 0;
        }

        return countObj.get();
    }

    public static void addUserUnlikeCount(Integer userId, Integer count){
        AtomicInteger countObj;
        if(!userCount.containsKey(userId)){
            countObj = new AtomicInteger(0);
            userCount.putIfAbsent(userId, countObj);
        }

        countObj = userCount.get(userId);
        countObj.addAndGet(count);

        return;
    }
}
