package com.docker2.mapper;

import com.docker2.pojo.User;
import com.docker2.util.CommonMapper;

public interface UserMapper extends CommonMapper<User> {

    User findOneByIp(String ip);
}