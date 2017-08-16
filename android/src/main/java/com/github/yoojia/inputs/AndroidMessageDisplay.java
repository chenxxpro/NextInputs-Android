package com.github.yoojia.inputs;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Default message display
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
public class AndroidMessageDisplay implements MessageDisplay {

    private final static String TAG = AndroidMessageDisplay.class.getSimpleName();

    @Override
    public void show(Input input, String message) {
        // try attach
        final View inputView;
        if (input instanceof TextInput) {
            inputView = ((TextInput) input).inputView;
        }else{
            Log.e(TAG, "- When use <AndroidMessageDisplay>, <TextInput> is recommend !");
            inputView = null;
        }
        // try show message
        if (inputView == null) {
            Log.w(TAG, "- TestResult.message=" + message);
            return;
        }
        if (TextView.class.isAssignableFrom(inputView.getClass())) {
            final TextView text = (TextView) inputView;
            text.setError(message);
        }else{
            Toast.makeText(inputView.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}