package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class NumericLettersTestCase {

    @Test
    public void testPassed() throws Exception {
        Verifier verifier = new NumericLettersVerifier();
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("0"));
        Assert.assertTrue(verifier.perform("123"));
        Assert.assertTrue(verifier.perform("A"));
        Assert.assertTrue(verifier.perform("ABC"));
        Assert.assertTrue(verifier.perform("d"));
        Assert.assertTrue(verifier.perform("def"));
        Assert.assertTrue(verifier.perform("2B"));
        Assert.assertTrue(verifier.perform("123ABC"));
        Assert.assertTrue(verifier.perform("123abc"));
        Assert.assertTrue(verifier.perform("123abcDEF"));
    }

    @Test
    public void testFail() throws Exception {
        Verifier verifier = new NumericLettersVerifier();
        Assert.assertFalse(verifier.perform("-1"));
        Assert.assertFalse(verifier.perform("2."));
        Assert.assertFalse(verifier.perform("2.0"));
        Assert.assertFalse(verifier.perform("2.A"));
        Assert.assertFalse(verifier.perform("2.a"));
        Assert.assertFalse(verifier.perform("***//"));
        Assert.assertFalse(verifier.perform("123..."));
        Assert.assertFalse(verifier.perform("123..."));
        Assert.assertFalse(verifier.perform("abc..."));
        Assert.assertFalse(verifier.perform("ABC..."));
    }
}
