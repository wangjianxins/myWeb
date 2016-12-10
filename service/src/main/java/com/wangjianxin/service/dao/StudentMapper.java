package com.wangjianxin.service.dao;
import com.wangjianxin.service.model.Student;
import java.util.List;

public interface StudentMapper extends BaseObjectMapper<Student,Integer>{
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List selectall();
}