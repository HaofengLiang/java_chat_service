package com.haoproject.chat.repository;

import com.haoproject.chat.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
