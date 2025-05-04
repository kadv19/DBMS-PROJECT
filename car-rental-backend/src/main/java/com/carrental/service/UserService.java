package com.carrental.service;

import com.carrental.model.User;
import com.carrental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final Map<String, String> otpStore = new HashMap<>(); // Temporary OTP storage

    public User signUp(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean signIn(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    public void sendOtp(String email) {
        String otp = UUID.randomUUID().toString().substring(0, 6);
        otpStore.put(email, otp);
        // Simulate sending OTP
        System.out.println("OTP for " + email + ": " + otp);
    }

    public boolean resetPassword(String email, String otp, String newPassword) {
        if (otpStore.containsKey(email) && otpStore.get(email).equals(otp)) {
            User user = userRepository.findByEmail(email);
            if (user != null) {
                user.setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(user);
                otpStore.remove(email);
                return true;
            }
        }
        return false;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}