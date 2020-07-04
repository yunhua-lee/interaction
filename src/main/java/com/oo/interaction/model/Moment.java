package com.oo.interaction.model;

import java.util.Date;

public class Moment {
    private Integer momentId;
    private Integer userId;
    private Date time;
    private String content;

    public Moment(Integer momentId){
        this.momentId = momentId;
    }
    public Integer getMomentId() {
        return momentId;
    }

    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
