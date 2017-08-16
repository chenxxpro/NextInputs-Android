package com.github.yoojia.inputs;

import java.util.regex.Pattern;

/**
 *
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
public final class Texts {

    /**
     * Is char sequence empty
     * @param value Value
     * @return is empty
     */
    public static boolean isEmpty(CharSequence value) {
        return value == null || value.length() == 0;
    }

    /**
     * If input matched regex
     * @param input Input String
     * @param regex Regex
     * @return is matched
     */
    public static boolean regexMatch(String input, String regex) {
        return Pattern.compile(regex).matcher(input).matches();
    }

}
