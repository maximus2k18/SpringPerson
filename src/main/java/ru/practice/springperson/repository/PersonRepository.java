package ru.practice.springperson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practice.springperson.model.Person;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long> {
    void deleteByEmail(String email);
    Person findByEmail (String email);
    List<Person> findAllByIdNot(Long id);
}
