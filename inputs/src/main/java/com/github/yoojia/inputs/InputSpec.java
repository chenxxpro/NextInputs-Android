package com.github.yoojia.inputs;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.8
 */
final class InputSpec {

    public final Input input;
    public final Scheme[] schemes;

    public InputSpec(Input input, Scheme[] schemes) {
        this.input = input;
        this.schemes = schemes;
    }

}
