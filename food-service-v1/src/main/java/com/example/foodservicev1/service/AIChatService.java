package com.example.foodservicev1.service;

import com.example.foodservicev1.entity.Message;
import org.springframework.stereotype.Service;

@Service
public interface AIChatService {
    public String chatResponse(String request);
}
