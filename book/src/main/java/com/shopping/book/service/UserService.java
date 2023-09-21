package com.shopping.book.service;

import com.shopping.book.entities.User;
import com.shopping.book.exceptions.IdNotFoundException;
import com.shopping.book.repository.UserRepository;
import com.shopping.book.service.iservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User updateByUserId(Long userId, User user) {
        User db = userRepository.findById(userId)
                .orElseThrow(()-> new IdNotFoundException("User Not Exist with id:"+userId));
        db.setUserName(user.getUserName());
        db.setPassword(user.getPassword());
        db.setContactNo(user.getContactNo());
        db.setEmailId(user.getEmailId());
        db.setAddress(user.getAddress());
        return userRepository.save(db);
    }

    @Override
    public void deleteByUserId(Long userId) {

        userRepository.deleteById(userId);
    }
}
