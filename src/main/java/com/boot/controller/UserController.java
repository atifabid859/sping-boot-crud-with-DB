package com.boot.controller;

import com.boot.entity.User;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User userSave(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/saveAll")
    public List<User> saveUsers(@RequestBody List<User> users) {
        return userService.saveUsers(users);
    }

    @GetMapping("/get_user")
    public List<User> getAllUser() {
        return userService.getUser();
    }

    @GetMapping("/{userId}")
    public Optional<User> getByUserId(@PathVariable("userId") Integer userId) {
        return userService.getByUserId(userId);
    }

    @PutMapping("/update/{userId}")
    public User update(@PathVariable("userId") Integer userId, @RequestBody User user) {
        return userService.update(user, userId);
    }

    @GetMapping("get-name/{lastName}")
    public List<User> getLastName(@PathVariable("lastName") String lastName) {
        return (List<User>) userService.getByName(lastName);
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteById(@PathVariable("userId") Integer userId) {
        userService.deleteById(userId);
        return "user no" + userId + " has been deleted !";
    }
    
    
}
