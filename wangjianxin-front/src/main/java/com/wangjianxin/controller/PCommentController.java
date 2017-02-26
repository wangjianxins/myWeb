package com.wangjianxin.controller;
import com.wangjianxin.service.manager.PCommentManager;
import com.wangjianxin.service.model.PComment;
import com.wangjianxin.service.model.User;
import com.wangjianxin.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.nio.cs.ext.PCK;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangjianxin on 2017/2/25.
 */
@RequestMapping("/comment")
@Controller
public class PCommentController extends MyBaseController {

    @Autowired
    private PCommentManager pCommentManager;

    @RequestMapping(value = "/pc.json",method = RequestMethod.POST)
    @ResponseBody
    public String pc(@RequestParam(value = "p_id") int p_id,
                     @RequestParam(value = "comment") String comment,
                     HttpServletRequest request){
        User user = CookieUtil.getUserFromCookie(request);
        if(user != null){//用户未登录不能提交
            int user_id = user.getId();
            String newcontext = stripHtml(comment).trim();//过滤
            if(newcontext.equals("") || newcontext == null){//不能提交空内容
                return toJson(98);
            }else{
                PComment pComment = new PComment();
                pComment.setpId(p_id);
                pComment.setUserId(user_id);
                pComment.setComment(newcontext);
                int reuslt = pCommentManager.insertSelective(pComment);
                return toJson(reuslt);
            }
        }else{
            return toJson(97);
        }
    }

    @RequestMapping("/init.json")
    @ResponseBody
    public String init(@RequestParam(value = "p_id") int p_id,Model model){
        List result = pCommentManager.init(p_id);
        model.addAttribute(result);
        return toJson(result);

    }
}
