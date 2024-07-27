package com.introwebsite.dtos.message;

import lombok.Data;

@Data
public class SendMessageDto {
    private String content;
    private String sender;
    private String receiver;
    private String usernameSender;
    private String usernameReceiver;

    public SendMessageDto(String content, String sender, String receiver, String usernameSender, String usernameReceiver) {
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.usernameSender = usernameSender;
        this.usernameReceiver = usernameReceiver;
    }
}
