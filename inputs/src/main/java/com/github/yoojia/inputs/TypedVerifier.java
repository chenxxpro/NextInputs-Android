package com.github.yoojia.inputs;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.8
 */
public abstract class TypedVerifier<T> extends EmptyableVerifier {

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        return performTyped(typedCast(notEmptyInput));
    }

    protected abstract T typedCast(String notEmptyInput);

    protected abstract boolean performTyped(T typedInput);
}
