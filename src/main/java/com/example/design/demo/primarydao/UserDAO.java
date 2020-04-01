package com.example.design.demo.primarydao;

import com.example.design.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username, String password);

    User findById(int id);

}
