package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader1A;
import com.github.yoojia.inputs.Loader1B;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class DateTimeAfterVerifier extends SingleDateTimeVerifier {

    public DateTimeAfterVerifier(Loader1A<Date> valueLoader) {
        super(valueLoader, DATE_TIME_FORMAT);
    }

    public DateTimeAfterVerifier(Loader1A<Date> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public DateTimeAfterVerifier(Loader1B<String> valueLoader) {
        super(valueLoader, DATE_TIME_FORMAT);
    }

    public DateTimeAfterVerifier(Loader1B<String> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public DateTimeAfterVerifier(Date fixedValue) {
        super(fixedValue, DATE_TIME_FORMAT);
    }

    public DateTimeAfterVerifier(Date fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    public DateTimeAfterVerifier(String fixedValue) {
        super(fixedValue, DATE_TIME_FORMAT);
    }

    public DateTimeAfterVerifier(String fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    @Override
    protected boolean performTyped(Long typedInput) {
        return getBenchmarkValue() < typedInput;
    }
}
