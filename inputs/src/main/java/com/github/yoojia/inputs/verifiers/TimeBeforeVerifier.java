package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader1A;
import com.github.yoojia.inputs.Loader1B;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class TimeBeforeVerifier extends TimeAfterVerifier{

    public TimeBeforeVerifier(Loader1A<Date> valueLoader) {
        super(valueLoader);
    }

    public TimeBeforeVerifier(Loader1A<Date> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public TimeBeforeVerifier(Loader1B<String> valueLoader) {
        super(valueLoader);
    }

    public TimeBeforeVerifier(Loader1B<String> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public TimeBeforeVerifier(Date fixedValue) {
        super(fixedValue);
    }

    public TimeBeforeVerifier(Date fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    public TimeBeforeVerifier(String fixedValue) {
        super(fixedValue);
    }

    public TimeBeforeVerifier(String fixedValue, SimpleDateFormat format) {
        super(fixedValue, format);
    }

    @Override
    protected boolean performTyped(Long typedInput) {
        return getBenchmarkValue() > typedInput;
    }

}
