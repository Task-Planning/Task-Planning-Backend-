package com.example.task_planning.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private boolean success;
    private String message;
    private String token; // Optional: can be null if you don’t use JWT yet
}