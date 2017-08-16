package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 * http://blogs.msdn.com/b/testing123/archive/2009/02/05/email-address-test-cases.aspx
 */
public class EmailTestCase {

    @Test
    public void testPassed() throws Exception {
        Verifier verifier = new EmailVerifier();
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("email@domain.com"));
        Assert.assertTrue(verifier.perform("firstname.lastname@domain.com"));
        Assert.assertTrue(verifier.perform("email@subdomain.domain.com"));
        Assert.assertTrue(verifier.perform("firstname+lastname@domain.com"));
        Assert.assertTrue(verifier.perform("email@123.123.123.123"));
        Assert.assertTrue(verifier.perform("1234567890@domain.com"));
        Assert.assertTrue(verifier.perform("email@domain-one.com"));
        Assert.assertTrue(verifier.perform("_______@domain.com"));
        Assert.assertTrue(verifier.perform("email@domain.name"));
        Assert.assertTrue(verifier.perform("email@domain.co.jp"));
        Assert.assertTrue(verifier.perform("firstname-lastname@domain.com"));
    }

    @Test
    public void testFail() throws Exception {
        Verifier verifier = new EmailVerifier();
        Assert.assertFalse(verifier.perform("plainaddress"));
        Assert.assertFalse(verifier.perform("#@%^%#$@#$@#.com"));
        Assert.assertFalse(verifier.perform("@domain.com"));
        Assert.assertFalse(verifier.perform("Joe Smith <email@domain.com>"));
        Assert.assertFalse(verifier.perform("email.domain.com"));
        Assert.assertFalse(verifier.perform("email@domain@domain.com"));
        Assert.assertFalse(verifier.perform(".email@domain.com"));
        Assert.assertFalse(verifier.perform("email.@domain.com"));
        Assert.assertFalse(verifier.perform("email..email@domain.com"));
        Assert.assertFalse(verifier.perform("あいうえお@domain.com"));
        Assert.assertFalse(verifier.perform("email@domain.com (Joe Smith)"));
        Assert.assertFalse(verifier.perform("email@domain"));
        Assert.assertFalse(verifier.perform("email@-domain.com"));
        Assert.assertFalse(verifier.perform("email@domain..com"));
    }
}
