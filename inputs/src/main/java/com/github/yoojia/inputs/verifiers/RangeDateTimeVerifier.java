package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader2A;
import com.github.yoojia.inputs.Loader2B;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class RangeDateTimeVerifier extends PairedDateTimeVerifier {

    public RangeDateTimeVerifier(Loader2B<String> valueLoader) {
        super(valueLoader, SingleDateTimeVerifier.DATE_TIME_FORMAT);
    }

    public RangeDateTimeVerifier(Loader2B<String> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public RangeDateTimeVerifier(Loader2A<Date> valueLoader) {
        super(valueLoader, SingleDateTimeVerifier.DATE_TIME_FORMAT);
    }

    public RangeDateTimeVerifier(Loader2A<Date> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public RangeDateTimeVerifier(Date fixedFirstValue, Date fixedSecondValue, SimpleDateFormat format) {
        super(fixedFirstValue, fixedSecondValue, format);
    }

    public RangeDateTimeVerifier(Date fixedFirstValue, Date fixedSecondValue) {
        super(fixedFirstValue, fixedSecondValue, SingleDateTimeVerifier.DATE_TIME_FORMAT);
    }

    public RangeDateTimeVerifier(String fixedFirstValue, String fixedSecondValue, SimpleDateFormat format) {
        super(fixedFirstValue, fixedSecondValue, format);
    }

    public RangeDateTimeVerifier(String fixedFirstValue, String fixedSecondValue) {
        super(fixedFirstValue, fixedSecondValue, SingleDateTimeVerifier.DATE_TIME_FORMAT);
    }

    @Override
    protected boolean performTyped(Long typedInput) {
        return benchmark1stValue() <= typedInput && typedInput <= benchmark2ndValue();
    }

}
