package com.boot.service;

import com.boot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    List<User> saveUsers(List<User> users);

    List<User> getUser();

    Optional<User> getByUserId(Integer userId);

    User update(User user, Integer userId);

    List<User> getByName(String lastName);

    void deleteById(Integer userId);
}
