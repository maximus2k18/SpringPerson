package ru.practice.springperson.service;

import ru.practice.springperson.model.Person;

import java.util.List;

public interface PersonService {

    public List<Person> getPersonList();
    Person savePerson(Person person);
    Person updatePerson(Person person);
    Person findByEmail(String email);
    void deletePerson(String email);

    long countPerson();
}
