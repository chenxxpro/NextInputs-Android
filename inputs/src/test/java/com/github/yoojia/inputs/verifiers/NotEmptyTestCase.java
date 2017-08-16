package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class NotEmptyTestCase {

    @Test
    public void testPassed() throws Exception {
        Verifier verifier = new NotEmptyVerifier();
        Assert.assertTrue(verifier.perform("1"));
        Assert.assertTrue(verifier.perform("abc"));
    }

    @Test
    public void testFail() throws Exception {
        Verifier verifier = new NotEmptyVerifier();
        Assert.assertFalse(verifier.perform(null));
        Assert.assertFalse(verifier.perform(""));
    }
}
