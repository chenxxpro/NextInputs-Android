package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.EmptyableVerifier;

import static com.github.yoojia.inputs.Texts.regexMatch;

/**
 * @author Geek_Soledad (msdx.android@qq.com)
 * @version 2016-09-07
 * @since 2016-09-07
 */
public class TelephoneVerifier extends EmptyableVerifier {
    /**
     * 区号： 以0开头
     *        01开头的只有010
     *        02开头的是有3位的
     * 电话号码：不能以0或1开头。
     *           加上区号是11或12位。
     */
    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        return regexMatch(notEmptyInput, "^((((010)|(0[2-9]\\d))[-|\\s]?)?[2-9]\\d{7})|((0[3-9]\\d{2}[-|\\s]?)?[2-9]\\d{6,7})$");
    }
}
