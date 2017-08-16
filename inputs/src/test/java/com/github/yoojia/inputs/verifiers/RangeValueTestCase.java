package com.github.yoojia.inputs.verifiers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class RangeValueTestCase {

    @Test
    public void testPassed() throws Exception {
        RangeValueVerifier verifier = new RangeValueVerifier(5, 10);
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("5"));
        Assert.assertTrue(verifier.perform("8"));
        Assert.assertTrue(verifier.perform("10"));
    }

    @Test
    public void testFail() throws Exception {
        RangeValueVerifier verifier = new RangeValueVerifier(5, 10);
        Assert.assertFalse(verifier.perform("-10"));
        Assert.assertFalse(verifier.perform("4"));
        Assert.assertFalse(verifier.perform("11"));
        Assert.assertFalse(verifier.perform("999"));
    }
}
