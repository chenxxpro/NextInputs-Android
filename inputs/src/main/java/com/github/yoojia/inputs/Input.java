package com.github.yoojia.inputs;

/**
 * Input是对所有需要被验证的输入数据源的抽象.
 *
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
public interface Input {

    /**
     * 从输入数据源中获取输入文本数据
     * @return String value
     */
    String getValue();
}
