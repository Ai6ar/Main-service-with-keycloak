package com.example.mainservice.service.auth;
import org.springframework.stereotype.Service;
import com.example.mainservice.dto.auth.*;
@Service
public class AuthServiceImpl implements AuthService {
    @Override public LoginResponse login(LoginRequest req) { throw new UnsupportedOperationException(); }
    @Override public RefreshResponse refresh(RefreshRequest req) { throw new UnsupportedOperationException(); }
    @Override public void register(RegisterRequest req) { throw new UnsupportedOperationException(); }
    @Override public void updateUser(UpdateUserRequest req) { throw new UnsupportedOperationException(); }
}