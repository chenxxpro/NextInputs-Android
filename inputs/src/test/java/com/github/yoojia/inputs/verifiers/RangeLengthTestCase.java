package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class RangeLengthTestCase {

    @Test
    public void testPassed() throws Exception {
        RangeLengthVerifier verifier = new RangeLengthVerifier(3, 5);
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("123"));
        Assert.assertTrue(verifier.perform("1234"));
        Assert.assertTrue(verifier.perform("12345"));
    }

    @Test
    public void testFail() throws Exception {
        RangeLengthVerifier verifier = new RangeLengthVerifier(3,5);
        Assert.assertFalse(verifier.perform("1"));
        Assert.assertFalse(verifier.perform("12"));
        Assert.assertFalse(verifier.perform("123456"));
        Assert.assertFalse(verifier.perform("1234567"));
    }
}
