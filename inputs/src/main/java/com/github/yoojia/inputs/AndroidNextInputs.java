package com.github.yoojia.inputs;

/**
 * An Android wrapper for NextInputs
 * @author 陈永佳 (chengyongjia@parkingwang.com)
 * @since 1.0
 */
public class AndroidNextInputs extends NextInputs{

    public AndroidNextInputs() {
        setMessageDisplay(new AndroidMessageDisplay());
    }
}
