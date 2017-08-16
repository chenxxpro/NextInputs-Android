package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader1A;
import com.github.yoojia.inputs.Loader1B;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class DateAfterVerifier extends SingleDateTimeVerifier {

    public DateAfterVerifier(Loader1A<Date> valueLoader) {
        super(valueLoader, DATE_FORMAT);
    }

    public DateAfterVerifier(Loader1A<Date> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public DateAfterVerifier(Loader1B<String> valueLoader) {
        super(valueLoader, DATE_FORMAT);
    }

    public DateAfterVerifier(Loader1B<String> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public DateAfterVerifier(Date fixedValue) {
        super(fixedValue, DATE_FORMAT);
    }

    public DateAfterVerifier(Date fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    public DateAfterVerifier(String fixedValue) {
        super(fixedValue, DATE_FORMAT);
    }

    public DateAfterVerifier(String fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    @Override
    protected boolean performTyped(Long typedInput) {
        return getBenchmarkValue() < typedInput;
    }

}
