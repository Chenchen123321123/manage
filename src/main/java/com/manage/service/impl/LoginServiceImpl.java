package com.manage.service.impl;

import com.manage.entity.User;
import com.manage.mapper.LoginMapper;
import com.manage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private  LoginMapper loginMapper;
    @Override
    public User queryUserInfoByLoginId(String id) {
        // TODO Auto-generated method stub
        return loginMapper.queryUserInfoByLoginId(id);
    }
}
