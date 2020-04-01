package com.example.design.demo.controller;

import com.example.design.demo.pojo.Video;
import com.example.design.demo.primatyservices.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
接收审核视频的接口，管理员登录后可以查看哪些视频需要审核
 */
@RestController
public class CheckController {
    @Autowired
    VideoService videoService;

    //审核视频接口
    @CrossOrigin
    @PostMapping("/api/admin/check")
    public List<Video> listBystate()throws Exception{
        return videoService.listByState(1);//默认审核state为1的视频
    }

    //审核后是否通过，修改状态为?
    @CrossOrigin
    @GetMapping("/api/admin/updatestate")
    public void updateState(@RequestParam("id") int id ,@RequestParam("state") int state){
        videoService.UpdateState(id, state);
    }
}
