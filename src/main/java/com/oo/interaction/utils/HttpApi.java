package com.oo.interaction.utils;

import com.oo.interaction.common.MicroService;
import com.oo.interaction.common.ResponseCode;
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
        //省略具体实现，默认返回成功，让程序能够跑通正常流程
        SimpleResponse result = new SimpleResponse("00000");
        result.setErrorCode(ResponseCode.SUCCESS);
        result.setMessage("success");
        result.setData(new Object());

        return result;
    }
}
