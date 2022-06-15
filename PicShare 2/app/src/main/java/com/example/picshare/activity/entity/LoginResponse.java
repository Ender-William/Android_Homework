package com.example.picshare.activity.entity;

public class LoginResponse {

    /**
     * statecode : 1
     * msg : success
     * token : FUNVIDIA
     */

    private int state;
    private String msg;
    private String token;

    public int getCode() {
        return state;
    }

    public void setCode(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return msg;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
