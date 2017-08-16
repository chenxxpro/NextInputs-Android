package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class ChineseMobileTestCase {

    @Test
    public void testPassed() throws Exception {
        Verifier verifier = new MobileVerifier();
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("13800138000"));
        Assert.assertTrue(verifier.perform("13570859999"));
        Assert.assertTrue(verifier.perform("13112111001"));
    }

    @Test
    public void testFail() throws Exception {
        Verifier verifier = new MobileVerifier();
        Assert.assertFalse(verifier.perform("12306"));
        Assert.assertFalse(verifier.perform("mobile"));
        Assert.assertFalse(verifier.perform("88888888"));
        Assert.assertFalse(verifier.perform("123456789012"));
        Assert.assertFalse(verifier.perform("1234567890X"));
    }
}
