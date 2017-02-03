package com.wangjianxin.service.manager;

import com.wangjianxin.service.dao.BaseObjectMapper;
import com.wangjianxin.service.model.P;

import java.util.List;
/**
 * Created by wangjianxin on 2017/1/16.
 */
public interface PManager extends BaseObjectMapper {

    List initp(int pagenum,int pagesize);

    int pcount();

    List recommend();

    List howword(int user_id);

    P select(int id);

    int insertArticle(P p);

    int checkNum(int user_id);

    int look(int p_id);

    int favour(int p_id,int type);

    int likenum(int p_id);
}
