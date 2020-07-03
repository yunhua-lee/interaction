package com.oo.interaction.model;

public class Unlike extends AbstractUnlike {
    public static Integer TYPE = 1;

    /**
     * 获取用户显示名称
     *
     * @return
     */
    @Override
    public String getUserDisplayName() {
        return getUserRealName();
    }

    /**
     * 获取类型
     *
     * @return
     */
    @Override
    public Integer getType() {
        return TYPE;
    }
}
