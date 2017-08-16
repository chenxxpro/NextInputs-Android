package com.github.yoojia.inputs;

import com.github.yoojia.inputs.verifiers.*;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
public class StaticScheme {

    public static final int PRIORITY_REQUIRED = -1024;
    public static final int PRIORITY_GENERAL = 0;

    /**
     * 必要项，输入内容不能为空
     * @return Scheme
     */
    public static Scheme Required(){
        return new Scheme(new NotEmptyVerifier()).msg("此为必填项目").priority(PRIORITY_REQUIRED);
    }

    /**
     * 输入内容不能为空值：空格，制表符等
     * @return Scheme
     */
    public static Scheme NotBlank(){
        return new Scheme(new NotBlankVerifier()).msg("请输入非空内容");
    }

    /**
     * 输入内容只能是数字
     * @return Scheme
     */
    public static Scheme Digits(){
        return new Scheme(new DigitsVerifier()).msg("请输入数字");
    }

    /**
     * 电子邮件地址
     * @return Scheme
     */
    public static Scheme Email(){
        return new Scheme(new EmailVerifier()).msg("请输入有效的邮件地址");
    }

    /**
     * IPV4地址
     * @return Scheme
     */
    public static Scheme IPv4(){
        return new Scheme(new IPv4Verifier()).msg("请输入有效的IP地址");
    }

    /**
     * 域名地址
     * @return Scheme
     */
    public static Scheme Host(){
        return new Scheme(new HostVerifier()).msg("请输入有效的域名地址");
    }

    /**
     * URL地址
     * @return Scheme
     */
    public static Scheme URL(){
        return new Scheme(new URLVerifier()).msg("请输入有效的网址");
    }

    /**
     * 数值
     * @return Scheme
     */
    public static Scheme Numeric(){
        return new Scheme(new NumericVerifier()).msg("请输入有效的数值");
    }

    /**
     * 银行卡号
     * @return Scheme
     */
    public static Scheme BankCard(){
        return new Scheme(new BankCardVerifier()).msg("请输入有效的银行卡/信用卡号码");
    }

    /**
     * 身份证号
     * @return Scheme
     */
    public static Scheme ChineseIDCard(){
        return new Scheme(new IDCardVerifier()).msg("请输入有效的身份证号");
    }

    /**
     * 手机号
     * @return Scheme
     */
    public static Scheme ChineseMobile(){
        return new Scheme(new MobileVerifier()).msg("请输入有效的手机号");
    }

    /**
     * 固定电话号码
     * @return Scheme
     */
    public static Scheme ChineseTelephone() {
        return new Scheme(new TelephoneVerifier()).msg("请输入有效的电话号码");
    }

    /**
     * 固定电话号码
     * @return Scheme
     */
    public static Scheme MAC() {
        return new Scheme(new MACAddressVerifier()).msg("请输入有效的MAC地址");
    }

    /**
     * 为True状态
     * @return Scheme
     */
    public static Scheme IsTrue(){
        return new Scheme(new BoolVerifier(true)).msg("当前项必须为True");
    }

    /**
     * 为False状态
     * @return Scheme
     */
    public static Scheme IsFalse(){
        return new Scheme(new BoolVerifier(false)).msg("当前项必须为False");
    }

}
