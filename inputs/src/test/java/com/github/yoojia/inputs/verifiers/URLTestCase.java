package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Verifier;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class URLTestCase {

    @Test
    public void testPassed() throws Exception {
        Verifier verifier = new URLVerifier();
        Assert.assertTrue(verifier.perform(null));
        Assert.assertTrue(verifier.perform(""));
        Assert.assertTrue(verifier.perform("http://163.com"));
        Assert.assertTrue(verifier.perform("http://163-gd.com"));
        Assert.assertTrue(verifier.perform("http://163_cn.com"));
        Assert.assertTrue(verifier.perform("http://163.com.cn"));
        Assert.assertTrue(verifier.perform("http://api.163.com.cn"));
        Assert.assertTrue(verifier.perform("https://google.com"));
        Assert.assertTrue(verifier.perform("http://163.com/api"));
        Assert.assertTrue(verifier.perform("http://163.com/titles/"));
        Assert.assertTrue(verifier.perform("http://163.com/titles/?a=b"));
        Assert.assertTrue(verifier.perform("http://example.org/a-umlaut-%C3%A4"));
        Assert.assertTrue(verifier.perform("https://www.google.co.kr/url?sa=t&rct=j&q=&esrc=s"));
    }

    @Test
    public void testFail() throws Exception {
        Verifier verifier = new URLVerifier();
        Assert.assertFalse(verifier.perform("www163com"));
        Assert.assertFalse(verifier.perform("www@163.com"));
        Assert.assertFalse(verifier.perform("www:163.com"));
        Assert.assertFalse(verifier.perform("ftp://www.163.com"));
        Assert.assertFalse(verifier.perform("ws://163.com"));
        Assert.assertFalse(verifier.perform("xxx://163.com"));
        Assert.assertFalse(verifier.perform("http:163..com"));
        Assert.assertFalse(verifier.perform("http://163..com"));
        Assert.assertFalse(verifier.perform("http:///163.com"));
        Assert.assertFalse(verifier.perform("http//163.com"));
        Assert.assertFalse(verifier.perform("https://.163.com"));
    }
}
