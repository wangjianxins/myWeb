package com.wangjianxin.service.manager;

import com.wangjianxin.service.model.PComment;
import java.util.List;
/**
 * Created by wangjianxin on 2017/2/25.
 */
public interface PCommentManager extends BaseObjectManager<PComment,Integer> {

    List init(int p_id);

}
