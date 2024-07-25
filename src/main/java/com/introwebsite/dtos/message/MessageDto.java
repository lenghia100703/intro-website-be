package com.introwebsite.dtos.message;

import com.introwebsite.entities.MessageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private Long id;
    private String content;
    private String sender;
    private String receiver;
    private String usernameSender;
    private String usernameReceiver;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;

    public MessageDto(MessageEntity message) {
        this.id = message.getId();
        this.content = message.getContent();
        this.sender = message.getSender();
        this.receiver = message.getReceiver();
        this.usernameSender = message.getUsernameSender();
        this.usernameReceiver = message.getUsernameReceiver();
        this.createdAt = message.getCreatedAt();
        this.updatedAt = message.getUpdatedAt();
        this.createdBy = message.getCreatedBy();
        this.updatedBy = message.getUpdatedBy();
    }
}
