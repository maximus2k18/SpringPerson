package ru.practice.springperson.repository;

import org.springframework.stereotype.Repository;
import ru.practice.springperson.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryPersonDAO {
    private final List<Person> PERSONS = new ArrayList<>();

    public List<Person> getPersonList() {
        return PERSONS;
    }

    public Person savePerson(Person person) {
        PERSONS.add(person);
        return person;
    }

    public Person findByEmail(String email) {
        return PERSONS.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Person updatePerson(Person student) {
        int studentIndex = IntStream.range(0, PERSONS.size())
                .filter(index -> PERSONS.get(index).getEmail().equals(student.getEmail()))
                .findFirst()
                .orElse(-1);
        if (studentIndex > -1) {
            PERSONS.set(studentIndex, student);
            return student;
        }
        return null;
    }

    public void deletePerson(String email) {
        Person student = findByEmail(email);
        if (student != null) {
            PERSONS.remove(student);
        }

    }
}
