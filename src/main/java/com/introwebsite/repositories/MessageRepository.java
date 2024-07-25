package com.introwebsite.repositories;

import com.introwebsite.dtos.message.ReceiverInfoDto;
import com.introwebsite.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    @Query("SELECT m FROM MessageEntity m WHERE (m.sender = :sender AND m.receiver = :receiver) OR (m.sender = :receiver AND m.receiver = :sender)")
    List<MessageEntity> findMessagesBySenderAndReceiver(@Param("sender") String sender, @Param("receiver") String receiver);

    @Query("SELECT DISTINCT new com.introwebsite.dtos.message.ReceiverInfoDto(m.sender, m.usernameSender, m.createdBy) " +
            "FROM MessageEntity m " +
            "WHERE m.receiver = :sender")
    List<ReceiverInfoDto> findDistinctReceiversBySender(@Param("sender") String sender);
}

