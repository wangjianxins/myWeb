package com.wangjianxin.service.manager;

import com.wangjianxin.service.model.IndexWord;
import java.util.List;
/**
 * Created by wangjianxin on 2016/11/1.
 */
public interface IndexWordManager extends BaseObjectManager<IndexWord,Integer>{

    String getWord();

    List show(int pagenum,int size);

    int count();
}
