package com.github.yoojia.inputs;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An Android wrapper for NextInputs
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.0
 */
public class AndroidNextInputs extends NextInputs {

    private final Set<ViewInput> inputs = new HashSet<>();

    public AndroidNextInputs() {
        setMessageDisplay(new AndroidMessageDisplay());
    }

    public AndroidNextInputs add(TextView input, Scheme...schemes){
        addViewInput(WidgetProviders.textView(input), schemes);
        return this;
    }

    public AndroidNextInputs add(EditText input, Scheme...schemes){
        addViewInput(WidgetProviders.editText(input), schemes);
        return this;
    }

    public AndroidNextInputs add(RadioButton input, Scheme...schemes){
        addViewInput(WidgetProviders.radioButton(input), schemes);
        return this;
    }

    public AndroidNextInputs add(ToggleButton input, Scheme...schemes){
        addViewInput(WidgetProviders.toggleButton(input), schemes);
        return this;
    }

    public AndroidNextInputs add(CheckBox input, Scheme...schemes){
        addViewInput(WidgetProviders.checkBox(input), schemes);
        return this;
    }

    public AndroidNextInputs add(RatingBar input, Scheme...schemes){
        addViewInput(WidgetProviders.ratingBar(input), schemes);
        return this;
    }

    public AndroidNextInputs add(CompoundButton input, Scheme...schemes){
        addViewInput(WidgetProviders.checkable(input), schemes);
        return this;
    }
    
    public AndroidNextInputs remove(View view) {
        final List<ViewInput> toRemove = new ArrayList<>();
        for(ViewInput vi : inputs) {
            if(vi.inputView == view) {
                toRemove.add(vi);
            }
        }
        for (ViewInput remove: toRemove) {
            inputs.remove(remove);
            super.remove(remove);
        }
        return this;
    }
    
    private void addViewInput(ViewInput input, Scheme...schemes) {
        inputs.add(input);
        super.add(input, schemes);
    }
}
