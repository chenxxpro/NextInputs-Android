package com.github.yoojia.inputs.verifiers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class DateTestCase {

    @Test
    public void testBefore() throws Exception {
        DateBeforeVerifier verifier = new DateBeforeVerifier("2016-02-01");
        Assert.assertTrue(verifier.perform("2016-01-31"));
        Assert.assertTrue(verifier.perform("2015-02-01"));
        Assert.assertTrue(verifier.perform("2015-02-02"));
        Assert.assertFalse(verifier.perform("2016-02-28"));
    }

    @Test
    public void testAfter() throws Exception {
        DateAfterVerifier verifier = new DateAfterVerifier("2016-09-19");
        Assert.assertTrue(verifier.perform("2016-09-20"));
        Assert.assertFalse(verifier.perform("2016-09-18"));
    }
}
