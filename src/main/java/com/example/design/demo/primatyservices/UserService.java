package com.example.design.demo.primatyservices;
import com.example.design.demo.primarydao.UserDAO;
import com.example.design.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String uername){
        User user = getByName(uername);
        return null!=user;
}
    public User getByName(String username){
        return userDAO.findByUsername(username);
    }
    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username,password);
    }
    public void add(User user){
        userDAO.save(user);
    }

    public User findById(int id){
        return userDAO.findById(id);
    }

}
