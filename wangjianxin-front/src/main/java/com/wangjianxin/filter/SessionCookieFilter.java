package com.wangjianxin.filter;

import com.wangjianxin.service.model.User;
import com.wangjianxin.util.CookieUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户cookie过期时间拦截器
 */
public class SessionCookieFilter extends HttpServlet implements Filter {
    private static final long serialVersionUID = -6516046520244652987L;


    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User cpsuser = CookieUtil.getUserFromCookie(request);
        if (null != cpsuser) {
            //重新设置cookie的有效期
            CookieUtil.setUserCookie(response, cpsuser, CookieUtil.COOKIE_LIVE_EXPIRY);
        }
        filterChain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }
}

