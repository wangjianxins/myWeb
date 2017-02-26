package com.wangjianxin.service.manager.impl;

import com.wangjianxin.service.dao.PCommentMapper;
import com.wangjianxin.service.manager.PCommentManager;
import com.wangjianxin.service.model.PComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjianxin on 2017/2/25.
 */
@Service
public class PCommentManagerImpl implements PCommentManager {
    @Autowired
    private PCommentMapper pCommentMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(PComment record) {
        return 0;
    }

    @Override
    public int insertSelective(PComment record) {
       int result =  pCommentMapper.insertSelective(record);
        return result;
    }

    @Override
    public PComment selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(PComment record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(PComment record) {
        return 0;
    }

    @Override
    public List init(int p_id) {
        List result = pCommentMapper.init(p_id);
        return result;
    }
}
