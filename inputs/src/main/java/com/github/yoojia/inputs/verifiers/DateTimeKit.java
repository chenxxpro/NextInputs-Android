package com.github.yoojia.inputs.verifiers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.8
 */
class DateTimeKit {

    static Date parse(String dateTimeString, SimpleDateFormat format){
        try {
            return format.parse(dateTimeString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    static String format(long dateTimeValue, SimpleDateFormat format){
        return format.format(new Date(dateTimeValue));
    }
}
