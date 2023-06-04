package com.example.userv3jwt.service;

import com.example.userv3jwt.user.User;

public interface UserService {
    User getById(Integer id);

    User update(User user);
    void delete(Integer id);
}
