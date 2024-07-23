package com.introwebsite.controllers.impl;

import com.introwebsite.controllers.MessageController;
import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.message.MessageDto;
import com.introwebsite.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageControllerImpl implements MessageController {
    @Autowired
    MessageService messageService;

    @Override
    public CommonResponseDto<MessageDto> saveMessage(MessageDto messageDto) {
        return messageService.saveMessage(messageDto);
    }

    @Override
    public CommonResponseDto<List<MessageDto>> getMessages() {
        return messageService.getMessages();
    }

    @Override
    public CommonResponseDto<MessageDto> sendMessage(MessageDto messageDto) {
        return messageService.saveMessage(messageDto);
    }
}
