package com.introwebsite.services;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.user.AddUserDto;
import com.introwebsite.dtos.user.ChangePasswordDto;
import com.introwebsite.dtos.user.UserDto;
import com.introwebsite.entities.UserEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    CommonResponseDto<UserDto> getUserById(Long id);

    UserEntity getCurrentUser();

    PaginatedDataDto<UserDto> getUserByPage(int page);

    CommonResponseDto<UserDto> createUser(AddUserDto addUserDto);

    CommonResponseDto<String> editUser(Long id, String email, String username, String phone, String address, String age,
                                       String avatarUrl, MultipartFile file) throws IOException;

    CommonResponseDto<String> deleteUser(Long id);

    CommonResponseDto<String> changePassword(Long id, ChangePasswordDto changePasswordDto);

    UserEntity findByEmail(String email);

    Long getCurrentUserId();
}
