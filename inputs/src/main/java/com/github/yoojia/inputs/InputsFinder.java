package com.github.yoojia.inputs;

import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 *
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.0
 */
public class InputsFinder {
    
    private final View mFormView;

    public InputsFinder(View formView) {
        mFormView = formView;
    }

    public InputsFinder(Activity activity) {
        this(activity.getWindow().getDecorView());
    }

    public TextInput<TextView> textView(int viewId){
        return Inputs.textView((TextView) mFormView.findViewById(viewId));
    }

    public TextInput<EditText> editText(int viewId) {
        return Inputs.editText((EditText) mFormView.findViewById(viewId));
    }

    public Input radioButton(int viewId) {
        return Inputs.radioButton((RadioButton) mFormView.findViewById(viewId));
    }

    public Input checkBox(int viewId) {
        return Inputs.checkBox((CheckBox) mFormView.findViewById(viewId));
    }

    public Input toggleButton(int viewId) {
        return Inputs.toggleButton((ToggleButton) mFormView.findViewById(viewId));
    }

    public Input ratingBar(int viewId) {
        return Inputs.ratingBar((RatingBar) mFormView.findViewById(viewId));
    }

    public Input checkable(int viewId) {
        return Inputs.checkable((CompoundButton) mFormView.findViewById(viewId));
    }
}
