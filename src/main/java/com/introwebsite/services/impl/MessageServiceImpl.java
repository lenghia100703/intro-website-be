package com.introwebsite.services.impl;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.message.ContactDto;
import com.introwebsite.dtos.message.MessageDto;
import com.introwebsite.dtos.message.ReceiverInfoDto;
import com.introwebsite.dtos.message.SendMessageDto;
import com.introwebsite.entities.MessageEntity;
import com.introwebsite.repositories.MessageRepository;
import com.introwebsite.repositories.UserRepository;
import com.introwebsite.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public CommonResponseDto<MessageDto> saveMessage(SendMessageDto messageDto) {
        MessageEntity message = new MessageEntity();
        message.setSender(messageDto.getSender());
        message.setReceiver(messageDto.getReceiver());
        message.setContent(messageDto.getContent());
        message.setUsernameSender(messageDto.getUsernameSender());
        message.setUsernameReceiver(messageDto.getUsernameReceiver());
        message.setCreatedAt(new Date(System.currentTimeMillis()));
        message.setCreatedBy(message.getSender());

        return new CommonResponseDto<>(new MessageDto(messageRepository.save(message)));
    }

    @Override
    public CommonResponseDto<List<MessageDto>> getMessages(ContactDto contactDto) {
        List<MessageEntity> messages = messageRepository.findMessagesBySenderAndReceiver(contactDto.getSender(), contactDto.getReceiver());

        return new CommonResponseDto<>(messages.stream().map(MessageDto::new).toList());
    }

    @Override
    public CommonResponseDto<List<ReceiverInfoDto>> getListMessagesBySender(String sender) {
        List<ReceiverInfoDto> entities = messageRepository.findDistinctReceiversBySender(sender);

        return new CommonResponseDto<>(entities);
    }
}
