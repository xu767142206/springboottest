package com.xyc.wms.service;


import com.xyc.wms.entity.User;
import com.xyc.wms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(int id) {
        return userMapper.getUserInfo(id);
    }


    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    public int Update(User user) {
        return userMapper.update(user);
    }

    public User save(User user) {
        int save = userMapper.save(user);
        return user;
    }

    public List<User> selectAll() {
        return userMapper.selectAll();
    }


    public User selectLoginUser(String userName, String passWord) {
        return userMapper.selectLoginUser(userName, passWord);
    }

    public User selectLoginUser(String userName) {
        return userMapper.selectLoginUser(userName);
    }

}
