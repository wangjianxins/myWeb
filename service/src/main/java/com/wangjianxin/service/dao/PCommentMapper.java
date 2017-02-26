package com.wangjianxin.service.dao;

import com.wangjianxin.service.model.PComment;
import java.util.List;
public interface PCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PComment record);

    int insertSelective(PComment record);

    PComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PComment record);

    int updateByPrimaryKey(PComment record);

    List init(int p_id);
}