package com.infoowl.controller;


import com.infoowl.model.User;
import com.infoowl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hilal on 3/21/2016.
 */



@RestController
@RequestMapping(value = "/users")
public class UserController {



    @Autowired
    private UserRepository userRepository;


    /**
     * save a user.
     *
     * @return process message
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public User create(@RequestBody User user) {
     userRepository.save(user);
        return user;
    }


    /**
     * delete the user
     *
     * @return process message
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<User> delete(@PathVariable(value = "id") Long userId) {
        userRepository.delete(userId);
        return ResponseEntity.ok(null);
    }

    /**
     * update the user
     *
     * @return process message
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> update(@PathVariable(value = "id") Long userId, String userName, String userPassword) {
        User user = userRepository.findOne(userId);
        user.setUsername(userName);
        user.setPassword(userPassword);
        userRepository.save(user);
        return ResponseEntity.ok(null);
    }

    /**
     * list all users
     *
     * @return user list
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<User> list() {
        return userRepository.findAll();

    }

    /**
     * list one user
     *
     * @return state
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> get(@PathVariable Long id) {
        return ResponseEntity.ok(userRepository.findOne(id));

    }

}
