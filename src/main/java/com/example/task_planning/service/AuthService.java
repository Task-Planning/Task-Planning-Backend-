package com.example.task_planning.service;

import com.example.task_planning.dto.request.LoginRequest;
import com.example.task_planning.dto.request.RegisterRequest;
import com.example.task_planning.dto.response.AuthResponse;
import com.example.task_planning.entity.User;
import com.example.task_planning.repository.UserRepository;
import com.example.task_planning.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    // ✅ Register new user and generate token
    public AuthResponse register(RegisterRequest request) {

        // Check if email already exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return new AuthResponse(false, "Email already exists", null);
        }

        // Create new user
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())) // encode password
                .build();

        userRepository.save(user);

        // ✅ Generate token immediately after registration
        String token = jwtService.generateToken(user);

        return new AuthResponse(true, "Register successful", token);
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new AuthResponse(false, "Invalid email or password", null);
        }

        // Generate JWT token
        String token = jwtService.generateToken(user);

        return new AuthResponse(true, "Login successful", token);
    }
}