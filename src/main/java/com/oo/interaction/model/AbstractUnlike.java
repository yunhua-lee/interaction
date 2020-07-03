package com.oo.interaction.model;

import java.util.Date;

public abstract class AbstractUnlike {
    private Integer userId;
    private Integer momentId;
    private Date time;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMomentId() {
        return momentId;
    }

    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取用户真实名称
     * @return
     */
    public String getUserRealName(){
        //Todo
        return "";
    }

    /**
     * 获取用户显示名称
     * @return
     */
    public abstract String getUserDisplayName();

    /**
     * 获取类型
     * @return
     */
    public abstract Integer getType();
}
