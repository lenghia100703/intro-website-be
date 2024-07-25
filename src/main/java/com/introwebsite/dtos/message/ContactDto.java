package com.introwebsite.dtos.message;

import lombok.Data;

@Data
public class ContactDto {
    private String sender;
    private String receiver;

    public ContactDto(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }
}
