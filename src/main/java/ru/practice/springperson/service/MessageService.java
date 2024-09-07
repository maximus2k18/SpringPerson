package ru.practice.springperson.service;

import ru.practice.springperson.dto.MessageDTO;
import ru.practice.springperson.model.Message;

import java.util.ArrayList;
import java.util.List;

public interface MessageService {

    List<MessageDTO> getMessages(Long senderId, Long receiverId);
    Long getCountMessages(Long senderId);
    List<Message> getConversation(Long senderId, Long receiverId);
    Message saveMessage(Long senderId, Long receiverId, String text);
    void deleteMessage(Long id);
    Message updateMessage(Long id, String text);

}
