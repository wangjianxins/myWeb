package com.wangjianxin.service.manager;
import com.wangjianxin.service.model.Student;

import java.util.List;

/**
 * Created by wangjianxin on 2016/10/26.
 */
public interface StudentManager extends BaseObjectManager<Student,Integer>{
    List selectall();
}
