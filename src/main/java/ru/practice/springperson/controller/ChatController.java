package ru.practice.springperson.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.practice.springperson.dto.MessageDTO;
import ru.practice.springperson.model.Person;
import ru.practice.springperson.service.MessageService;
import ru.practice.springperson.service.PersonService;

import java.util.List;
/*http://localhost:8081/chat?senderId=1&receiverId=2*/
@Controller
@RequestMapping("/chat")
@AllArgsConstructor
public class ChatController {

    private final MessageService messageService;
    private final PersonService personService;

    // Отображение страницы чата
/*    @GetMapping()
    public String showChat(Model model, @RequestParam Long senderId, @RequestParam Long receiverId) {
        List<Person> persons = personService.getAllPersonsExcept(senderId); // Получаем всех, кроме отправителя
        model.addAttribute("persons", persons);

        if (receiverId != null) {
            List<Message> messages = messageService.getConversation(senderId, receiverId);
            model.addAttribute("messages", messages);
            model.addAttribute("selectedReceiverId", receiverId); // Передаем выбранного получателя
        }

        return "chat";
    }*/

    @GetMapping("")
    public String showChat2(Model model, @RequestParam Long senderId, @RequestParam Long receiverId) {
        List<Person> persons = personService.getAllPersonsExcept(senderId); // Получаем всех, кроме отправителя
        model.addAttribute("persons", persons);

        if (receiverId != null) {
            List<MessageDTO> messages = messageService.getMessages(senderId, receiverId);
            model.addAttribute("messages", messages);
            model.addAttribute("selectedReceiverId", receiverId); // Передаем выбранного получателя
        }

        return "chat";
    }

    @PostMapping()
    public String sendMessage(@RequestParam Long senderId,
                              @RequestParam Long receiverId,
                              @RequestParam String text) {
        // Сохранение сообщения
        messageService.saveMessage(senderId, receiverId, text);
        // Перенаправление обратно на страницу чата с обновленным списком сообщений
        return "redirect:/chat?senderId=" + senderId + "&receiverId=" + receiverId;
    }

}
