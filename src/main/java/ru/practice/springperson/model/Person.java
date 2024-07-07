package ru.practice.springperson.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@Table(name = "Persones")
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String lastName;
    private String firstName;
    @Column(unique = true)
    private String email;
    private LocalDate dateOfBirth;
    @Transient
    private int age;

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }
}
