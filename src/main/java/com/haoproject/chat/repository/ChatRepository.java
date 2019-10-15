package com.haoproject.chat.repository;

import com.haoproject.chat.model.Chat;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatRepository extends CrudRepository<Chat, Long> {
    @Modifying
    @Query("DELETE FROM Chat c WHERE c.id = ?1")
    void deleteById(Long id);

    @Query("SELECT c FROM Chat c " +
            "WHERE userId1 = :userId OR userId2 = :userId")
    Iterable<Chat> findAllByUserId(@Param("userId") long userId);

    @Query("SELECT c FROM Chat c " +
            "WHERE (userId1 = :userId1 AND userId2 = :userId2) OR (userId1 = :userId2 AND userId2 = :userId1)")
    Optional<Chat> findByUserIds(@Param("userId1") long userId1, @Param("userId2") long userId2);

}
