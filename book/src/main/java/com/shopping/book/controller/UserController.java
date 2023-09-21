package com.shopping.book.controller;

import com.shopping.book.entities.User;
import com.shopping.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public User saveUser(@RequestBody User user){return userService.saveUser(user);}

    @GetMapping("/user")
    public List<User> getAllUser(){ return userService.fetchUserList();}

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id")Long userId){
        return userService.getUserById(userId);
    }
    @PutMapping("/user/{id}")
    public User updateByUserId(@PathVariable("id") Long userId,
                               @RequestBody User user){
        return userService.updateByUserId(userId,user);
    }
    @DeleteMapping("/user/{id}")
    public String deleteByUserId(@PathVariable("id") Long userId) {
        userService.deleteByUserId(userId);
        return "User Data Deleted Successfully";
    }
}
