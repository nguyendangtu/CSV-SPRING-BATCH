package com.demo.assignment.exception;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author JOHNNGUYEN
 * @Project assignment
 * @Created 04/05/2020 - 9:03 PM
 */
@Aspect
@Component
public class GeneralLogsAspect {
    public static final Logger logger = LoggerFactory.getLogger(GeneralLogsAspect.class);

    @Around("execution(* *(..)) && @annotation(com.demo.assignment.exception.GeneralLogs)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = null;

        //handling exception
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            new Thread(() -> handleException(e)).start();
        }

        long timeTaken = System.currentTimeMillis() - start;

        Method method = MethodSignature.class.cast(joinPoint.getSignature()).getMethod();
        GeneralLogs annotation = method.getAnnotation(GeneralLogs.class);
        String methodSignature = method.getDeclaringClass().getName() + ":" + method.getName();

        logMessage(annotation.level(), methodSignature, timeTaken);
        return result;

    }

    public static void logMessage(GeneralLogs.Level logLevel, String methodSignature, long timeTaken, String key) {
        String msg = "Time taken by {} : {} ms [{}]";
        if (logLevel == GeneralLogs.Level.INFO) {
            logger.info(msg, methodSignature, timeTaken, key);
        } else {
            logger.debug(msg, methodSignature, timeTaken, key);
        }
    }

    public static void logMessage(GeneralLogs.Level logLevel, String methodSignature, long timeTaken) {
        logMessage(logLevel, methodSignature, timeTaken, "TimeTaken");
    }

    /***
     * Handle Exception
     * @param e
     */
    public static void handleException(Exception e) {
        logger.error(e.toString());
        //TODO (define error code, error message, category, ...)
    }
}
