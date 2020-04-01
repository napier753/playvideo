package com.example.design.demo.secondarydao;

import com.example.design.demo.entity.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface User_TokenDAO extends JpaRepository<UserToken,Integer> {
    @Query(value = "SELECT * FROM user_token WHERE token = ?",nativeQuery = true)
    public UserToken findByToken(String token);

    @Query(value = "UPDATE user_token SET timeout = ? WHERE token = ?",nativeQuery = true)
    public void update(long time,String token);

    @Query(value = "Select * FROM user_token WHERE user_id=?",nativeQuery = true)
    public UserToken findByUserid(int user_id);
}
