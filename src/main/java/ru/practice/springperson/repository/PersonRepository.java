package ru.practice.springperson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practice.springperson.model.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {
    void deleteByEmail(String email);
    Person findByEmail (String email);
}
