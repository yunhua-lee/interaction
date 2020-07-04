package com.oo.interaction.dao;

import com.oo.interaction.model.AbstractUnlike;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 踩Dao
 */
public class UnlikeDao {
    //用ConcurrentHashMap模拟实现存储,实际开发项目中需要使用数据库或Redis之类的存储系统
    private static final Map<String, AtomicBoolean> unlikeData= new ConcurrentHashMap<>();

    public static Boolean checkUnlikeStatus(Integer userId, Integer momentId){

        String key = buildKey(userId, momentId);
        AtomicBoolean data = unlikeData.get(key);

        return data == null?false : data.get();
    }

    public static void save(AbstractUnlike unlike){
        String key = buildKey(unlike.getUserId(), unlike.getMomentId());
        AtomicBoolean data;
        if(!unlikeData.containsKey(key)){
            data = new AtomicBoolean(true);
            unlikeData.putIfAbsent(key, data);
        }
        data = unlikeData.get(key);
        data.set(true);

        return;
    }

    private static String buildKey(Integer userId, Integer momentId){
        return userId + "-" + momentId;
    }
}
