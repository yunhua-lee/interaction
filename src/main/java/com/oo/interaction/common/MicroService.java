package com.oo.interaction.common;

/**
 * 系统微服务列表
 */
public enum MicroService {
    MS_INTERACTION, //对应系统设计序列图中的互动子系统interactionService
    MS_MOMENT,      //对应系统设计序列图中的动态子系统momentService
    MS_USER,        //对应系统设计序列图中的用户子系统userService
    MS_RELATION     //对应系统设计序列图中的关系子系统relationService
}
