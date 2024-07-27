package com.introwebsite.services.impl;

import com.introwebsite.dtos.common.CommonResponseDto;
import com.introwebsite.dtos.message.ContactDto;
import com.introwebsite.dtos.message.MessageDto;
import com.introwebsite.dtos.message.SendMessageDto;
import com.introwebsite.dtos.user.UserDto;
import com.introwebsite.entities.MessageEntity;
import com.introwebsite.entities.UserEntity;
import com.introwebsite.enums.AuthProvider;
import com.introwebsite.enums.Role;
import com.introwebsite.repositories.MessageRepository;
import com.introwebsite.repositories.UserRepository;
import com.introwebsite.services.MessageService;
import com.introwebsite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Value("${default.guest-avatar}")
    String defaultAvatar;

    @Override
    public MessageDto saveMessage(SendMessageDto messageDto) {
        System.out.println(messageDto);
        MessageEntity message = new MessageEntity();

        message.setSender(messageDto.getSender());
        message.setReceiver(messageDto.getReceiver());
        message.setContent(messageDto.getContent());
        message.setUsernameSender(messageDto.getUsernameSender());
        message.setUsernameReceiver(messageDto.getUsernameReceiver());
        message.setCreatedAt(new Date(System.currentTimeMillis()));
        message.setCreatedBy(message.getSender());
        if (userService.findByEmail(messageDto.getReceiver()) == null) {
            UserEntity receiver = new UserEntity();
            receiver.setEmail(messageDto.getReceiver());
            receiver.setUsername(messageDto.getUsernameReceiver());
            receiver.setAvatar(defaultAvatar);
            receiver.setRole(Role.CUSTOMER);
            receiver.setProvider(AuthProvider.LOCAL);
            userRepository.save(receiver);
        }

        if (userService.findByEmail(messageDto.getSender()) == null) {
            UserEntity receiver = new UserEntity();
            receiver.setEmail(messageDto.getSender());
            receiver.setUsername(messageDto.getUsernameSender());
            receiver.setAvatar(defaultAvatar);
            receiver.setRole(Role.CUSTOMER);
            receiver.setProvider(AuthProvider.LOCAL);
            userRepository.save(receiver);
        }

        return new MessageDto(messageRepository.save(message));
    }

    @Override
    public CommonResponseDto<List<MessageDto>> getMessages(ContactDto contactDto) {
        List<MessageEntity> messages = messageRepository.findMessagesBySenderAndReceiver(contactDto.getSender(), contactDto.getReceiver());

        return new CommonResponseDto<>(messages.stream().map(MessageDto::new).toList());
    }

    @Override
    public CommonResponseDto<List<UserDto>> getListMessagesBySender(String sender) {
        List<UserDto> entities = messageRepository.findDistinctReceiversBySender(sender);

        return new CommonResponseDto<>(entities);
    }
}
