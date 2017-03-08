package ru.kpfu.itis.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudLogger {
    private static Logger log = Logger.getLogger(StudLogger.class.getName());
    private static final String POSITION = "student";

    @Before("execution(* ru.kpfu.itis.components.Human.getId())")
    public void logBeforeGetId() {
        log.info("Getting id");
    }

    @After("execution(* ru.kpfu.itis.components.Human.getId())")
    public void logAfterGetId() {
        log.info("Id is got");
    }

    @Around("execution(* ru.kpfu.itis.components.Human.getAge())")
    public int logAroundGetAge(ProceedingJoinPoint joinPoint) {
        log.info("Getting age");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("Age is got");
        return 0;
    }

    @AfterReturning(value = "execution(* ru.kpfu.itis.components.Human.getPosition())", returning = POSITION)
    public void logAfterReturningPosition() {
        log.info("Position is " + POSITION);
    }

    @AfterThrowing(value = ("execution(* ru.kpfu.itis.components.Human.*())"), throwing = "e")
    public void logAfterThrowinfException(Exception e) {
        log.error("Occurred exception: " + e.getClass());
    }
}
