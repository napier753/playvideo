package com.example.design.demo.controller;

import com.example.design.demo.entity.UserToken;
import com.example.design.demo.pojo.User;
import com.example.design.demo.secondaryservices.User_TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class User_Token_Controller {
    @Autowired
    User_TokenService user_tokenService;

    @CrossOrigin
    @GetMapping("api/gettoken")
    public UserToken getone(@RequestHeader int id){
        if(0!=id){
            return user_tokenService.getone(id);
        }else
            return null;
    }

    @CrossOrigin
    @GetMapping("api/getbytoken")
    public User getwithtoken(@RequestHeader String token){
        if(token!=null){
            return user_tokenService.checktoken(token);
        }else{
            return null;
        }

    }
}
