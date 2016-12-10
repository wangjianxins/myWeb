package com.wangjianxin.controller;

import com.wangjianxin.service.manager.ArticleManager;
import com.wangjianxin.service.manager.IndexWordManager;
import com.wangjianxin.service.manager.ZanManager;
import com.wangjianxin.service.model.Article;
import com.wangjianxin.service.model.Zan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
/**
 * Created by wangjianxin on 2016/11/1.
 */
@Controller
@RequestMapping("/artic")
public class ArticleController extends MyBaseController{

    @Autowired
    private IndexWordManager indexWordManager;
    @Autowired
    private ArticleManager articleManager;
    @Autowired
    private ZanManager zanManager;

    /**
     *
     * pagesize：一页显示多少条
     * pagenum:第几页
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/show.json",method = RequestMethod.GET)
    public String show(@RequestParam(value = "pagesize") int size,
                       @RequestParam(value = "pagenum") int pagenum){
        List list = articleManager.show(pagenum,size);
        return toJson(list);
    }

    @ResponseBody
    @RequestMapping(value = "/count.json",method = RequestMethod.GET)
    public String count(){
        int result = articleManager.count();
        return toJson(result);
    }

    /**
     * 发表
     * @param content
     * @param user_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/send.json",method = RequestMethod.GET)
    public String send(@RequestParam(value = "content") String content,
                       @RequestParam(value = "user_id") int user_id){
        Article article = new Article();
        article.setContent(content);
        article.setUserId(user_id);
        int result = articleManager.insertSelective(article);
        System.out.println(result);
        return toJson(result);
    }

    /**
     * 赞
     * @param article_id
     * @param user_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/zan.json",method = RequestMethod.GET)
    public String zan(@RequestParam(value = "article_id") int article_id,
                       @RequestParam(value = "user_id") int user_id){
        Zan zan = new Zan();
        zan.setArticleId(article_id);
        zan.setUserId(user_id);
        int result =0;
        int zanresult =0;
        int zanm_num=0;
        Zan zans = zanManager.check(zan);
        if (null != zans && zans.getFlag()==0){
            zanresult = articleManager.zan(article_id,user_id,0);
            result= zanManager.updatezan(article_id,user_id,0);
            //最新查询赞数
            Article article = articleManager.selectByPrimaryKey(article_id);
            zanm_num = article.getZan();
        }if(null == zans){
            zanresult = articleManager.zan(article_id,user_id,1);
            result= zanManager.insertSelective(zan);
            //最新查询赞数
            Article article = articleManager.selectByPrimaryKey(article_id);
            zanm_num = article.getZan();
        }if(null != zans && zans.getFlag()==1){
            zanresult = articleManager.zan(article_id,user_id,1);
            result=zanManager.updatezan(article_id,user_id,1);
            //最新查询赞数
            Article article = articleManager.selectByPrimaryKey(article_id);
            zanm_num = article.getZan();
        }
        return toJson(result,"",zanm_num);
    }
    /**
     * 检查赞
     * @param article_id
     * @param user_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkzan.json",method = RequestMethod.GET)
    public String checkzan(@RequestParam(value = "article_id") int article_id,
                      @RequestParam(value = "user_id") int user_id){
        int result = 0;
        Zan zan = new Zan();
        zan.setArticleId(article_id);
        zan.setUserId(user_id);
        Zan zans = zanManager.check(zan);
        if (null != zans && zans.getFlag()==0){
            result =99;
        }else{
            result = 98;
        }
        return toJson(result);
    }
}
