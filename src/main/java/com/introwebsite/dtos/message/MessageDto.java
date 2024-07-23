package com.introwebsite.dtos.message;

import com.introwebsite.entities.MessageEntity;
import lombok.Data;

import java.util.Date;

@Data
public class MessageDto {
    private Long id;
    private String content;
    private String sender;
    private String receiver;
    private String username;
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;

    public MessageDto(MessageEntity message) {
        this.id = message.getId();
        this.content = message.getContent();
        this.sender = message.getSender();
        this.receiver = message.getReceiver();
        this.username = message.getUsername();
        this.createdAt = message.getCreatedAt();
        this.updatedAt = message.getUpdatedAt();
        this.createdBy = message.getCreatedBy();
        this.updatedBy = message.getUpdatedBy();
    }
}
