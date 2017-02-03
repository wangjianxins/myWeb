package com.wangjianxin.service.manager;

import com.wangjianxin.service.model.Pfavour;

/**
 * Created by wangjianxin on 2017/2/3.
 */
public interface PfavourManager extends BaseObjectManager<Pfavour ,Integer> {

    Pfavour checkFavour(int user_id,int p_id);

    int updateFavour(int user_id,int type,int p_id);
}
