package com.wangjianxin.service.dao;

import com.wangjianxin.service.model.User;

import java.util.Map;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(Map map);

    List check(String email);

    List getName(int user_id);
}