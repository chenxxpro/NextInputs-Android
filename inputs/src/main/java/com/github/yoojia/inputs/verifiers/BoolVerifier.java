package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader1A;
import com.github.yoojia.inputs.SingleVerifier;

/**
 * 布尔值校验器
 * @author YOOJIA CHEN (yoojiachen@gmail.com)
 * @since 1.1
 */
public class BoolVerifier extends SingleVerifier<String> {

    public BoolVerifier(final Loader1A<Boolean> valueLoader) {
        super(new Loader1A<String>() {
            @Override
            public String getValue() {
                return valueLoader.getValue().toString();
            }
        });
    }

    public BoolVerifier(Boolean fixedValue) {
        super(fixedValue.toString());
    }

    @Override
    protected String typedCast(String notEmptyInput) {
        return notEmptyInput.toLowerCase();
    }

    @Override
    protected boolean performTyped(String typedInput) {
        return typedInput.equals(getBenchmarkValue());
    }
}
