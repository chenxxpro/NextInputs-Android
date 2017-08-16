package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.EmptyableVerifier;

import static com.github.yoojia.inputs.Texts.regexMatch;

/**
 * IP(v4)地址校验器
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class IPv4Verifier extends EmptyableVerifier {

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        return isIPv4(notEmptyInput);
    }

    static boolean isIPv4(String notEmptyInput){
        return regexMatch(notEmptyInput,
                "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
    }
}
