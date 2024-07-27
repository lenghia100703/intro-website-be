package com.introwebsite.controllers;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.common.PaginatedDataDto;
import com.introwebsite.dtos.user.AddUserDto;
import com.introwebsite.dtos.user.ChangePasswordDto;
import com.introwebsite.dtos.user.UserDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/api/user")
public interface UserController {
    @GetMapping("/{id}")
    CommonResponseDto<UserDto> getUserById(@PathVariable("id") Long id);

    @GetMapping("/me")
    CommonResponseDto<UserDto> getCurrentUser();

    @GetMapping("/email/{email}")
    CommonResponseDto<UserDto> getUserByEmail(@PathVariable("email") String email);

    @GetMapping("")
    PaginatedDataDto<UserDto> getUserByPage(@RequestParam(name = "page") int page);

    @PostMapping("")
    CommonResponseDto<UserDto> createUser(@RequestBody AddUserDto addUserDto);

    @PutMapping("/{id}")
    CommonResponseDto<String> editUser(@PathVariable("id") Long id,
                                       @RequestParam(value = "avatar", required = false) MultipartFile file,
                                       @RequestParam("username") String username,
                                       @RequestParam("email") String email,
                                       @RequestParam("age") String age,
                                       @RequestParam("phone") String phone,
                                       @RequestParam("address") String address,
                                       @RequestParam("avatarUrl") String avatarUrl) throws IOException;


    @DeleteMapping("/{id}")
    CommonResponseDto<String> deleteUser(@PathVariable("id") Long id);

    @PutMapping("/change-password/{id}")
    CommonResponseDto<String> changePassword(@PathVariable("id") Long id, @RequestBody ChangePasswordDto changePasswordDto);

}
