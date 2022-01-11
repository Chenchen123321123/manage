package com.manage.mapper;

import com.manage.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    User queryUserInfoByLoginId(String login_id);

    int insertUserInfo(User user);
}
