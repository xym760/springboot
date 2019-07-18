package com.nxist.springboot.controller;

import com.nxist.springboot.entities.User;
import com.nxist.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


/**
 * @Author: xym760
 * @Date: 2019/7/18 17:02
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get(): null;
    }

    @GetMapping("/user")
    public User inserUser(User user) {
        User saveUser = userRepository.save(user);
        return saveUser;
    }
}
