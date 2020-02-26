package com.example.demo.model;

import lombok.Data;

import java.util.UUID;

@Data
public class HelloWorldMessage {

    private UUID id;
    private String message;
}
