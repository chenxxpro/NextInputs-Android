package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class IPv4TestCase {

    @Test
    public void testPassed() throws Exception {
        Verifier verifier = new IPv4Verifier();
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("0.0.0.0"));
        Assert.assertTrue(verifier.perform("1.1.1.1"));
        Assert.assertTrue(verifier.perform("192.168.1.100"));
        Assert.assertTrue(verifier.perform("10.0.0.0"));
        Assert.assertTrue(verifier.perform("255.255.255.255"));
    }

    @Test
    public void testFail() throws Exception {
        Verifier verifier = new IPv4Verifier();
        Assert.assertFalse(verifier.perform("1"));
        Assert.assertFalse(verifier.perform("1.2.3.4.5"));
        Assert.assertFalse(verifier.perform("300.2.3.4"));
        Assert.assertFalse(verifier.perform("256.2.3.4"));
        Assert.assertFalse(verifier.perform("255.255.255.256"));
        Assert.assertFalse(verifier.perform("255.255.255.abc"));
        Assert.assertFalse(verifier.perform("255.255.256"));
        Assert.assertFalse(verifier.perform("255.255..256"));
        Assert.assertFalse(verifier.perform("0-123-234-1"));
    }
}
