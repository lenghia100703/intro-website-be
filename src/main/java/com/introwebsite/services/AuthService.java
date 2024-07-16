package com.introwebsite.services;

import com.introwebsite.dtos.auth.AuthResponseDto;
import com.introwebsite.dtos.auth.LoginDto;
import com.introwebsite.dtos.auth.SignUpDto;
import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.user.UserDto;

public interface AuthService {
    CommonResponseDto<AuthResponseDto> login(LoginDto loginDto);

    CommonResponseDto<UserDto> register(SignUpDto signUpDto);

    CommonResponseDto<String> logout();
}
