package com.example.design.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="video")@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
//@IdClass(Video_CombinedPrimaryKey.class)
public class Video {

    @Id
    /*（1）、@GeneratedValue注解存在的意义主要就是为一个实体生成一个唯一标识的主键、@GeneratedValue提供了主键的生成策略。
    （2）、@GeneratedValue注解有两个属性,分别是strategy和generator,*/
    //-IDENTITY 主键由数据库生成, 采用数据库自增长, Oracle不支持这种方式
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")//name定义了被标注字段在数据库表中所对应字段的名称
    int id;
    int creation_time;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String av_number;
    String title;
    String cover_local;
    String cover_online;
    String video;
    int type;
    String video_download_url;
    int state;
    String md5;



    @ManyToOne
    @JoinColumn(name="uid")
    private User user;

    public Video(){}

    public Video(int id, int creation_time, String title, int type, int uid, int state){}
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(int creation_time) {
        this.creation_time = creation_time;
    }

    public String getAv_number() {
        return av_number;
    }

    public void setAv_number(String av_number) {
        this.av_number = av_number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover_local() {
        return cover_local;
    }

    public void setCover_local(String cover_local) {
        this.cover_local = cover_local;
    }

    public String getCover_online() {
        return cover_online;
    }

    public void setCover_online(String cover_online) {
        this.cover_online = cover_online;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVideo_download_url() {
        return video_download_url;
    }

    public void setVideo_download_url(String video_download_url) {
        this.video_download_url = video_download_url;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
