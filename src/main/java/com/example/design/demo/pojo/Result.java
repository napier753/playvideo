package com.example.design.demo.pojo;
public class Result {
    //浏览器的响应码
    private int code;
    private String token;

    public Result(int code){
        this.code = code;
    }
    public Result(int code, String token){
        this.code = code;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
