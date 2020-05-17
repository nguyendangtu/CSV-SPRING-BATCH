package com.demo.assignment.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * @author JOHNNGUYEN
 * @Project assignment
 * @Created 05/05/2020 - 8:49 AM
 */
public class DateUtilTest {

    @Test
    public void convertStringToDate() {
        String date = "09.06.14";
        String format = "dd.MM.yy";
        LocalDate local_date = DateUtil.convertStringToDate(date, format);
        Assert.assertEquals("2014-06-09", local_date.toString());
    }
}