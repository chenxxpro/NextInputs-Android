package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class NotBlankTestCase {

    @Test
    public void testPassed() throws Exception {
        Verifier verifier = new NotBlankVerifier();
        Assert.assertTrue(verifier.perform("1"));
        Assert.assertTrue(verifier.perform("abc"));
    }

    @Test
    public void testFail() throws Exception {
        Verifier verifier = new NotBlankVerifier();
        Assert.assertFalse(verifier.perform(null));
        Assert.assertFalse(verifier.perform(""));
        Assert.assertFalse(verifier.perform("  "));
        Assert.assertFalse(verifier.perform(" "));
        Assert.assertFalse(verifier.perform("    "));
    }
}
