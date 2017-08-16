package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class MaxLengthTestCase {

    @Test
    public void testPassed() throws Exception {
        Verifier verifier = new MaxLengthVerifier(10);
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("1"));
        Assert.assertTrue(verifier.perform("12345"));
        Assert.assertTrue(verifier.perform("123456789"));
    }

    @Test
    public void testFail() throws Exception {
        Verifier verifier = new MaxLengthVerifier(5);
        Assert.assertFalse(verifier.perform("123456"));
        Assert.assertFalse(verifier.perform("123456789"));
    }
}
