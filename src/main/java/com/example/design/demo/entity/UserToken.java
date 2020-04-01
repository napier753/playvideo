package com.example.design.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user_token")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class UserToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "user_id")
    int user_id;
    @Column(name = "token")
    String token;
    @Column(name = "timeout")
    long timeout;//时间戳
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public UserToken(){
    }

    public UserToken(int user_id, String token, long timeout){
        this.user_id = user_id;
        this.token = token;
        this.timeout = timeout;
    }
}
