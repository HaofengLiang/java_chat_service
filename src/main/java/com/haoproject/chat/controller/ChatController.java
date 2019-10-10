package com.haoproject.chat.controller;

import com.haoproject.chat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat/")
public class ChatController {
    @Autowired
    private ChatRepository chatRepository;


}
