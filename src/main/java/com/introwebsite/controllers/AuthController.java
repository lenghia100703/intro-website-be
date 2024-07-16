package com.introwebsite.controllers;

import com.introwebsite.dtos.auth.AuthResponseDto;
import com.introwebsite.dtos.auth.LoginDto;
import com.introwebsite.dtos.auth.SignUpDto;
import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.user.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/auth")
public interface AuthController {
    @PostMapping("/register")
    CommonResponseDto<UserDto> register(@RequestBody SignUpDto signUpDto);

    @PostMapping("/login")
    CommonResponseDto<AuthResponseDto> login(@RequestBody LoginDto loginDto);

    @PostMapping("/logout")
    CommonResponseDto<String> logout();
}
