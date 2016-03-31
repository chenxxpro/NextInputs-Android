package com.github.yoojia.inputs;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 *
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.0
 */
public class InputsAccess {
    
    private final View mFormView;

    public InputsAccess(View formView) {
        mFormView = formView;
    }

    public InputsAccess(Activity activity) {
        this(activity.getWindow().getDecorView());
    }

    public static String getString(TextView view) {
        final CharSequence value = view.getText();
        if (TextUtils.isEmpty(value)) {
            return null;
        }else{
            return String.valueOf(value);
        }
    }

    public String getString(int viewId) {
        final TextView view = findView(viewId);
        return getString(view);
    }

    public static int getInt(TextView view, int defaultValue) {
        return parseInt(view.getText(), defaultValue);
    }

    public int getInt(int viewId, int defaultValue) {
        final String input = getString(viewId);
        return parseInt(input, defaultValue);
    }

    private static int parseInt(CharSequence input, int defaultValue) {
        if (TextUtils.isEmpty(input)) {
            return defaultValue;
        }else{
            try{
                return Integer.parseInt(input.toString());
            }catch (Exception err) {
                return defaultValue;
            }
        }
    }
    
    public static long getLong(TextView view, long defaultValue) {
        return parseLong(view.getText(), defaultValue);
    }

    public long getLong(int viewId, long defaultValue) {
        final String input = getString(viewId);
        return parseLong(input, defaultValue);
    }

    private static long parseLong(CharSequence input, long defaultValue) {
        if (TextUtils.isEmpty(input)) {
            return defaultValue;
        }else{
            try{
                return Long.parseLong(input.toString());
            }catch (Exception err) {
                return defaultValue;
            }
        }
    }

    public static float getFloat(TextView view, float defaultValue) {
        return parseFloat(view.getText(), defaultValue);
    }

    public float getFloat(int viewId, float defaultValue) {
        final String input = getString(viewId);
        return parseFloat(input, defaultValue);
    }

    private static float parseFloat(CharSequence input, float defaultValue) {
        if (TextUtils.isEmpty(input)) {
            return defaultValue;
        }else{
            try{
                return Float.parseFloat(input.toString());
            }catch (Exception err) {
                return defaultValue;
            }
        }
    }

    public static double getDouble(TextView view, double defaultValue) {
        return parseDouble(view.getText(), defaultValue);
    }

    public double getDouble(int viewId, double defaultValue) {
        final String input = getString(viewId);
        return parseDouble(input, defaultValue);
    }

    private static double parseDouble(CharSequence input, double defaultValue) {
        if (TextUtils.isEmpty(input)) {
            return defaultValue;
        }else{
            try{
                return Double.parseDouble(input.toString());
            }catch (Exception err) {
                return defaultValue;
            }
        }
    }

    public static boolean getBoolean(CompoundButton view) {
        return view.isChecked();
    }

    public boolean getBoolean(int viewId) {
        CompoundButton button = findView(viewId);
        return button.isChecked();
    }

    public static int getProgressInt(ProgressBar view) {
        return view.getProgress();
    }

    public int getProgressInt(int viewId) {
        ProgressBar bar = findView(viewId);
        return bar.getProgress();
    }

    public TextInput<TextView> findTextView(int viewId){
        return AndroidInputs.textView((TextView) mFormView.findViewById(viewId));
    }

    public TextInput<EditText> findEditText(int viewId) {
        return AndroidInputs.editText((EditText) mFormView.findViewById(viewId));
    }

    public Input findRadioButton(int viewId) {
        return AndroidInputs.radioButton((RadioButton) mFormView.findViewById(viewId));
    }

    public Input findCheckBox(int viewId) {
        return AndroidInputs.checkBox((CheckBox) mFormView.findViewById(viewId));
    }

    public Input findToggleButton(int viewId) {
        return AndroidInputs.toggleButton((ToggleButton) mFormView.findViewById(viewId));
    }

    public Input findRatingBar(int viewId) {
        return AndroidInputs.ratingBar((RatingBar) mFormView.findViewById(viewId));
    }

    public Input findCheckable(int viewId) {
        return AndroidInputs.checkable((CompoundButton) mFormView.findViewById(viewId));
    }

    public  <T> T findView(int viewId) {
        return (T) mFormView.findViewById(viewId);
    }
}
