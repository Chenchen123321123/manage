package com.manage.entity;

import lombok.Data;

@Data
public class User {
    public String user_id;
    public String user_name;
    public String login_id;
    public String password;
    public String sex;
    public String remember;
    public String register_login_id;
    public String register_username;
    public String register_sex;
    public String register_password;
    public String salt;
}
