package com.github.yoojia.inputs;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Inputs tool for Android widgets
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.0
 */
public class AndroidInputs extends Inputs{

    public static TextInput<TextView> textView(TextView textView){
        return new TextInput<>(textView);
    }

    public static TextInput<EditText> editText(EditText editText) {
        return new TextInput<>(editText);
    }

    public static Input radioButton(final RadioButton radioButton) {
        return checkable(radioButton);
    }

    public static Input checkBox(CheckBox checkBox) {
        return checkable(checkBox);
    }

    public static Input toggleButton(ToggleButton toggleButton) {
        return checkable(toggleButton);
    }

    public static Input ratingBar(final RatingBar ratingBar) {
        return new Input() {
            @Override public String getValue() {
                return String.valueOf(ratingBar.getRating());
            }
        };
    }

    public static Input checkable(final CompoundButton checkable) {
        return new Input() {
            @Override public String getValue() {
                return String.valueOf(checkable.isChecked());
            }
        };
    }
}
