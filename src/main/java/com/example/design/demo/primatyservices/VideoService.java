package com.example.design.demo.primatyservices;

import com.example.design.demo.primarydao.VideoDAO;
import com.example.design.demo.pojo.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoService {
    @Autowired
    VideoDAO videoDAO;
//查询所有视频
    public List<Video> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return videoDAO.findAll(sort);
    }
    //查询所有审核中的视频
    public List<Video> listByState(int state){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return videoDAO.findAllByState(state);
    }
    //通过id查一条视频
    public Video get(int id){
        Video video = videoDAO.findById(id).orElse(null);
        return video;
    }



    //通过type查询前四条记录
    public List<Video> listzerotofourBytype(int type){
        //Sort sort = new Sort(Sort.Direction.DESC,"type");
        return videoDAO.findzerotofourByType(type);
    }
    public List<Video> listfivetoeightBytype(int type){
        //Sort sort = new Sort(Sort.Direction.DESC,"type");
        return videoDAO.findfivetoeightByType(type);
    }

//增加视频记录
    public void addorUpdate(Video video){
        videoDAO.save(video);
    }
    //通过id删除
    public void deleteById(int id) {
        videoDAO.deleteById(id);
    }

    //修改视频审核状态
    public void UpdateState(int id, int state){
        videoDAO.updateState(id, state);
    }
    //通过分类id查
    /*public List<Video> findbyType(int type){
        Video video = VideoService
        Sort sort = new Sort(Sort.Direction.DESC,"type");
        return videoDAO.findAllByType(video);
    }*/
}
