package com.github.yoojia.inputs;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.2
 */
public class Fluent {

    private final AndroidNextInputs mNextInputs;
    private final Input mInput;

    Fluent(AndroidNextInputs nextInputs,Input input) {
        mNextInputs = nextInputs;
        mInput = input;
    }

    public AndroidNextInputs with(Pattern... patterns) {
        mNextInputs.add(mInput, patterns);
        return mNextInputs;
    }
}
