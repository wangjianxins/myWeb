package com.wangjianxin.service.manager;

import com.wangjianxin.service.model.Star;
import java.util.List;

/**
 * Created by wangjianxin on 2016/11/16.
 */
public interface StarManager extends BaseObjectManager<Star,Integer>{

    List selectAll();
}
