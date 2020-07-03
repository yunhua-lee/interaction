package com.oo.interaction.controller;

import com.oo.interaction.common.ResponseCode;
import com.oo.interaction.common.ServiceException;
import com.oo.interaction.common.SimpleResponse;
import com.oo.interaction.model.AbstractUnlike;
import com.oo.interaction.model.AnonymousUnlike;
import com.oo.interaction.model.Unlike;
import com.oo.interaction.service.UnlikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 踩接口
 */
@RestController
public class UnlikeController {

    @Autowired
    private UnlikeService unlikeService;

    /**
     * 添加踩
     * 接口格式：/api/v1/unlike/add?requestId=1000&userId=12345&momentId=100&time=yyyy-MM-dd HH:mm:ss&type=1
     *
     * @return SimpleResponse
     */
    @RequestMapping(value = "/api/v1/unlike/add", method = RequestMethod.POST)
    public SimpleResponse add(@RequestParam(value = "requestId", required = true) String requestId,
                              @RequestParam(value = "userId", required = true) Integer userId,
                              @RequestParam(value = "momentId", required = true) Integer momentId,
                              @RequestParam(value = "time", required = true) String timeStr,
                              @RequestParam(value = "type", required = true) Integer type){
        SimpleResponse response = new SimpleResponse(requestId);

        //简单参数校验，详细的逻辑校验放在UnlikeService实现
        if(userId < 1){
            response.setErrorCode(ResponseCode.INVALID_PARAM);
            response.setMessage("invalid userId: " + userId);

            return response;
        }

        if(momentId < 1){
            response.setErrorCode(ResponseCode.INVALID_PARAM);
            response.setMessage("invalid momentId: " + momentId);

            return response;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time;
        try {
            time = formatter.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
            response.setErrorCode(ResponseCode.INVALID_PARAM);
            response.setMessage("invalid time: " + timeStr);

            return response;
        }

        AbstractUnlike unlike = null;
        if(type == Unlike.TYPE){
            unlike = new Unlike();
        } else if(type == AnonymousUnlike.TYPE){
            unlike = new AnonymousUnlike();
        } else {
            response.setErrorCode(ResponseCode.INVALID_PARAM);
            response.setMessage("invalid type: " + type);

            return response;
        }

        unlike.setUserId(userId);
        unlike.setMomentId(momentId);
        unlike.setTime(time);

        //调用UnlikeService完成具体的业务处理
        try {
            unlikeService.add(unlike);
            response.setErrorCode(ResponseCode.SUCCESS);
        } catch (ServiceException e) {
            e.printStackTrace();

            response.setErrorCode(e.getErrorCode());
            response.setMessage(e.getMessage());
        }

        return response;
    }

    /**
     * 取消踩
     * 接口格式：/api/v1/unlike/delete?requestId=1000&userId=12345&momentId=100
     * @return
     */
    @RequestMapping(value = "/api/v1/unlike/delete", method = RequestMethod.POST)
    public SimpleResponse delete(){
        //省略具体代码实现
        SimpleResponse response = new SimpleResponse("0");
        response.setErrorCode(ResponseCode.UNSUPPORTED);
        response.setMessage("Waiting for you to finish this api……");

        return response;
    }
}
