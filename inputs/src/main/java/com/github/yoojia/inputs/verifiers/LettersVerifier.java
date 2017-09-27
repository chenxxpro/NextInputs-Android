package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.EmptyableVerifier;

/**
 * 纯数字校验器
 *
 * @author Yoojia Chen (yoojia.chen@gmail.com)
 * @since 1.1
 */
public class LettersVerifier extends EmptyableVerifier {

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        for (int i = 0; i < notEmptyInput.length(); i++) {
            if (!Character.isLetter(notEmptyInput.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
