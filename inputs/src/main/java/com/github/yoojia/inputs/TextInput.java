package com.github.yoojia.inputs;

import android.widget.TextView;

/**
 * Input wrapper form TextViews(TextView, EditText, Button ...)
 *
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
public class TextInput<T extends TextView> extends ViewInput<T> {

    public TextInput(T input) {
        super(input);
    }

    @Override
    public String getValue() {
        return String.valueOf(inputView.getText());
    }

}