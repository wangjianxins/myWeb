package com.wangjianxin.service.manager;

import com.wangjianxin.service.model.User;
import java.util.List;

/**
 * Created by wangjianxin on 2016/10/27.
 */
public interface UserManager extends BaseObjectManager<User,Integer>{

    User login(String mob,String pass);

    List check(String email);

    List getName(int user_id);

    List checkName(String name);
}
