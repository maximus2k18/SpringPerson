package ru.practice.springperson.dto;

import lombok.Data;

@Data
public class MessagePerson {
    private long senderId;
    private long receiverId;
}
