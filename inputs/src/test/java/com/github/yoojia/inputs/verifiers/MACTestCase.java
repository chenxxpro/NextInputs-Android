package com.github.yoojia.inputs.verifiers;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class MACTestCase {

    @Test
    public void testPassed() throws Exception {
        MACAddressVerifier verifier = new MACAddressVerifier();
        Assert.assertTrue(verifier.performTestNotEmpty("00:00:00:00:00:00"));
        Assert.assertTrue(verifier.performTestNotEmpty("08:00:69:02:01:FC"));
        Assert.assertTrue(verifier.performTestNotEmpty("08:00:77:02:01:AA"));
        Assert.assertTrue(verifier.performTestNotEmpty("00-0D-60-2A-07-F0"));
        Assert.assertTrue(verifier.performTestNotEmpty("FF:FF:FF:FF:FF:FF"));
    }

    @Test
    public void testFail() throws Exception {
        MACAddressVerifier verifier = new MACAddressVerifier();
        Assert.assertFalse(verifier.performTestNotEmpty("FF:FF:FF:FF:FF:FF:FF"));
        Assert.assertFalse(verifier.performTestNotEmpty("FF:FF:FF:FF:FF:GG"));
        Assert.assertFalse(verifier.performTestNotEmpty("FFFFFFFFFFFF"));
        Assert.assertFalse(verifier.performTestNotEmpty("00:00:00:00:00"));
        Assert.assertFalse(verifier.performTestNotEmpty("11+22:33:44:55"));
        Assert.assertFalse(verifier.performTestNotEmpty("KK"));
    }

}
