package com.haoproject.chat.model;

import com.haoproject.chat.repository.ChatRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ChatTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createEmptyChatTest() {
        Chat chat = new Chat(1, 2);
        Assert.assertNotNull(chat);
    }


}