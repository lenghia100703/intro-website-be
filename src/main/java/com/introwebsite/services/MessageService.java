package com.introwebsite.services;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.message.ContactDto;
import com.introwebsite.dtos.message.MessageDto;
import com.introwebsite.dtos.message.SendMessageDto;
import com.introwebsite.dtos.user.UserDto;

import java.util.List;

public interface MessageService {
    MessageDto saveMessage(SendMessageDto messageDto);

    CommonResponseDto<List<MessageDto>> getMessages(ContactDto contactDto);

    CommonResponseDto<List<UserDto>> getListMessagesBySender(String sender);

    CommonResponseDto<String> deleteMessage(String email);
}
