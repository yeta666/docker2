package com.docker2.service;

import com.docker2.mapper.UserMapper;
import com.docker2.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author YETA
 * @date 2018/09/12/15:04
 */
@Service
public class UserService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserMapper userMapper;

    public User login(HttpServletRequest request) {
        String ip = request.getRemoteAddr();        //代理ip
        String rIp = request.getHeader("X-Real-IP");        //真实ip
        User user = userMapper.findOneByIp(ip + " / " + rIp);
        if (user == null) {
            String id = UUID.randomUUID().toString();
            if (userMapper.insert(new User(id, ip + " / " + rIp, 1)) == 1) {
                return userMapper.selectByPrimaryKey(id);
            } else {
                return null;
            }
        } else {
            user.setLogintime(user.getLogintime() + 1);
            if (userMapper.updateByPrimaryKey(user) == 1) {
                return user;
            } else {
                return null;
            }
        }
    }
}
