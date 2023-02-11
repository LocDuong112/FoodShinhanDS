package com.example.foodservicev1.service.impl;

import com.example.foodservicev1.entity.Message;
import com.example.foodservicev1.service.AIChatService;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIChatServiceImpl implements AIChatService {
    @Autowired
    private ChatgptService chatgptService;

    @Override
    public String chatResponse(String request) {
        return chatgptService.sendMessage(request);
    }
}
