package com.introwebsite.controllers;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.message.MessageDto;
import com.introwebsite.dtos.message.ReceiverInfoDto;
import com.introwebsite.dtos.message.SendMessageDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/messages")
public interface MessageController {
    @PostMapping("")
    CommonResponseDto<MessageDto> saveMessage(@RequestBody SendMessageDto messageDto);

    @GetMapping("")
    CommonResponseDto<List<MessageDto>> getMessages(@RequestParam(name = "sender") String sender, @RequestParam(name = "receiver") String receiver);

    @GetMapping("/{sender}")
    CommonResponseDto<List<ReceiverInfoDto>> getMessagesBySender(@PathVariable(name = "sender") String sender);

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    CommonResponseDto<MessageDto> sendMessage(SendMessageDto messageDto);
}
