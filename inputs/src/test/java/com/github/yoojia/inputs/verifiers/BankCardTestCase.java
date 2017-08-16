package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class BankCardTestCase {

    @Test
    public void testPassed() throws Exception {
        Verifier verifier = new BankCardVerifier();
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("378282246310005"));
        Assert.assertTrue(verifier.perform("371449635398431"));
        Assert.assertTrue(verifier.perform("378734493671000"));
        Assert.assertTrue(verifier.perform("5610591081018250"));
        Assert.assertTrue(verifier.perform("30569309025904"));
        Assert.assertTrue(verifier.perform("38520000023237"));
        Assert.assertTrue(verifier.perform("6011111111111117"));
        Assert.assertTrue(verifier.perform("6011000990139424"));
        Assert.assertTrue(verifier.perform("3530111333300000"));
        Assert.assertTrue(verifier.perform("3566002020360505"));
        Assert.assertTrue(verifier.perform("5555555555554444"));
        Assert.assertTrue(verifier.perform("5105105105105100"));
        Assert.assertTrue(verifier.perform("4111111111111111"));
        Assert.assertTrue(verifier.perform("4012888888881881"));
        Assert.assertTrue(verifier.perform("4222222222222"));
        Assert.assertTrue(verifier.perform("5019717010103742"));
        Assert.assertTrue(verifier.perform("6331101999990016"));
        Assert.assertTrue(verifier.perform("869926735116986"));
        Assert.assertTrue(verifier.perform("4121551474702170"));
    }

    @Test
    public void testFail() throws Exception {
        Verifier verifier = new BankCardVerifier();
        Assert.assertFalse(verifier.perform("abc"));
        Assert.assertFalse(verifier.perform("123456789012345"));
        Assert.assertFalse(verifier.perform("123456789012345678"));
        Assert.assertFalse(verifier.perform("411111111111111X"));
        Assert.assertFalse(verifier.perform("E111111111111111"));
    }
}
