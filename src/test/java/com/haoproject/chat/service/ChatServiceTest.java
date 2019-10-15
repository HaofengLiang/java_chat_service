package com.haoproject.chat.service;

import com.haoproject.chat.Exception.ChatExistsException;
import com.haoproject.chat.model.Chat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatServiceTest {

    @Autowired
    ChatService chatService;

    @Test
    public void deleteTestChatIfExists() {
        long userId1 = 1;
        long userId2 = 2;
        Chat chat = chatService.getChatByUserIds(userId1, userId2);
        if (chat != null) {
            chatService.deleteChatByUserIds(userId1, userId2);
            chat = chatService.getChatByUserIds(userId1, userId2);
            assertNull(chat);
        }
    }

    @Test
    public void createNewEmptyChat() throws ChatExistsException {
        long userId1 = 1;
        long userId2 = 2;
        Chat chat = chatService.getChatByUserIds(userId1, userId2);
        assertNull(chat);
        chatService.createChatToUserIds(userId1, userId2);
        chat = chatService.getChatByUserIds(userId1, userId2);
        assertNotNull(chat);
        assertEquals(chat.getMessages().size(), 0);
    }

    @Test
    public void getAllMessagesInAChatByUserIds() {
//        long userId1 = 1;
//        long userId2 = 2;
//        Chat chat= chatService.getChatByUserIds(userId1, userId2);

    }
}