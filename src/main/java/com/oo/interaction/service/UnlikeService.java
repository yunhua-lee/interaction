package com.oo.interaction.service;

import com.oo.interaction.common.*;
import com.oo.interaction.dao.LikeDao;
import com.oo.interaction.dao.UnlikeDao;
import com.oo.interaction.dao.UserDao;
import com.oo.interaction.model.AbstractUnlike;
import com.oo.interaction.model.Moment;
import com.oo.interaction.utils.HttpApi;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UnlikeService {
    private static final Integer MAX_UNLIKE_COUNT = 10;

    public void add(AbstractUnlike unlike) throws ServiceException {
        Integer userId = unlike.getUserId();
        if(!checkUser(userId)){
            throw new ServiceException(ErrorCode.ADD_001);
        }

        Moment moment = getMoment(unlike.getMomentId());
        if(moment == null){
            throw new ServiceException(ErrorCode.ADD_004);
        }

        if(!checkRelation(userId, moment.getUserId())){
            throw new ServiceException(ErrorCode.ADD_002);
        }

        if(!checkMomentsPermission(userId, moment.getUserId())){
            throw new ServiceException(ErrorCode.ADD_003);
        }

        Integer unlikeCount = UserDao.getUserUnlikeCount(userId);
        if(unlikeCount > MAX_UNLIKE_COUNT){
            throw new ServiceException(ErrorCode.ADD_005);
        }

        if(LikeDao.checkLikeStatus(userId, moment.getMomentId())){
            throw new ServiceException(ErrorCode.ADD_006);
        }

        if(UnlikeDao.checkUnlikeStatus(userId, moment.getMomentId())){
            throw new ServiceException(ErrorCode.ADD_007);
        }

        UnlikeDao.save(unlike);
        UserDao.adduserUnlikeCount(userId, 1);
    }

    private Boolean checkUser(Integer userId) throws ServiceException{
        SimpleResponse response = HttpApi.call(MicroService.MS_USER, "checkUser", userId);
        if(!response.getErrorCode().equals(ResponseCode.SUCCESS)){
            throw new ServiceException(ResponseCode.SYSTEM_EXCEPTION, response.getMessage());
        }

        return (Boolean)response.getData();
    }

    private Boolean checkRelation(Integer userId, Integer friendId) throws ServiceException{
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("friendId", friendId);
        SimpleResponse response = HttpApi.call(MicroService.MS_RELATION, "checkRelation", params);
        if(!response.getErrorCode().equals(ResponseCode.SUCCESS)){
            throw new ServiceException(ResponseCode.SYSTEM_EXCEPTION, response.getMessage());
        }

        return (Boolean)response.getData();
    }

    private Boolean checkMomentsPermission(Integer userId, Integer friendId) throws ServiceException{
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("friendId", friendId);
        SimpleResponse response = HttpApi.call(MicroService.MS_RELATION, "checkMomentsPermission", params);
        if(!response.getErrorCode().equals(ResponseCode.SUCCESS)){
            throw new ServiceException(ResponseCode.SYSTEM_EXCEPTION, response.getMessage());
        }

        return (Boolean)response.getData();
    }

    private Moment getMoment(Integer momentId) throws ServiceException{
        SimpleResponse response = HttpApi.call(MicroService.MS_MOMENT, "getMoment", momentId);
        if(!response.getErrorCode().equals(ResponseCode.SUCCESS)){
            throw new ServiceException(ResponseCode.SYSTEM_EXCEPTION, response.getMessage());
        }

        return (Moment)response.getData();
    }

    public static class ErrorCode{
        //001-用户不存在
        public static final ResultPair ADD_001 = new ResultPair("001", "user not exist");

        //002-非好友关系
        public static final ResultPair ADD_002 = new ResultPair("002", "not friends");

        //003-无朋友圈权限
        public static final ResultPair ADD_003 = new ResultPair("003", "no moments permission");

        //004-动态不存在
        public static final ResultPair ADD_004 = new ResultPair("004", "moment not exist");

        //005-次数超标
        public static final ResultPair ADD_005 = new ResultPair("005", "unlike count exceeds limit");

        //006-已经赞
        public static final ResultPair ADD_006 = new ResultPair("006", "already like");

        //007-已经踩
        public static final ResultPair ADD_007 = new ResultPair("007", "already unlike");
    }
}
