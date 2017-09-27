package com.github.yoojia.inputs;

import com.github.yoojia.inputs.verifiers.BankCardVerifier;
import com.github.yoojia.inputs.verifiers.BoolVerifier;
import com.github.yoojia.inputs.verifiers.DigitsVerifier;
import com.github.yoojia.inputs.verifiers.EmailVerifier;
import com.github.yoojia.inputs.verifiers.HostVerifier;
import com.github.yoojia.inputs.verifiers.IDCardVerifier;
import com.github.yoojia.inputs.verifiers.IPv4Verifier;
import com.github.yoojia.inputs.verifiers.MACAddressVerifier;
import com.github.yoojia.inputs.verifiers.MobileVerifier;
import com.github.yoojia.inputs.verifiers.NotBlankVerifier;
import com.github.yoojia.inputs.verifiers.NotEmptyVerifier;
import com.github.yoojia.inputs.verifiers.NumericVerifier;
import com.github.yoojia.inputs.verifiers.TelephoneVerifier;
import com.github.yoojia.inputs.verifiers.URLVerifier;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
public class StaticScheme {

    public static final int PRIORITY_REQUIRED = -1024;
    public static final int PRIORITY_GENERAL = 0;

    public static Scheme Required(){
        return required();
    }

    /**
     * 必要项，输入内容不能为空
     * @return Scheme
     */
    public static Scheme required(){
        return new Scheme(new NotEmptyVerifier()).msg("此为必填项目").priority(PRIORITY_REQUIRED);
    }

    public static Scheme NotBlank(){
        return notBlank();
    }

    /**
     * 输入内容不能为空值：空格，制表符等
     * @return Scheme
     */
    public static Scheme notBlank(){
        return new Scheme(new NotBlankVerifier()).msg("请输入非空内容");
    }

    public static Scheme Digits(){
        return digits();
    }

    /**
     * 输入内容只能是数字
     * @return Scheme
     */
    public static Scheme digits(){
        return new Scheme(new DigitsVerifier()).msg("请输入数字");
    }

    public static Scheme Email(){
        return email();
    }

    /**
     * 电子邮件地址
     * @return Scheme
     */
    public static Scheme email(){
        return new Scheme(new EmailVerifier()).msg("请输入有效的邮件地址");
    }

    public static Scheme IPv4(){
        return ipv4();
    }

    /**
     * IPV4地址
     * @return Scheme
     */
    public static Scheme ipv4(){
        return new Scheme(new IPv4Verifier()).msg("请输入有效的IP地址");
    }

    public static Scheme Host(){
        return host();
    }

    /**
     * 域名地址
     * @return Scheme
     */
    public static Scheme host(){
        return new Scheme(new HostVerifier()).msg("请输入有效的域名地址");
    }

    public static Scheme URL() {
        return url();
    }

    /**
     * URL地址
     * @return Scheme
     */
    public static Scheme url(){
        return new Scheme(new URLVerifier()).msg("请输入有效的网址");
    }

    public static Scheme Numeric() {
        return numeric();
    }

    /**
     * 数值
     * @return Scheme
     */
    public static Scheme numeric(){
        return new Scheme(new NumericVerifier()).msg("请输入有效的数值");
    }

    public static Scheme BankCard() {
        return bankCard();
    }
    /**
     * 银行卡号
     * @return Scheme
     */
    public static Scheme bankCard(){
        return new Scheme(new BankCardVerifier()).msg("请输入有效的银行卡/信用卡号码");
    }

    public static Scheme ChineseIDCard() {
        return chineseIDCard();
    }

    /**
     * 身份证号
     * @return Scheme
     */
    public static Scheme chineseIDCard(){
        return new Scheme(new IDCardVerifier()).msg("请输入有效的身份证号");
    }

    public static Scheme ChineseMobile() {
        return chineseMobile();
    }

    /**
     * 手机号
     * @return Scheme
     */
    public static Scheme chineseMobile(){
        return new Scheme(new MobileVerifier()).msg("请输入有效的手机号");
    }

    public static Scheme ChineseTelephone() {
        return chineseTelephone();
    }

    /**
     * 固定电话号码
     * @return Scheme
     */
    public static Scheme chineseTelephone() {
        return new Scheme(new TelephoneVerifier()).msg("请输入有效的电话号码");
    }


    /**
     * 固定电话号码
     * @return Scheme
     */
    public static Scheme MAC() {
        return new Scheme(new MACAddressVerifier()).msg("请输入有效的MAC地址");
    }

    public static Scheme IsTrue() {
        return isTrue();
    }

    /**
     * 为True状态
     * @return Scheme
     */
    public static Scheme isTrue(){
        return new Scheme(new BoolVerifier(true)).msg("当前项必须为True");
    }

    public static Scheme IsFalse() {
        return isFalse();
    }

    /**
     * 为False状态
     * @return Scheme
     */
    public static Scheme isFalse(){
        return new Scheme(new BoolVerifier(false)).msg("当前项必须为False");
    }

}
