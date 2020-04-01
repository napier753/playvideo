package com.example.design.demo.primarydao;

import com.example.design.demo.pojo.User;
import com.example.design.demo.pojo.Video;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoDAO extends JpaRepository<Video,Integer> {
    List<Video> findAllByType(int type);
    List<Video> findAllByUser(User user);

    @Query(value = "SELECT * FROM video v WHERE v.type=? LIMIT 1,4",nativeQuery = true)
    List<Video> findzerotofourByType(int type);
    @Query(value = "SELECT * FROM video v WHERE v.type=? LIMIT 5,4",nativeQuery = true)
    List<Video> findfivetoeightByType(int type);
    @Query(value = "UPDATE video v SET v.state = ? WHERE v.id=?",nativeQuery = true)
    void updateState(int id, int state);

    //查询审核中的视频
    List<Video> findAllByState(int state);
}
