package ru.practice.springperson.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practice.springperson.dto.MessagePerson;
import ru.practice.springperson.dto.MessageDTO;
import ru.practice.springperson.model.Message;
import ru.practice.springperson.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/messages")
@AllArgsConstructor
public class MessageRestController {

    private final MessageService messageService;

    @GetMapping("/count")
    public Long getCountMessagesFromUser(@RequestParam Long senderId){
        return messageService.getCountMessages(senderId);
    }

    @GetMapping("/conversation")
    public List<Message> getMessageList(@RequestBody MessagePerson messagePerson) {
        return messageService.getConversation(
                messagePerson.getSenderId(),
                messagePerson.getReceiverId()
        );
    }

    // Эндпоинт для отправки нового сообщения (принимает JSON)
    @PostMapping
    public Message sendMessage(@RequestBody MessageDTO messageRequest) {
        return messageService.saveMessage(
                messageRequest.getSenderId(),
                messageRequest.getReceiverId(),
                messageRequest.getText()
        );
    }

    @PatchMapping("/{id}")
    public Message updateMessage(@PathVariable Long id, @RequestBody String text) {
        return messageService.updateMessage(id, text);
    }

    @DeleteMapping
    public void deleteMessage(@RequestParam Long id) {
        messageService.deleteMessage(id);
    }
}
