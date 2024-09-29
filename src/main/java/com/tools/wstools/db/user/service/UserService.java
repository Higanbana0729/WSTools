package com.tools.wstools.db.user.service;

import com.tools.wstools.db.user.entity.User;

import java.util.List;

/**
 * @author zp
 * @date 2024/9/29 17:17
 */
public interface UserService {
    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(Long id);

    User getUser(Long id);

    List<User> getAllUsers();
}