package com.github.yoojia.inputs;

/**
 * NextInputs
 *
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.3
 */
public class Fluent {

    private final Input mInput;
    private final NextInputs mNextInputs;

    Fluent(Input input, NextInputs nextInputs) {
        this.mInput = input;
        this.mNextInputs = nextInputs;
    }

    public NextInputs with(Scheme... schemes) {
        mNextInputs.add(mInput, schemes);
        return mNextInputs;
    }
}
