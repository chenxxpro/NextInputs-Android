package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class HostTestCase {

    @Test
    public void testPassed() throws Exception {
        Verifier verifier = new HostVerifier();
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("1.2.3.4"));
        Assert.assertTrue(verifier.perform("abc.com"));
        Assert.assertTrue(verifier.perform("api.abc.com"));
    }

    @Test
    public void testFail() throws Exception {
        Verifier verifier = new HostVerifier();
        Assert.assertFalse(verifier.perform("abc"));
        Assert.assertFalse(verifier.perform("abc..com"));
        Assert.assertFalse(verifier.perform("1.2.3.4.5"));
        Assert.assertFalse(verifier.perform("http://abc.com"));
        Assert.assertFalse(verifier.perform("http://1.2.3.4"));
    }
}
