package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader1A;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class NotEqualsTestCase {

    @Test
    public void testPassed() throws Exception {
        NotEqualsVerifier verifier = new NotEqualsVerifier(new Loader1A<String>() {
            @Override
            public String getValue() {
                return "NextInputs";
            }
        });
        Assert.assertTrue(verifier.perform("NextInputs-NE"));
    }

    @Test
    public void testFail() throws Exception {
        NotEqualsVerifier verifier = new NotEqualsVerifier(new Loader1A<String>() {
            @Override
            public String getValue() {
                return "NextInputs";
            }
        });
        Assert.assertFalse(verifier.perform("NextInputs"));
    }
}
