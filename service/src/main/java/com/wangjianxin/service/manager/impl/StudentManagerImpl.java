package com.wangjianxin.service.manager.impl;

import com.wangjianxin.service.dao.StudentMapper;
import com.wangjianxin.service.manager.StudentManager;
import com.wangjianxin.service.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjianxin on 2016/10/26.
 */
@Service
public class StudentManagerImpl implements StudentManager{

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List selectall() {
      List list =   studentMapper.selectall();
        System.out.print(list+  "========");
        return list;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Student record) {
        return 0;
    }

    @Override
    public int insertSelective(Student record) {
        return 0;
    }

    @Override
    public Student selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return 0;
    }
}
