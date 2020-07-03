package com.oo.interaction.dao;

import com.oo.interaction.model.AbstractUnlike;

/**
 * 踩Dao
 */
public class UnlikeDao {
    public static Boolean checkUnlikeStatus(Integer userId, Integer momentId){
        //省略具体实现，实际开发项目中会查询数据库或Redis之类的存储系统
        return false;
    }

    public static void save(AbstractUnlike unlike){
        //省略具体实现，实际开发项目中会保存到数据库或Redis之类的存储系统
    }
}
