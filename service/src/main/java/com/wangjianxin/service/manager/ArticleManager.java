package com.wangjianxin.service.manager;

import com.wangjianxin.service.model.Article;

import java.util.List;

/**
 * Created by wangjianxin on 2016/11/2.
 */
public interface ArticleManager extends BaseObjectManager<Article,Integer>{

    List show(int pagenum,int size);

    int count();

    int zan(int article_id,int user_id,int type);

    List paihang();
}
