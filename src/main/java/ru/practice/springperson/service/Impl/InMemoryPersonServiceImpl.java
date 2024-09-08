package ru.practice.springperson.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practice.springperson.model.Person;
import ru.practice.springperson.repository.InMemoryPersonDAO;
import ru.practice.springperson.service.PersonService;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryPersonServiceImpl implements PersonService {
    private final InMemoryPersonDAO repository;
    @Override
    public List<Person> getPersonList() {
        return repository.getPersonList();
    }

    @Override
    public Person savePerson(Person person) {
        return repository.savePerson(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return repository.updatePerson(person);
    }

    @Override
    public void deletePerson(String email) {
        repository.deletePerson(email);
    }

    @Override
    public long countPerson() {
        return repository.getPersonList().size();
    }

    @Override
    public List<Person> getAllPersonsExcept(Long senderId) {
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
