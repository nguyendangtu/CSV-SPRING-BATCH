package com.demo.assignment.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author JOHNNGUYEN
 * @Project assignment
 * @Created 04/05/2020 - 11:27 PM
 */
public class DateUtil {

    public static LocalDate convertStringToDate(String date, String format) {
        if (StringUtils.isNotEmpty(date)) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
            return LocalDate.parse(date, dateTimeFormatter);
        }
        return null;
    }
}

