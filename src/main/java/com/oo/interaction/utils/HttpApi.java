package com.oo.interaction.utils;

import com.oo.interaction.common.MicroService;
import com.oo.interaction.common.SimpleResponse;

/**
 * 调用其它微服务系统接口
 */
public class HttpApi {

    /**
     *
     * @param microService 微服务类型
     * @param apiName      api名称
     * @param apiParam     api参数
     *
     * @return SimpleResponse
     */
    public static SimpleResponse call(MicroService microService, String apiName, Object apiParam){
        //省略具体实现

        return null;
    }
}
