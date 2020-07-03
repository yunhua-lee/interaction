package com.oo.interaction.model;

public class AnonymousUnlike extends AbstractUnlike {
    public static Integer TYPE = 2;

    /**
     * 获取用户显示名称
     *
     * @return
     */
    @Override
    public String getUserDisplayName() {
        return "anonym";
    }

    /**
     * 获取类型
     *
     * @return
     */
    @Override
    public Integer getType() {
        return null;
    }
}
