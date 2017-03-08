package ru.kpfu.itis.components.impl;


import org.springframework.stereotype.Component;
import ru.kpfu.itis.components.Human;

import javax.annotation.PostConstruct;

@Component
public class Student implements Human {
    private int id;
    private String name;
    private String surname;
    private int age;
    public static final String POSITION = "student";

    @PostConstruct
    public void init() {
        this.id = 1;
        this.age = 27;
        this.name = "Jane";
//        this.surname = "Jackson";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {

        if (name == null)
            throw new NullPointerException();
        else
            return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        if (surname == null)
            throw new NullPointerException();
        else
            return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return POSITION;
    }
}
