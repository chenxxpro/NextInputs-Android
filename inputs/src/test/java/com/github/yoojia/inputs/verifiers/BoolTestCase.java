package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class BoolTestCase {

    @Test
    public void testTrue() throws Exception {
        Verifier verifier = new BoolVerifier(true);
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("true"));

        Assert.assertFalse(verifier.perform("trueHHH"));
    }

    @Test
    public void testFalse() throws Exception {
        Verifier verifier = new BoolVerifier(false);
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("false"));

        Assert.assertFalse(verifier.perform("falseXXX"));
    }
}
