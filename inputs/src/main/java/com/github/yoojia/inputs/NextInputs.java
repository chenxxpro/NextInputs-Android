package com.github.yoojia.inputs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * NextInputs
 *
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
public class NextInputs {

    private static final Comparator<Scheme> ORDERING = new Comparator<Scheme>() {
        @Override
        public int compare(Scheme lhs, Scheme rhs) {
            return lhs.priority - rhs.priority;
        }
    };

    private final ArrayList<InputSpec> mInputSpecs = new ArrayList<>();

    private MessageDisplay mMessageDisplay = new MessageDisplay() {
        @Override
        public void show(Input input, String message) {
            System.err.println("TEST FAIL: " + message);
        }
    };

    /**
     * 默认情况下，校验测试失败即停止其它校验
     */
    private boolean mStopIfFail = true;

    /**
     * 执行校验测试，并返回测试结果。
     * @return 校验测试结果是否成功
     */
    public boolean test(){
        if(mInputSpecs.isEmpty()){
            throw new IllegalArgumentException("No inputs and schemes to test");
        }
        InputSpec working = null;
        try{
            boolean passed = true;
            for (InputSpec spec : mInputSpecs) {
                working = spec;
                final Result r = perform(spec);
                if(!r.passed) {
                    mMessageDisplay.show(working.input, r.message);
                    passed = false;
                    if(mStopIfFail) {
                        return false;
                    }
                }
            }
            return passed;
        }catch (Throwable thr) {
            mMessageDisplay.show(working.input, thr.getMessage());
            return false;
        }
    }

    /**
     * 添加输入条目及测试模式。
     * @param input 输入条目
     * @param schemes 测试模式
     * @return NextInputs
     */
    public NextInputs add(Input input, Scheme... schemes){
        if (schemes == null || schemes.length == 0){
            throw new IllegalArgumentException("Test schemes is required !");
        }
        Arrays.sort(schemes, ORDERING);
        mInputSpecs.add(new InputSpec(input, schemes));
        return this;
    }

    /**
     * 移除指定Input的校验条目
     * @param input Input对象
     * @return NextInputs
     */
    public NextInputs remove(Input input) {
        final List<InputSpec> toRemove = new ArrayList<>(1);
        for(InputSpec spec: mInputSpecs) {
            if(spec.input == input) {
                toRemove.add(spec);
            }
        }
        mInputSpecs.removeAll(toRemove);
        return this;
    }

    /**
     * 清除所有校验条目
     * @return NextInputs
     */
    public NextInputs clear(){
        mInputSpecs.clear();
        return this;
    }

    /**
     * 在校验测试遇到失败时，是否停止校验
     * @param stopOnFail 是否停止
     * @return NextInputs
     */
    public NextInputs setStopIfFail(boolean stopOnFail){
        mStopIfFail = stopOnFail;
        return this;
    }

    /**
     * 设置校验测试结果消息显示接口
     * @param display 消息显示接口。
     * @throws NullPointerException 当参数为Null时，抛出异常。
     * @return NextInputs
     */
    public NextInputs setMessageDisplay(MessageDisplay display){
        if (display == null) {
            throw new NullPointerException("MessageDisplay is null !");
        }
        mMessageDisplay = display;
        return this;
    }

    /**
     * 流式API
     * @param input Input对象
     * @return 流式API接口
     */
    public Fluent add(Input input) {
        return new Fluent(input, this);
    }

    private static Result perform(InputSpec spec) throws Exception {
        final String value = spec.input.getValue();
        for (Scheme scheme : spec.schemes) {
            if (!scheme.verifier.perform(value)) {
                final String message;
                if(scheme.verifier instanceof SingleVerifier){
                    final SingleVerifier v = (SingleVerifier) scheme.verifier;
                    message = formatTplMessage(scheme.message,
                            v.benchmarkValueForMessage());
                }else if(scheme.verifier instanceof PairedVerifier){
                    final PairedVerifier v = (PairedVerifier) scheme.verifier;
                    message = formatTplMessage(scheme.message,
                            v.benchmark1stValueForMessage(),
                            v.benchmark2ndValueForMessage());
                }else{
                    message = scheme.message;
                }
                return new Result(false, message);
            }
        }
        return new Result(true, "PASSED");
    }

    private static String formatTplMessage(String message, Object...args){
        String output = message;
        for (int i = 0; i < args.length; i++) {
            output = output.replace("{"+i+"}", args[i].toString());
        }
        return output;
    }
}
