package com.introwebsite.dtos.message;

import lombok.Data;

@Data
public class SendMessageDto {
    private String content;
    private String sender;
    private String receiver;
    private String usernameSender;
    private String usernameReceiver;
}
