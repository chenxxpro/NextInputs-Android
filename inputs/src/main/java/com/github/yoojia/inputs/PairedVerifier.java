package com.github.yoojia.inputs;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.7
 */
public abstract class PairedVerifier<T> extends TypedVerifier<T> {

    private final Loader2A<T> mValueLoader;

    public PairedVerifier(Loader2A<T> valueLoader) {
        mValueLoader = valueLoader;
    }

    public PairedVerifier(final T fixedFirstValue, final T fixedSecondValue) {
        this(new Loader2A<T>() {
            @Override public T getFirstValue() {
                return fixedFirstValue;
            }

            @Override public T getSecondValue() {
                return fixedSecondValue;
            }
        });
    }

    final protected T benchmark1stValue(){
        return mValueLoader.getFirstValue();
    }

    final protected T benchmark2ndValue(){
        return mValueLoader.getSecondValue();
    }

    /**
     * 获取基准数值的消息对象数值A
     * @return 消息数值
     */
    public Object benchmark1stValueForMessage(){
        return benchmark1stValue();
    }

    /**
     * 获取基准数值的消息对象数值B
     * @return 消息数值
     */
    public Object benchmark2ndValueForMessage(){
        return benchmark2ndValue();
    }
}
