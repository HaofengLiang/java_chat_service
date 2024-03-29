package com.haoproject.chat.service;

import com.haoproject.chat.Exception.ChatException;
import com.haoproject.chat.Exception.ChatExistsException;
import com.haoproject.chat.Exception.ChatNotExistsException;
import com.haoproject.chat.model.Chat;
import com.haoproject.chat.model.Message;
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

    public void deleteChatByUserIds(long userId1, long userId2) {
        Chat targetChat = getChatByUserIds(userId1, userId2);
        if (targetChat != null) {
            chatRepository.deleteById(targetChat.getId());
        }
    }

    public void sendMessage(String message, long fromUserId, long toUserId) throws ChatException {
        Chat chat = getChatByUserIds(fromUserId, toUserId);
        if (chat == null) {
            throw new ChatNotExistsException();
        }
    }
}
