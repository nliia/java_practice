package ru.kpfu.itis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import ru.kpfu.itis.components.Human;
import ru.kpfu.itis.config.JavaConfig;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Human student = context.getBean(Human.class);

        try {
            System.out.println(student.getId());
            System.out.println(student.getPosition());
            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getSurname());
        } catch (NullPointerException e) {

        }
    }
}

