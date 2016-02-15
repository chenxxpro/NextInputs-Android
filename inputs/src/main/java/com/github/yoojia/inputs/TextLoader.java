package com.github.yoojia.inputs;

import android.widget.EditText;
import android.widget.TextView;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
public class TextLoader implements Loader<String> {

    private final TextView mInput;

    public TextLoader(TextView input) {
        mInput = input;
    }

    @Override
    public String onLoadValue() {
        return mInput.getText().toString();
    }

    public static TextLoader textView(TextView textView){
        return new TextLoader(textView);
    }

    public static TextLoader editText(EditText editText) {
        return textView(editText);
    }
}