package com.huirong.servlet.view;

/**
 * Created by huirong on 17-5-18.
 */
public class User {
    private String username;
    private String passwd;

    public User(String username, String passwd) {
        this.username = username;
        this.passwd = passwd;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
