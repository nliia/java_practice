package ru.kpfu.itis;

import ru.kpfu.itis.components.Human;
import ru.kpfu.itis.components.impl.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
//        Human student = context.getBean(Human.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
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

