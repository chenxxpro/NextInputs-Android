package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.EmptyableVerifier;

import static com.github.yoojia.inputs.Texts.regexMatch;

/**
 * 纯数字校验器
 * @author Yoojia Chen (yoojia.chen@gmail.com)
 * @since 1.1
 */
public class NumericLettersVerifier extends EmptyableVerifier {

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        return isNumericLetters(notEmptyInput);
    }

    static boolean isNumericLetters(String notEmptyInput){
        return regexMatch(notEmptyInput,
                "[0-9A-Za-z]*");
    }

}
