package ru.practice.springperson.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @Column(name = "sender_id")
    private Long senderId;

    @Column(name = "receiver_id")
    private Long receiverId;

    // Поле для хранения временной метки сообщения
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "timestamp")
    private Date timestamp;
}

