package com.introwebsite.controllers.impl;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.message.MessageDto;
import com.introwebsite.dtos.message.SendMessageDto;
import com.introwebsite.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {
    @Autowired
    MessageService messageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/sendMessage")
    public MessageDto sendMessage(SendMessageDto sendMessageDto) {
        System.out.println("Message: " + sendMessageDto.toString());
        MessageDto response = messageService.saveMessage(sendMessageDto);

        messagingTemplate.convertAndSendToUser(sendMessageDto.getReceiver(), "/private", sendMessageDto);
        return response;
    }
}
