package com.github.yoojia.inputs;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.8
 */
public abstract class SingleVerifier<T> extends TypedVerifier<T> {

    private final Loader1A<T> mValueLoader;

    public SingleVerifier(Loader1A<T> valueLoader) {
        mValueLoader = valueLoader;
    }

    public SingleVerifier(final T fixedValue) {
        mValueLoader = new Loader1A<T>() {
            @Override
            public T getValue() {
                return fixedValue;
            }
        };
    }

    final protected T getBenchmarkValue(){
        return mValueLoader.getValue();
    }

    /**
     * 获取基准数值的消息对象数值
     * @return 消息数值
     */
    public Object benchmarkValueForMessage(){
        return getBenchmarkValue();
    }
}
