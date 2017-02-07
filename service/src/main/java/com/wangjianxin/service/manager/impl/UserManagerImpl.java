package com.wangjianxin.service.manager.impl;

import com.wangjianxin.service.dao.UserMapper;
import com.wangjianxin.service.manager.UserManager;
import com.wangjianxin.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjianxin on 2016/10/27.
 */
@Service
public class UserManagerImpl implements UserManager{

    @Autowired
    private UserMapper userMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        int list = userMapper.insertSelective(record);
        return list;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        User list = userMapper.selectByPrimaryKey(id);
        return list;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        int result = userMapper.updateByPrimaryKeySelective(record);
        return result;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    @Override
    public User login(String email, String pass) {
        Map<String ,Object> map = new HashMap<String ,Object>();
        map.put("email",email);
        map.put("pass",pass);
        User list = userMapper.login(map);
        return list;
    }

    @Override
    public List check(String email) {
        List list = userMapper.check(email);
        return list;
    }

    @Override
    public List getName(int user_id) {
        List list = userMapper.getName(user_id);
        return list;
    }

    @Override
    public List checkName(String name) {
        List list = userMapper.checkName(name);
        return list;
    }
}
