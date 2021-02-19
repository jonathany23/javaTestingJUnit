package org.jonathany23.javatests.util;

public class DateUtil {

    public static boolean isLeapYear(int year){
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
