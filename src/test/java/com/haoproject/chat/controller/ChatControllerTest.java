package com.haoproject.chat.controller;

import com.haoproject.chat.Exception.ChatExistsException;
import com.haoproject.chat.model.Chat;
import com.haoproject.chat.service.ChatService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class ChatControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ChatService chatService;

    @Test
    void createNewEmptyChat() throws ChatExistsException {
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
    void getAllMessagesInAChatByUserIds() {
//        long userId1 = 1;
//        long userId2 = 2;
//        Chat chat= chatService.getChatByUserIds(userId1, userId2);

    }
}