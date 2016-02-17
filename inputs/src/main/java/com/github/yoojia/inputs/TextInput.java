package com.github.yoojia.inputs;

import android.widget.TextView;

/**
 * Input wrapper form TextViews(TextView, EditText, Button ...)
 *
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
public class TextInput<T extends TextView> implements Input{

    public final T inputView;

    public TextInput(T input) {
        inputView = input;
    }

    @Override
    public String getValue() {
        return String.valueOf(inputView.getText());
    }

}