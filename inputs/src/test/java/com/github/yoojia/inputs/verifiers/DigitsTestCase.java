package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class DigitsTestCase {

    @Test
    public void testPassed() throws Exception {
        Verifier verifier = new DigitsVerifier();
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("1"));
        Assert.assertTrue(verifier.perform("123"));
        Assert.assertTrue(verifier.perform("99999999999"));
    }

    @Test
    public void testFail() throws Exception {
        Verifier verifier = new DigitsVerifier();
        Assert.assertFalse(verifier.perform("1a"));
        Assert.assertFalse(verifier.perform("123l"));
        Assert.assertFalse(verifier.perform("123456L"));
        Assert.assertFalse(verifier.perform("0x123"));
        Assert.assertFalse(verifier.perform("0xFF"));
        Assert.assertFalse(verifier.perform("0x00"));
        Assert.assertFalse(verifier.perform("abc"));
    }
}
