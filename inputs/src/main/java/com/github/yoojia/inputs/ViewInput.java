package com.github.yoojia.inputs;

import android.view.View;

/**
 * Input wrapper form TextViews(TextView, EditText, Button ...)
 *
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.3.2
 */
public abstract class ViewInput<T extends View> implements Input{

    public final T inputView;

    public ViewInput(T input) {
        inputView = input;
    }

}