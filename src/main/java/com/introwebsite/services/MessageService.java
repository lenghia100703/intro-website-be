package com.introwebsite.services;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.message.MessageDto;

import java.util.List;

public interface MessageService {
    CommonResponseDto<MessageDto> saveMessage(MessageDto messageDto);

    CommonResponseDto<List<MessageDto>> getMessages();
}
