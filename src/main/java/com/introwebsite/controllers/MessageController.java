package com.introwebsite.controllers;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.message.MessageDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/messages")
public interface MessageController {
    @PostMapping("")
    CommonResponseDto<MessageDto> saveMessage(@RequestBody MessageDto messageDto);

    @GetMapping("")
    CommonResponseDto<List<MessageDto>> getMessages();

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    CommonResponseDto<MessageDto> sendMessage(MessageDto messageDto);
}
