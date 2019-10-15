package com.haoproject.chat.service;

import com.haoproject.chat.Exception.ChatExistsException;
import com.haoproject.chat.model.Chat;
import com.haoproject.chat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    ChatRepository chatRepository;

    public Chat getChatByUserIds(long userId1, long userId2) {
        return chatRepository.findByUserIds(userId1, userId2).orElse(null);
    }

    public void createChatToUserIds(long userId1, long userId2) throws ChatExistsException{
        if (getChatByUserIds(userId1, userId2) != null) {
            throw new ChatExistsException();
        }

        Chat newChat = new Chat(userId1, userId2);
        chatRepository.save(newChat);
    }
}
