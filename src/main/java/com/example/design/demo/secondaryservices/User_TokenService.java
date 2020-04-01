package com.example.design.demo.secondaryservices;

import com.example.design.demo.entity.UserToken;
import com.example.design.demo.pojo.User;
import com.example.design.demo.primatyservices.UserService;
import com.example.design.demo.secondarydao.User_TokenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User_TokenService{
    /*
login控制器里只需要检验token有效时间，其他地方不用。其他地方检验能否通过token拿到userid，然后
通过userid拿到对应的user存在UserContext上下文对象。
 */
    @Autowired
    User_TokenDAO user_tokenDAO;

    @Autowired
    UserService userService;


    public UserToken getone(int user_id){
        UserToken userToken = user_tokenDAO.findByUserid(user_id);
        return userToken;
    }

    public void addOrupdate(UserToken userToken){
        user_tokenDAO.save(userToken);
    }

    public UserToken findByToken(String token){
        UserToken userToken = user_tokenDAO.findByToken(token);
        if(userToken==null){
            return null;
        }else {
            return userToken;
        }
    }
    /*
    参数 token
    返回 布尔值
     */
    public boolean isfindByToken(String token){
        UserToken userToken = user_tokenDAO.findByToken(token);
        if(userToken!=null){
            return true;
        }else {
            return false;
        }
    }

    public void update(long time, String token){
        user_tokenDAO.update(time,token);
    }


    public User checktoken(String token){
        UserToken userToken = findByToken(token);
        if (userToken == null){
            return null;
        }
        User user = userService.findById(userToken.getUser_id());
        if (user == null){
            return null;
        }
        return user;
    }
}
