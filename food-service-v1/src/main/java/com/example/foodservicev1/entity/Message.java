package com.example.foodservicev1.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Message {
    private String request;
    private String response;
    private String requestTime;
    private String responseTime;
}
