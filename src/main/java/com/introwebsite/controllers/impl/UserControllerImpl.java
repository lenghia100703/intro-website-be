package com.introwebsite.controllers.impl;

import com.introwebsite.controllers.UserController;
import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.user.AddUserDto;
import com.introwebsite.dtos.user.ChangePasswordDto;
import com.introwebsite.dtos.user.UserDto;
import com.introwebsite.enums.ResponseCode;
import com.introwebsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UserControllerImpl implements UserController {
    @Autowired
    UserService userService;


    @Override
    public CommonResponseDto<UserDto> getUserById(Long id) {
        return userService.getUserById(id);
    }

    @Override
    public CommonResponseDto<UserDto> getCurrentUser() {
        if (userService.getCurrentUser() == null) {
            return new CommonResponseDto<>(ResponseCode.USER_NOT_AUTHENTICATED);
        }
        return new CommonResponseDto<>(new UserDto(userService.getCurrentUser()));
    }

    @Override
    public PaginatedDataDto<UserDto> getUserByPage(int page) {
        return userService.getUserByPage(page);
    }

    @Override
    public CommonResponseDto<UserDto> createUser(AddUserDto addUserDto) {
        return userService.createUser(addUserDto);
    }

    @Override
    public CommonResponseDto<String> editUser(Long id, MultipartFile file, String username, String email, String age, String phone, String address, String avatarUrl) throws IOException {
        return userService.editUser(id, email, username, phone, address, age, avatarUrl, file);
    }

    @Override
    public CommonResponseDto<String> deleteUser(Long id) {
        return userService.deleteUser(id);
    }

    @Override
    public CommonResponseDto<String> changePassword(Long id, ChangePasswordDto changePasswordDto) {
        return userService.changePassword(id, changePasswordDto);
    }
}
