package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader1A;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class EqualsTestCase {

    @Test
    public void testPassed() throws Exception {
        EqualsVerifier verifier = new EqualsVerifier(new Loader1A<String>() {
            @Override
            public String getValue() {
                return "NextInputs";
            }
        });
        Assert.assertTrue(verifier.perform("NextInputs"));
    }

    @Test
    public void testFail() throws Exception {
        EqualsVerifier verifier = new EqualsVerifier(new Loader1A<String>() {
            @Override
            public String getValue() {
                return "NextInputs";
            }
        });
        Assert.assertFalse(verifier.perform("NextInputs-Java"));
    }
}
