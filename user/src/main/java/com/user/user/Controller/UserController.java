package com.user.user.Controller;

import com.user.user.Model.User;
import com.user.user.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //  add users

    @PostMapping("/user")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    // Get All User
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //  Get User By Id
    @GetMapping("/user/id/{userId}")
    public User getUserById(@PathVariable Integer userId){
        return userService.getUserById(userId);
    }


}
