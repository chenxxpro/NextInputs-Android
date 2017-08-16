package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.EmptyableVerifier;

/**
 * 纯数字校验器
 * @author Yoojia Chen (yoojia.chen@gmail.com)
 * @since 1.1
 */
public class DigitsVerifier extends EmptyableVerifier {

    @Override
    public boolean performTestNotEmpty(String input) throws Exception {
        return isDigits(input);
    }

    public static boolean isDigits(CharSequence input){
        final int length = input.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
