package com.example.task_planning.controller;

import com.example.task_planning.dto.request.LoginRequest;
import com.example.task_planning.dto.request.RegisterRequest;
import com.example.task_planning.dto.response.AuthResponse;
import com.example.task_planning.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // ✅ Register
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    // ✅ Login (return token here)
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    // ✅ Logout (simple version)
    @PostMapping("/logout")
    public ResponseEntity<AuthResponse> logout(){
        return ResponseEntity.ok(
                new AuthResponse(true, "Logout successful", null)
        );
    }
}