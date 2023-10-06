package com.finaltask.task.Controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finaltask.task.Model.User;
import com.finaltask.task.Repository.UserRepository;

    @RestController
public class UserContoller {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
       
        String password = generatePassword(user.getFirstName(), user.getMiddleName(), user.getLastName());
        user.setPassword(password);

       
        return userRepository.save(user);
    }

    private String generatePassword(String firstName, String middleName, String lastName) {
       
        Random random = new Random();
        String randomDigits = String.format("%03d", random.nextInt(1000));
        String password = firstName.substring(0, 2) + middleName.substring(0, 2) + lastName.substring(0, 2) + randomDigits;
        return password;
    }
}

