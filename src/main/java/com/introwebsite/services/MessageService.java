package com.introwebsite.services;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.message.ContactDto;
import com.introwebsite.dtos.message.MessageDto;
import com.introwebsite.dtos.message.ReceiverInfoDto;
import com.introwebsite.dtos.message.SendMessageDto;

import java.util.List;

public interface MessageService {
    CommonResponseDto<MessageDto> saveMessage(SendMessageDto messageDto);

    CommonResponseDto<List<MessageDto>> getMessages(ContactDto contactDto);

    CommonResponseDto<List<ReceiverInfoDto>> getListMessagesBySender(String sender);
}
