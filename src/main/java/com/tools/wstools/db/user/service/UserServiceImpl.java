package com.tools.wstools.db.user.service;

import com.tools.wstools.db.user.entity.User;
import com.tools.wstools.db.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zp
 * @date 2024/9/29 17:17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.update(user) > 0;
    }

    @Override
    public boolean deleteUser(Long id) {
        return userMapper.delete(id) > 0;
    }

    @Override
    public User getUser(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }
}