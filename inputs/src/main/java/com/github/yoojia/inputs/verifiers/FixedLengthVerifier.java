package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader1A;
import com.github.yoojia.inputs.SingleVerifier;

/**
 * @author YOOJIA CHEN (yoojiachen@gmail.com)
 * @since 1.6.1
 */
public class FixedLengthVerifier extends SingleVerifier<Long> {

    public FixedLengthVerifier(Loader1A<Long> valueLoader) {
        super(valueLoader);
    }

    public FixedLengthVerifier(long fixedValue) {
        super(fixedValue);
    }

    @Override
    protected boolean performTyped(Long typedInput) {
        return typedInput.longValue() == getBenchmarkValue();
    }

    @Override
    protected Long typedCast(String notEmptyInput) {
        return (long)notEmptyInput.length();
    }
}
