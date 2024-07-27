package com.introwebsite.controllers.impl;

import com.introwebsite.controllers.MessageController;
import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.message.ContactDto;
import com.introwebsite.dtos.message.MessageDto;
import com.introwebsite.dtos.message.SendMessageDto;
import com.introwebsite.dtos.user.UserDto;
import com.introwebsite.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageControllerImpl implements MessageController {
    @Autowired
    MessageService messageService;

    @Override
    public MessageDto saveMessage(SendMessageDto messageDto) {
        return messageService.saveMessage(messageDto);
    }

    @Override
    public CommonResponseDto<List<MessageDto>> getMessages(String sender, String receiver) {
        return messageService.getMessages(new ContactDto(sender, receiver));
    }

    @Override
    public CommonResponseDto<List<UserDto>> getMessagesBySender(String sender) {
        return messageService.getListMessagesBySender(sender);
    }
}
