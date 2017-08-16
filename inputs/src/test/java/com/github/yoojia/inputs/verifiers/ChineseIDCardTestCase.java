package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test ChineseI DCard Number
 *
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
public class ChineseIDCardTestCase {

    private Verifier mVerifier;

    @Before
    public void before(){
        mVerifier = new IDCardVerifier();
    }

    @Test
    public void testPassed() throws Exception {
        Assert.assertTrue(mVerifier.perform(""));
        Assert.assertTrue(mVerifier.perform("440901197709194316"));
        Assert.assertTrue(mVerifier.perform("440901197502198379"));
        Assert.assertTrue(mVerifier.perform("44090119840325427X"));
        Assert.assertTrue(mVerifier.perform("44090119840325427x"));
        Assert.assertTrue(mVerifier.perform("210303198412082729"));
    }

    @Test
    public void testFail() throws Exception {
        Assert.assertFalse(mVerifier.perform("abc"));
        Assert.assertFalse(mVerifier.perform("1234"));
        Assert.assertFalse(mVerifier.perform("+440901197709194316"));
        Assert.assertFalse(mVerifier.perform("H440901197502198379"));
        Assert.assertFalse(mVerifier.perform("A44090119840325427X"));
        Assert.assertFalse(mVerifier.perform("0440901199006249711"));
    }
}
