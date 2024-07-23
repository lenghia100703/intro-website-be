package com.introwebsite.services.impl;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.message.MessageDto;
import com.introwebsite.entities.MessageEntity;
import com.introwebsite.repositories.MessageRepository;
import com.introwebsite.repositories.UserRepository;
import com.introwebsite.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public CommonResponseDto<MessageDto> saveMessage(MessageDto messageDto) {
        MessageEntity message = new MessageEntity();
        message.setSender(messageDto.getSender());
        message.setReceiver(messageDto.getReceiver());
        message.setContent(messageDto.getContent());
        message.setUsername(messageDto.getUsername());

        return new CommonResponseDto<>(new MessageDto(messageRepository.save(message)));
    }

    @Override
    public CommonResponseDto<List<MessageDto>> getMessages() {
        List<MessageEntity> messages = messageRepository.findAll();

        return new CommonResponseDto<>(messages.stream().map(MessageDto::new).toList());
    }
}
