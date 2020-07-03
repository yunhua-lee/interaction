package com.oo.interaction.dao;

/**
 * 用户Dao
 */
public class UserDao {
    public static Integer getUserUnlikeCount(Integer userId){
        //省略具体实现，实际开发项目中会查询数据库或Redis之类的存储系统
        return 10;
    }

    public static void adduserUnlikeCount(Integer userId, Integer count){
        //省略具体实现，实际开发项目中会修改数据库或Redis之类的存储系统
    }
}
