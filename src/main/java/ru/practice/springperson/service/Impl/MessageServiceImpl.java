package ru.practice.springperson.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practice.springperson.dto.MessageDTO;
import ru.practice.springperson.model.Message;
import ru.practice.springperson.repository.MessageRepository;
import ru.practice.springperson.service.MessageService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;

    @Override
    public List<MessageDTO> getMessages(Long senderId, Long receiverId) {

        List<Message> messages = messageRepository.findBySenderIdAndReceiverId(senderId, receiverId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return messages.stream()
                .map(message -> new MessageDTO(
                        message.getSenderId(),
                        message.getReceiverId(),
                        message.getText(),
                        dateFormat.format(message.getTimestamp())
                ))
                .collect(Collectors.toList());

    }

    @Override
    public Long getCountMessages(Long senderId) {
        return messageRepository.countBySenderId(senderId);
    }

    @Override
    public List<Message> getConversation(Long senderId, Long receiverId) {
        return messageRepository.findBySenderIdAndReceiverId(senderId, receiverId);
    }

    @Override
    public Message saveMessage(Long senderId, Long receiverId, String text) {
        // Создаем новый объект Message
        Message message = new Message();
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);
        message.setText(text);
        // Устанавливаем текущую дату и время
        message.setTimestamp(new Date());
        // Сохраняем и возвращаем сообщение
        return messageRepository.save(message);
    }


    @Override
    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

    @Override
    public Message updateMessage(Long id, String text) {
        return messageRepository.findById(id)
                .map(message -> {
                    message.setText(text);  // Обновляем текст существующего сообщения
                    return messageRepository.save(message);  // Сохраняем обновлённое сообщение
                })
                .orElseThrow(() -> new RuntimeException("Message not found or does not exist!!"));
    }

}
