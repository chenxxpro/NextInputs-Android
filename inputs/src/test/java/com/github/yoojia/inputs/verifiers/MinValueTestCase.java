package com.github.yoojia.inputs.verifiers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class MinValueTestCase {

    @Test
    public void testPassed() throws Exception {
        MinValueVerifier verifier = new MinValueVerifier(10);
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("10"));
        Assert.assertTrue(verifier.perform("11"));
        Assert.assertTrue(verifier.perform("9999"));
    }

    @Test
    public void testFail() throws Exception {
        MinValueVerifier verifier = new MinValueVerifier(10);
        Assert.assertFalse(verifier.perform("9"));
        Assert.assertFalse(verifier.perform("0"));
        Assert.assertFalse(verifier.perform("-1"));
        Assert.assertFalse(verifier.perform("-10"));
        Assert.assertFalse(verifier.perform("-99"));
    }
}
