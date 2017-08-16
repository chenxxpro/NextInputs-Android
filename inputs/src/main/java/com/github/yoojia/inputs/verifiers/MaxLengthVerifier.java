package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader1A;
import com.github.yoojia.inputs.SingleVerifier;

/**
 * @author YOOJIA CHEN (yoojiachen@gmail.com)
 * @since 1.1
 */
public class MaxLengthVerifier extends SingleVerifier<Long> {

    public MaxLengthVerifier(Loader1A<Long> valueLoader) {
        super(valueLoader);
    }

    public MaxLengthVerifier(long fixedValue) {
        super(fixedValue);
    }

    @Override
    protected boolean performTyped(Long typedInput) {
        return typedInput <= getBenchmarkValue();
    }

    @Override
    protected Long typedCast(String notEmptyInput) {
        return (long)notEmptyInput.length();
    }
}
