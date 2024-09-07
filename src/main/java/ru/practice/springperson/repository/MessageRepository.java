package ru.practice.springperson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practice.springperson.model.Message;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
    List<Message> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
    Long countBySenderId(Long senderId);
    void deleteById(Long id);
    Optional<Message> findById(Long id);
}


