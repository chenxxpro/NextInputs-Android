package com.github.yoojia.inputs;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.8
 */
final class Result {
    public final boolean passed;
    public final String message;

    public Result(boolean passed, String message) {
        this.passed = passed;
        this.message = message;
    }
}