package com.github.yoojia.inputs;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.0
 */
public class UsageTest {

    @Test
    public void test(){
        NextInputs inputs = new NextInputs();
        inputs.add(InputProviders.fixedString("yoojia"))
                .with(StaticScheme.Required())

                .add(InputProviders.fixedString("yoojia.chen@gmail.com"))
                .with(StaticScheme.Email())

                .add(InputProviders.fixedString("13800138000"))
                .with(StaticScheme.ChineseMobile())

                .add(InputProviders.fixedString("4121551474702170"))
                .with(StaticScheme.BankCard())

                .add(InputProviders.fixedString("2016-09-30"))
                .with(ValueScheme.DateAfter("2016-09-21"));
        Assert.assertTrue(inputs.test());
    }
}
