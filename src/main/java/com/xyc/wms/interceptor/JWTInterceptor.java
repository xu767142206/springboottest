package com.xyc.wms.interceptor;

import com.xyc.wms.utils.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        //从请求头内获取token
        String token = request.getHeader("authorization");

        //验证令牌，如果令牌不正确会出现异常会被全局异常处理
        return JwtUtils.verifyToken(token);
    }
}
