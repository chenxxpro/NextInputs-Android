package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;

import static com.github.yoojia.inputs.Texts.isEmpty;

/**
 * 非空校验器
 * @author YOOJIA CHEN (yoojiachen@gmail.com)
 * @since 1.1
 */
public class NotEmptyVerifier implements Verifier {
    @Override
    public boolean perform(String rawInput) throws Exception {
        return !isEmpty(rawInput);
    }
}
