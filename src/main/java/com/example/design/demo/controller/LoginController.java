package com.example.design.demo.controller;

import com.example.design.demo.entity.UserToken;
import com.example.design.demo.pojo.Result;
import com.example.design.demo.pojo.User;
import com.example.design.demo.primatyservices.UserService;
import com.example.design.demo.secondaryservices.User_TokenService;
import com.example.design.demo.until.JwtUntil;
import org.hibernate.query.criteria.internal.ValueHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    User_TokenService user_tokenService;
    static final long time = 24*60*60*1000;

    @CrossOrigin
    @PostMapping("api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        String username = requestUser.getUsername();
        //对请求体进行html转义，防止XSS攻击
        username = HtmlUtils.htmlEscape(username);
        /*if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            return new Result(200);
        }*/
        User user = userService.get(username, requestUser.getPassword());
        String userid = String.valueOf(user.getId());
        if(null==user){
            return new Result(400);
        }else{
            UserToken userToken = user_tokenService.getone(user.getId());
            String token = null;
            //如果拿到的对象是空的，就创建新的token对象和在数据库建立新的索引
            if(userToken!=null){
                token = userToken.getToken();
            }else{
                token = JwtUntil.sign(userid,username);
                long timeout = System.currentTimeMillis() + time;
                UserToken userToken1 = new UserToken(user.getId(),token,timeout);
                user_tokenService.addOrupdate(userToken1);
            }

            //String token = JwtUntil.sign(userid,username);
            //long timeout = System.currentTimeMillis() + time;
            //UserToken userToken = new UserToken(user.getId(),token,timeout);
            /*UserToken userToken1 = user_tokenService.findByToken(userToken.getToken());
            boolean flag = user_tokenService.isfindByToken(userToken.getToken());
            if(flag){
                if(userToken.getTimeout()-userToken1.getTimeout()>0){
                    user_tokenService.update(userToken.getTimeout(),userToken.getToken());
                }else {
                    //token有效时间已经过，要在数据库中

                }*/
                //user_tokenService.addOrupdate(userToken);
            return new Result(200,token);
        }
    }
}

