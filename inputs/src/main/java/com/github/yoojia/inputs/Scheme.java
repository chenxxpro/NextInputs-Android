package com.github.yoojia.inputs;

/**
 * 校验模式
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.4
 */
public class Scheme {

    /**
     * 当验证失败时的提示消息
     */
    String message;

    /**
     * 验证顺序优先级.默认为 StaticScheme.PRIORITY_GENERAL
     * @see StaticScheme
     */
    int priority = StaticScheme.PRIORITY_GENERAL;

    /**
     * 具体校验算法实现接口
     */
    final Verifier verifier;

    /**
     * 对输入内容做Trim处理
     */
    boolean trimInput = true;

    public Scheme(Verifier verifier) {
        this.verifier = verifier;
    }

    public Scheme msgOnFail(String message){
        return msg(message);
    }

    public Scheme priority(int priority){
        this.priority = priority;
        return this;
    }

    public Scheme msg(String message){
        this.message = message;
        return this;
    }

    public Scheme trimInput(){
        this.trimInput = true;
        return this;
    }

    public Scheme dontTrimInput(){
        this.trimInput = false;
        return this;
    }
}
