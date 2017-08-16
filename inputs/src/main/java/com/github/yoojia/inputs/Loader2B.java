package com.github.yoojia.inputs;

/**
 * 数据懒加载器
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.8
 */
public interface Loader2B<T>{

    T getFirstValue();

    T getSecondValue();

}
