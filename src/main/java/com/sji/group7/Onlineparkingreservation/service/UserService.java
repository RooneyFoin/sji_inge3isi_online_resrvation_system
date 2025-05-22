package com.sji.group7.Onlineparkingreservation.service;

import com.sji.group7.Onlineparkingreservation.model.User;
import com.sji.group7.Onlineparkingreservation.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        return userRepo.save(user);
    }


    public boolean userExists(String email) {
        return userRepo.findByEmail(email).isPresent();
    }
}
