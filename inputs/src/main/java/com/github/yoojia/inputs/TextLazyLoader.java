package com.github.yoojia.inputs;

import android.widget.EditText;
import android.widget.TextView;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
public class TextLazyLoader implements LazyLoader<String> {

    private final TextView mInput;

    public TextLazyLoader(TextView input) {
        mInput = input;
    }

    @Override
    public String getValue() {
        return mInput.getText().toString();
    }

    public static TextLazyLoader textView(TextView textView){
        return new TextLazyLoader(textView);
    }

    public static TextLazyLoader editText(EditText editText) {
        return textView(editText);
    }
}