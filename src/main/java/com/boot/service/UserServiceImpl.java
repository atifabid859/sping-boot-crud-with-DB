package com.boot.service;

import com.boot.entity.User;
import com.boot.exception.ResourceNotFoundException;
import com.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getByUserId(Integer userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User update(User user, Integer userId) {
        User userDetails = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        userDetails.setAddress(user.getAddress());
        userDetails.setEmail(user.getEmail());
        userDetails.setFirstName(user.getFirstName());
        userDetails.setLastName(user.getLastName());
        userDetails.setMobileNumber(user.getMobileNumber());
        userRepository.save(userDetails);
        return userDetails;
    }

    @Override
    public List<User> getByName(String lastName) {
       return userRepository.findByLastName(lastName);
    }

    @Override
    public void deleteById(Integer userId) {
         userRepository.deleteById(userId);
    }


}
