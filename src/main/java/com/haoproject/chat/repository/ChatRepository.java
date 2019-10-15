package com.haoproject.chat.repository;

import com.haoproject.chat.model.Chat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRepository extends CrudRepository<Chat, Long> {
    Iterable<Chat> findAllByToUserId(long toUserId);

    Iterable<Chat> findAllByFromUserId(long fromUserId);

    @Query("SELECT c FROM Chat c " +
            "WHERE (toUserId = :userId1 AND fromUserId = :userId2) OR (toUserId = :userId2 AND fromUserId = :userId1)")
    Optional<Chat> findByUserIds(@Param("userId1") long userId1, @Param("userId2") long userId2);

}
