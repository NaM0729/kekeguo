package com.kekeguo.admin.model;

import lombok.Data;

/**
 * @author zhangyuna
 * @date 2018年09月30日11:05:12
 */
@Data
public class UserModel {
    public  String username;
    public String password;

    public UserModel() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
