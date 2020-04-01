package com.example.design.demo.interceptor;

import com.example.design.demo.pojo.User;
import com.example.design.demo.secondaryservices.User_TokenService;

import com.example.design.demo.until.UserContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    User_TokenService user_tokenService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("accessToken");
        String c = request.getRequestURI();
        /*if(!Check.contains(c)){
            return true;
        }*/
        /*if (user_tokenService == null) {//解决service为null无法注入问题
            System.out.println("User_TokenService is null!!!");
            BeanFactory factory = WebApplicationContextUtils
                    .getRequiredWebApplicationContext(request.getServletContext());
            user_tokenService = (User_TokenService) factory
                    .getBean("user_tokenService");
        }*/
        if (token != null) {
            //user_tokenService = (User_TokenService) SpringContextUtil.registerBean(user_tokenService.getClass(),"user_tokenService");
            User user = user_tokenService.checktoken(token);
            if (user == null ) {
                returnJson(response,"{\"code\":\"401\",\"info\":\"登录过期\"}");
                return false;
            }
            UserContext.setUser(user);
            return true;
        }else{
            returnJson(response,"{\"code\":\"401\",\"info\":\"登录过期\"}");
            return false;
        }

    }
    private void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
