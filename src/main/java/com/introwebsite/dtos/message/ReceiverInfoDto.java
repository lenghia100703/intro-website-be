package com.introwebsite.dtos.message;

import lombok.Data;

@Data
public class ReceiverInfoDto {
    private String receiver;
    private String usernameReceiver;
    private String createdBy;

    public ReceiverInfoDto(String receiver, String usernameReceiver, String createdBy) {
        this.receiver = receiver;
        this.usernameReceiver = usernameReceiver;
        this.createdBy = createdBy;
    }
}
