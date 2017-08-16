package com.github.yoojia.inputs.verifiers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author 黄浩杭 (huanghaohang@parkingwang.com)
 * @version 2016-09-07
 * @since 2016-09-07
 */
public class TelephoneTestCase {
    @Test
    public void testPassed() throws Exception {
        TelephoneVerifier verifier = new TelephoneVerifier();
        Assert.assertTrue(verifier.perform("0660-81234567"));
        Assert.assertTrue(verifier.perform("0660-8123456"));
        Assert.assertTrue(verifier.perform("066081234567"));
        Assert.assertTrue(verifier.perform("01081234567"));
        Assert.assertTrue(verifier.perform("010-81234567"));
        Assert.assertTrue(verifier.perform("020-81234567"));
        Assert.assertTrue(verifier.perform("8123456"));
        Assert.assertTrue(verifier.perform("81234567"));
    }

    @Test
    public void testFail() throws Exception {
        TelephoneVerifier verifier = new TelephoneVerifier();
        Assert.assertFalse(verifier.perform("0660-223456789"));//号码太长
        Assert.assertFalse(verifier.perform("0660-223456"));// 号码太短
        Assert.assertFalse(verifier.perform("0660812345678"));// 号码太长
        Assert.assertFalse(verifier.perform("0660812345")); // 号码太短
        Assert.assertFalse(verifier.perform("0660+81234567"));// 不能用+相连
        Assert.assertFalse(verifier.perform("010 811234567"));// 号码太长
        Assert.assertFalse(verifier.perform("11081234567"));// 区号不能为1开头
        Assert.assertFalse(verifier.perform("01012345678"));// 区号以01开头的只有010，而电话号码不能以1开头
        Assert.assertFalse(verifier.perform("01002345678"));// 区号以01开头的只有010，而电话号码不能以0开头
        Assert.assertFalse(verifier.perform("010-12345678"));// 电话不能以1开头
        Assert.assertFalse(verifier.perform("011-2345678"));//区号01开头的只有010
        Assert.assertFalse(verifier.perform("0211-2345678"));//区号02开头的只有3位
        Assert.assertFalse(verifier.perform("021182345678"));//区号以02开头的只有3位，而电话号码不能以1开头
        Assert.assertFalse(verifier.perform("02118234567"));//区号以02开头的只有3位，而电话号码不能以1开头
        Assert.assertFalse(verifier.perform("12345678"));//电话不能以1开头
        Assert.assertFalse(verifier.perform("1345678"));//同上
        Assert.assertFalse(verifier.perform("02345678"));//电话不能以0开头
        Assert.assertFalse(verifier.perform("0345678"));//同上
        Assert.assertFalse(verifier.perform("345678912"));//号码太长
        Assert.assertFalse(verifier.perform("3456789123"));//没有10位的号码
    }
}
