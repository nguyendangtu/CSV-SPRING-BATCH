package com.demo.assignment.exception;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author JOHNNGUYEN
 * @Project assignment
 * @Created 04/05/2020 - 9:03 PM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GeneralLogs {
    Level level() default Level.INFO;

    enum Level {
        ERROR, DEBUG, INFO
    }

}
