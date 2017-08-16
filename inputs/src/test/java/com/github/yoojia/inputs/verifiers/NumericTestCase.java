package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class NumericTestCase {

    @Test
    public void testPassed() throws Exception {
        Verifier verifier = new NumericVerifier();
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("1"));
        Assert.assertTrue(verifier.perform("-123"));
        Assert.assertTrue(verifier.perform("+123"));
        Assert.assertTrue(verifier.perform("12345678L"));
        Assert.assertTrue(verifier.perform("12345678l"));
        Assert.assertTrue(verifier.perform("1.0"));
        Assert.assertTrue(verifier.perform("1.23f"));
        Assert.assertTrue(verifier.perform("1.23456d"));
        Assert.assertTrue(verifier.perform("1.00000"));
        Assert.assertTrue(verifier.perform("1.00000123"));
        Assert.assertTrue(verifier.perform("12345.0"));
        Assert.assertTrue(verifier.perform("-12345.0"));
        Assert.assertTrue(verifier.perform("-12345.0"));
        Assert.assertTrue(verifier.perform("0x01"));
        Assert.assertTrue(verifier.perform("0xFF"));
        Assert.assertTrue(verifier.perform("0xee"));
        Assert.assertTrue(verifier.perform("12e34"));
        Assert.assertTrue(verifier.perform("12E-34"));
    }

    @Test
    public void testFail() throws Exception {
        Verifier verifier = new NumericVerifier();
        Assert.assertFalse(verifier.perform("a"));
        Assert.assertFalse(verifier.perform("1.0.0"));
        Assert.assertFalse(verifier.perform("1.000123K"));
        Assert.assertFalse(verifier.perform("1K"));
        Assert.assertFalse(verifier.perform("1M"));
        Assert.assertFalse(verifier.perform("0xGG"));
        Assert.assertFalse(verifier.perform("12EE34"));
        Assert.assertFalse(verifier.perform("12E.34"));
    }
}
