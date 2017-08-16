package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Geek_Soledad (msdx.android@qq.com)
 * @version 2016-09-07
 * @since 2016-09-07
 */
public class MobileTestCase {
    @Test
    public void testPassed() throws Exception {
        Verifier verifier = new MobileVerifier();
        Assert.assertTrue(verifier.perform("13012345678"));
        Assert.assertTrue(verifier.perform("14112345678"));
        Assert.assertTrue(verifier.perform("15212345678"));
        Assert.assertTrue(verifier.perform("17412345678"));
        Assert.assertTrue(verifier.perform("18512345678"));
        Assert.assertTrue(verifier.perform("+8613112345678"));
        Assert.assertTrue(verifier.perform("+86-13112345678"));
        Assert.assertTrue(verifier.perform("8613112345678"));

    }

    @Test
    public void testFail() throws Exception {
        Verifier verifier = new MobileVerifier();
        Assert.assertFalse(verifier.perform("1211234567"));
        Assert.assertFalse(verifier.perform("121123456789"));
        Assert.assertFalse(verifier.perform("12112345678"));
        Assert.assertFalse(verifier.perform("11112345678"));
        Assert.assertFalse(verifier.perform("10112345678"));
        Assert.assertFalse(verifier.perform("16112345678"));
        Assert.assertFalse(verifier.perform("19112345678"));
        Assert.assertFalse(verifier.perform("+13112345678"));
    }
}
