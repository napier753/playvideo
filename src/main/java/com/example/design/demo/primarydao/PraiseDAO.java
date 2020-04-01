package com.example.design.demo.primarydao;

import com.example.design.demo.pojo.Praise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PraiseDAO extends JpaRepository<Praise,Integer>{
    Praise getByVideoIdAndAndUserId(int video_id, int user_id);

}
