package ru.practice.springperson.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.practice.springperson.dto.MessageDTO;
import ru.practice.springperson.model.Message;
import ru.practice.springperson.service.MessageService;

import java.util.List;
/*http://localhost:8081/chat?senderId=1&receiverId=2*/
@Controller
@RequestMapping("/chat")
@AllArgsConstructor
public class ChatController {

    private final MessageService messageService;

    // Отображение страницы чата
    @GetMapping()
    public String showChat(Model model, @RequestParam Long senderId, @RequestParam Long receiverId) {
        List<Message> messages = messageService.getConversation(senderId, receiverId);
        model.addAttribute("messages", messages);
        return "chat";
    } // Отображение страницы чата

    @GetMapping("/new")
    public String showChat2(Model model, @RequestParam Long senderId, @RequestParam Long receiverId) {
        List<MessageDTO> messages = messageService.getMessages(senderId, receiverId);
        model.addAttribute("messages", messages);
        return "chat";
    }


}
