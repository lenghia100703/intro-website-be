package com.introwebsite.controllers.impl;

import com.introwebsite.controllers.AuthController;
import com.introwebsite.dtos.auth.AuthResponseDto;
import com.introwebsite.dtos.auth.LoginDto;
import com.introwebsite.dtos.auth.SignUpDto;
import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.user.UserDto;
import com.introwebsite.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl implements AuthController {
    @Autowired
    AuthService authService;

    @Override
    public CommonResponseDto<UserDto> register(SignUpDto signUpDto) {
        return authService.register(signUpDto);
    }

    @Override
    public CommonResponseDto<AuthResponseDto> login(LoginDto loginDto) {
        return authService.login(loginDto);
    }

    @Override
    public CommonResponseDto<String> logout() {
        return authService.logout();
    }
}
