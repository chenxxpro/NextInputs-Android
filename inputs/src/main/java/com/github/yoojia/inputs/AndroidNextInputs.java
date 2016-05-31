package com.github.yoojia.inputs;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * An Android wrapper for NextInputs
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.0
 */
public class AndroidNextInputs extends NextInputs {

    public AndroidNextInputs() {
        setMessageDisplay(new AndroidMessageDisplay());
    }

    public AndroidNextInputs add(TextView input, Scheme...schemes){
        super.add(AndroidInputs.textView(input), schemes);
        return this;
    }

    public AndroidNextInputs add(EditText input, Scheme...schemes){
        super.add(AndroidInputs.editText(input), schemes);
        return this;
    }

    public AndroidNextInputs add(RadioButton input, Scheme...schemes){
        super.add(AndroidInputs.radioButton(input), schemes);
        return this;
    }

    public AndroidNextInputs add(ToggleButton input, Scheme...schemes){
        super.add(AndroidInputs.toggleButton(input), schemes);
        return this;
    }

    public AndroidNextInputs add(CheckBox input, Scheme...schemes){
        super.add(AndroidInputs.checkBox(input), schemes);
        return this;
    }

    public AndroidNextInputs add(RatingBar input, Scheme...schemes){
        super.add(AndroidInputs.ratingBar(input), schemes);
        return this;
    }

    public AndroidNextInputs add(CompoundButton input, Scheme...schemes){
        super.add(AndroidInputs.checkable(input), schemes);
        return this;
    }
}
