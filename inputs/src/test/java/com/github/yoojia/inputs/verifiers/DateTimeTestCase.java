package com.github.yoojia.inputs.verifiers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class DateTimeTestCase {

    @Test
    public void testBefore() throws Exception {
        DateTimeBeforeVerifier verifier = new DateTimeBeforeVerifier("2016-02-01 12:12:12");
        Assert.assertTrue(verifier.perform("2016-02-01 12:12:11"));
        Assert.assertTrue(verifier.perform("2016-01-31 00:00:00"));
        Assert.assertTrue(verifier.perform("2015-02-01 12:12:12"));
        Assert.assertTrue(verifier.perform("2015-02-02 12:12:12"));
        Assert.assertFalse(verifier.perform("2016-02-28 12:12:12"));
    }

    @Test
    public void testAfter() throws Exception {
        DateTimeAfterVerifier verifier = new DateTimeAfterVerifier("2016-09-19 12:12:12");
        Assert.assertTrue(verifier.perform("2016-09-20 00:00:00"));
        Assert.assertTrue(verifier.perform("2016-09-19 12:12:13"));
        Assert.assertFalse(verifier.perform("2016-09-19 12:12:11"));
    }
}
