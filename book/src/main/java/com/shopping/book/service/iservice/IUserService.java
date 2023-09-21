package com.shopping.book.service.iservice;

import com.shopping.book.entities.User;

import java.util.List;

public interface IUserService {
    User saveUser(User user);

    List<User> fetchUserList();

    User getUserById(Long userId);

    User updateByUserId(Long userId, User user);

    void deleteByUserId(Long userId);
}
