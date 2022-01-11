package com.manage.service;

import com.manage.entity.User;

public interface LoginService {
    User queryUserInfoByLoginId(String id);

    int insertUserInfo(User user);

}
