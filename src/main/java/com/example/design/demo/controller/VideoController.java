package com.example.design.demo.controller;

import com.example.design.demo.pojo.Video;
import com.example.design.demo.primatyservices.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @CrossOrigin
    @GetMapping("/api/videos")
    public List<Video> list()throws Exception{
        return videoService.list();
    }

    @CrossOrigin
    @PostMapping("/api/videos")
    public Video addorUpdate(@RequestBody Video video) throws Exception{
        videoService.addorUpdate(video);
        return video;
    }

    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Video video) throws Exception{
        videoService.deleteById(video.getId());
    }

    @CrossOrigin
    @GetMapping("/api/{type}/zerotofourvideos")
    public List<Video> listzerotofourByType(@PathVariable("type") int type) throws Exception{
        if(0 != type){
            return videoService.listzerotofourBytype(type);
        }else
        return list();
    }

    @CrossOrigin
    @GetMapping("/api/{type}/fivetoeightvideos")
    public List<Video> listfivetoeightByType(@PathVariable("type") int type) throws Exception{
        if(0 != type){
            return videoService.listfivetoeightBytype(type);
        }else
            return list();
    }

    @CrossOrigin
    @PostMapping("/api/PlayPage/Detail/{id}")
    public Video get(@PathVariable("id") int id){
        return videoService.get(id);
    }
}
