package com.wangjianxin.service.manager;

import com.wangjianxin.service.model.UserFollow;

/**
 * Created by wangjianxin on 2017/2/13.
 */
public interface UserFollowManager extends BaseObjectManager<UserFollow,Integer> {

    UserFollow checkFollow(int user_id,int taguser_id);

    int Follow(int user_id,int taguser_id,int type);
}
