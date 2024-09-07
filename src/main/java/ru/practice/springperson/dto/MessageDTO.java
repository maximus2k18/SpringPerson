package ru.practice.springperson.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MessageDTO {
    private long senderId;
    private long receiverId;
    private String text;
    private String timestamp;
}
