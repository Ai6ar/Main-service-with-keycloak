package com.example.mainservice.service.auth;
import com.example.mainservice.dto.auth.*;
public interface AuthService {
    LoginResponse login(LoginRequest req);
    RefreshResponse refresh(RefreshRequest req);
    void register(RegisterRequest req);
    void updateUser(UpdateUserRequest req);
}