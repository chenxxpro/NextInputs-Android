package com.github.yoojia.inputs.verifiers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class TimeTestCase {

    @Test
    public void testBefore() throws Exception {
        TimeBeforeVerifier verifier = new TimeBeforeVerifier("12:00:00");
        Assert.assertTrue(verifier.perform("00:00:00"));
        Assert.assertTrue(verifier.perform("11:11:11"));
        Assert.assertTrue(verifier.perform("11:59:59"));
        Assert.assertFalse(verifier.perform("12:00:01"));
        Assert.assertFalse(verifier.perform("13:00:00"));
    }

    @Test
    public void testAfter() throws Exception {
        TimeAfterVerifier verifier = new TimeAfterVerifier("12:00:00");
        Assert.assertTrue(verifier.perform("12:00:01"));
        Assert.assertTrue(verifier.perform("13:00:00"));
        Assert.assertFalse(verifier.perform("11:59:59"));
        Assert.assertFalse(verifier.perform("00:00:00"));
    }
}
