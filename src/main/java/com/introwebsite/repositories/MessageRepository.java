package com.introwebsite.repositories;

import com.introwebsite.dtos.user.UserDto;
import com.introwebsite.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    @Query("SELECT m FROM MessageEntity m WHERE (m.sender = :sender AND m.receiver = :receiver) OR (m.sender = :receiver AND m.receiver = :sender)")
    List<MessageEntity> findMessagesBySenderAndReceiver(@Param("sender") String sender, @Param("receiver") String receiver);

    @Query("SELECT DISTINCT new com.introwebsite.dtos.user.UserDto(u.avatar, u.email, u.username, u.id) " +
            "FROM MessageEntity m JOIN UserEntity u ON (m.receiver = u.email) OR (m.sender = u.email) " +
            "WHERE ((m.sender = :sender) OR (m.receiver = :sender)) AND u.email <> :sender")
    List<UserDto> findDistinctReceiversBySender(@Param("sender") String sender);
}

