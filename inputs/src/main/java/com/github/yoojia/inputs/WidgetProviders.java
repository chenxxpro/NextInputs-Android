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
 *
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.4
 */
public class WidgetProviders extends InputProviders {

    public static TextInput<TextView> textView(TextView textView) {
        return new TextInput<>(textView);
    }

    public static TextInput<EditText> editText(EditText editText) {
        return new TextInput<>(editText);
    }

    public static ViewInput<CompoundButton> radioButton(final RadioButton radioButton) {
        return checkable(radioButton);
    }

    public static ViewInput<CompoundButton> checkBox(CheckBox checkBox) {
        return checkable(checkBox);
    }

    public static ViewInput<CompoundButton> toggleButton(ToggleButton toggleButton) {
        return checkable(toggleButton);
    }

    public static ViewInput<RatingBar> ratingBar(final RatingBar ratingBar) {
        return new ViewInput<RatingBar>(ratingBar) {
            @Override
            public String getValue() {
                return String.valueOf(ratingBar.getRating());
            }
        };
    }

    public static ViewInput<CompoundButton> checkable(final CompoundButton checkable) {
        return new ViewInput<CompoundButton>(checkable) {
            @Override
            public String getValue() {
                return String.valueOf(checkable.isChecked());
            }
        };
    }
}
