package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class LettersTestCase {

    @Test
    public void testPassed() throws Exception {
        Verifier verifier = new LettersVerifier();
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("A"));
        Assert.assertTrue(verifier.perform("BC"));
        Assert.assertTrue(verifier.perform("a"));
        Assert.assertTrue(verifier.perform("abc"));
        Assert.assertTrue(verifier.perform("aSdF"));
    }

    @Test
    public void testFail() throws Exception {
        Verifier verifier = new LettersVerifier();
        Assert.assertFalse(verifier.perform("-"));
        Assert.assertFalse(verifier.perform("2."));
        Assert.assertFalse(verifier.perform("2.0"));
        Assert.assertFalse(verifier.perform("2A"));
        Assert.assertFalse(verifier.perform("2a"));
        Assert.assertFalse(verifier.perform("***//"));
        Assert.assertFalse(verifier.perform("abc123..."));
    }
}
