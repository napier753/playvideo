package com.example.design.demo.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "praise")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Praise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="parise_id")
    int pariseId;

    @Column(name="video_id")
    int videoId;
    @Column(name="user_id")
    int userId;
    @Column(name = "praise_time")
    Date praisetime;




    public int getPariseId() {
        return pariseId;
    }

    public void setPariseId(int pariseId) {
        this.pariseId = pariseId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getPraisetime() {
        return praisetime;
    }

    public void setPraisetime(Date praisetime) {
        this.praisetime = praisetime;
    }

    public Praise(){}

    public Praise(int videoId, int userId) {
        this.videoId = videoId;
        this.userId = userId;
    }
}
