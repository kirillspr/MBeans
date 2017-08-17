package com.oxagile.sprynchan.mbean.example.controller;

import com.oxagile.sprynchan.mbean.example.model.User;
import com.oxagile.sprynchan.mbean.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kirylsprynchan on 13.07.17.
 */
@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public User getUser(@RequestParam long id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(path = "/getAll", method = RequestMethod.GET)
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

}
