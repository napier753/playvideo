package com.example.design.demo.primatyservices;

import com.example.design.demo.pojo.User;
import com.example.design.demo.pojo.Video;
import com.example.design.demo.primarydao.PraiseDAO;
import com.example.design.demo.pojo.Praise;
import com.example.design.demo.until.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PraiseService{
    @Autowired
    PraiseDAO praiseDAO;
    public void update(Praise praise){
        praiseDAO.save(praise);
    }
    public Praise get(int video_id, int user_id){
        Praise praise = praiseDAO.getByVideoIdAndAndUserId(video_id, user_id);
        return praise;
    }

    public Praise getone(int p_id){
        Praise praise = praiseDAO.findById(p_id).orElse(null);
        return praise;
    }

    public void add(Praise praise){
        praiseDAO.save(praise);
    }


    //用来检查点赞的对象是否存在
    public Praise checkuserBytoken(int videoid){
        User user = UserContext.getUser();
        if (user!=null){
            Praise praise = get(videoid,user.getId());
            if(praise!=null){
                return praise;
            }else {
                Praise praise1 = new Praise(videoid,user.getId());
                add(praise1);
                return praise1;
            }
        }else {
            return null;
        }
    }
}
