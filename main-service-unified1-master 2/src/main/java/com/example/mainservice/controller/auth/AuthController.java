package com.example.mainservice.controller.auth;

import com.example.mainservice.dto.auth.LoginRequest;
import com.example.mainservice.dto.auth.LoginResponse;
import com.example.mainservice.dto.auth.RefreshRequest;
import com.example.mainservice.dto.auth.RefreshResponse;
import com.example.mainservice.dto.auth.RegisterRequest;
import com.example.mainservice.dto.auth.UpdateUserRequest;

import com.example.mainservice.service.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.mainservice.dto.auth.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) {
        return ResponseEntity.ok(authService.login(req));
    }

    @PostMapping("/refresh")
    public ResponseEntity<RefreshResponse> refresh(@RequestBody RefreshRequest req) {
        return ResponseEntity.ok(authService.refresh(req));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest req) {
        authService.register(req); return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody UpdateUserRequest req) {
        authService.updateUser(req); return ResponseEntity.ok().build();
    }
}
