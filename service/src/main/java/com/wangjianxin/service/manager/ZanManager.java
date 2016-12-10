package com.wangjianxin.service.manager;

import com.wangjianxin.service.dao.BaseObjectMapper;
import com.wangjianxin.service.model.Zan;
import java.util.List;

/**
 * Created by wangjianxin on 2016/11/2.
 */
public interface ZanManager extends BaseObjectMapper<Zan,Integer>{

    Zan check(Zan zan);

    int updatezan(int article_id,int user_id, int type);
}
