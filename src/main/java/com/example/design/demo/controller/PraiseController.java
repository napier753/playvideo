package com.example.design.demo.controller;

import com.example.design.demo.pojo.Praise;
import com.example.design.demo.primatyservices.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//点赞的控制器
@RestController
public class PraiseController {
    @Autowired
    PraiseService praiseService;
/*
    @CrossOrigin
    @PostMapping("api/addpraise")
    @ResponseBody
    public Praise addprais(@RequestBody Praise praise){
        int video_id = praise.getVideoId();
        int user_id = praise.getUserId();
        return praise;
    }

    @CrossOrigin
    @GetMapping("api/{parise_id}")
    public Praise getone(@PathVariable("parise_id") int id){
        if(0 != id){
            return praiseService.getone(id);
        }else
            return null;
    }*/

    @CrossOrigin
    @GetMapping("api/praise")
    public Praise ispraise(@RequestHeader int videoid){
        Praise praise = praiseService.checkuserBytoken(videoid);
        return praise;

    }
}
