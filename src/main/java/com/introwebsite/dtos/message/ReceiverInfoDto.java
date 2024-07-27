package com.introwebsite.dtos.message;

import lombok.Data;

@Data
public class ReceiverInfoDto {
    private String receiver;
    private String usernameReceiver;
    private String avatar;
    private String createdBy;

    public ReceiverInfoDto(String receiver, String usernameReceiver, String createdBy, String avatar) {
        this.receiver = receiver;
        this.usernameReceiver = usernameReceiver;
        this.createdBy = createdBy;
        this.avatar = avatar;
    }
}
