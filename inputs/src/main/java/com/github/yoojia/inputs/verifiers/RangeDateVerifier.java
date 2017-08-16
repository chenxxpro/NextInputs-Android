package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader2A;
import com.github.yoojia.inputs.Loader2B;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class RangeDateVerifier extends PairedDateTimeVerifier {

    public RangeDateVerifier(Loader2B<String> valueLoader) {
        super(valueLoader, SingleDateTimeVerifier.DATE_FORMAT);
    }

    public RangeDateVerifier(Loader2B<String> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public RangeDateVerifier(Loader2A<Date> valueLoader) {
        super(valueLoader, SingleDateTimeVerifier.DATE_FORMAT);
    }

    public RangeDateVerifier(Loader2A<Date> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public RangeDateVerifier(Date fixedFirstValue, Date fixedSecondValue, SimpleDateFormat format) {
        super(fixedFirstValue, fixedSecondValue, format);
    }

    public RangeDateVerifier(Date fixedFirstValue, Date fixedSecondValue) {
        super(fixedFirstValue, fixedSecondValue, SingleDateTimeVerifier.DATE_FORMAT);
    }

    public RangeDateVerifier(String fixedFirstValue, String fixedSecondValue, SimpleDateFormat format) {
        super(fixedFirstValue, fixedSecondValue, format);
    }

    public RangeDateVerifier(String fixedFirstValue, String fixedSecondValue) {
        super(fixedFirstValue, fixedSecondValue, SingleDateTimeVerifier.DATE_FORMAT);
    }

    @Override
    protected boolean performTyped(Long typedInput) {
        return benchmark1stValue() <= typedInput && typedInput <= benchmark2ndValue();
    }

}
