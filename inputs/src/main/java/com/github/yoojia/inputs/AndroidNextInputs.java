package com.github.yoojia.inputs;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.HashSet;
import java.util.Set;

import static com.github.yoojia.inputs.WidgetProviders.checkBox;
import static com.github.yoojia.inputs.WidgetProviders.checkable;
import static com.github.yoojia.inputs.WidgetProviders.editText;
import static com.github.yoojia.inputs.WidgetProviders.radioButton;
import static com.github.yoojia.inputs.WidgetProviders.ratingBar;
import static com.github.yoojia.inputs.WidgetProviders.textView;
import static com.github.yoojia.inputs.WidgetProviders.toggleButton;

/**
 * An Android wrapper for NextInputs
 *
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.0
 */
public class AndroidNextInputs extends NextInputs {

    private final Set<ViewInput> mViewInputSet = new HashSet<>();

    public AndroidNextInputs() {
        setMessageDisplay(new AndroidMessageDisplay());
    }

    public AndroidNextInputs add(TextView input, Scheme... schemes) {
        addViewInput(textView(input), schemes);
        return this;
    }

    public AndroidNextInputs add(EditText input, Scheme... schemes) {
        addViewInput(editText(input), schemes);
        return this;
    }

    public AndroidNextInputs add(RadioButton input, Scheme... schemes) {
        addViewInput(radioButton(input), schemes);
        return this;
    }

    public AndroidNextInputs add(ToggleButton input, Scheme... schemes) {
        addViewInput(toggleButton(input), schemes);
        return this;
    }

    public AndroidNextInputs add(CheckBox input, Scheme... schemes) {
        addViewInput(checkBox(input), schemes);
        return this;
    }

    public AndroidNextInputs add(RatingBar input, Scheme... schemes) {
        addViewInput(ratingBar(input), schemes);
        return this;
    }

    public AndroidNextInputs add(CompoundButton input, Scheme... schemes) {
        addViewInput(checkable(input), schemes);
        return this;
    }

    public AndroidNextInputs remove(View view) {
        final Set<ViewInput> willRemove = new HashSet<>(1);
        for (ViewInput vi : mViewInputSet) {
            if (vi.inputView == view) {
                willRemove.add(vi);
            }
        }
        for (ViewInput input : willRemove) {
            mViewInputSet.remove(input);
            super.remove(input);
        }
        return this;
    }

    @Override
    public NextInputs add(Input input, Scheme... schemes) {
        addViewInputToCache(input);
        return super.add(input, schemes);
    }

    @Override
    public Fluent add(Input input) {
        addViewInputToCache(input);
        return super.add(input);
    }

    @Override
    public boolean test() {
        // Android端在测试前先重置所有出错信息
        resetAllErrors();
        return super.test();
    }

    @Override
    public AndroidNextInputs remove(Input input) {
        final Set<ViewInput> willRemove = new HashSet<>(1);
        for (ViewInput vi : mViewInputSet) {
            if (vi == input) {
                willRemove.add(vi);
            }
        }
        mViewInputSet.removeAll(willRemove);
        return (AndroidNextInputs) super.remove(input);
    }

    @Override
    public AndroidNextInputs clear() {
        resetAllErrors();
        mViewInputSet.clear();
        return (AndroidNextInputs) super.clear();
    }

    @Override
    public AndroidNextInputs setStopIfFail(boolean stopOnFail) {
        return (AndroidNextInputs) super.setStopIfFail(stopOnFail);
    }

    @Override
    public AndroidNextInputs setMessageDisplay(MessageDisplay display) {
        return (AndroidNextInputs) super.setMessageDisplay(display);
    }

    /**
     * 重置所有出错提示
     */
    public void resetAllErrors(){
        for (ViewInput v : mViewInputSet){
            AndroidMessageDisplay.setErrorMessageOnTextView(v.inputView, null);
        }
    }

    private void addViewInput(ViewInput input, Scheme... schemes) {
        addViewInputToCache(input);
        super.add(input, schemes);
    }

    private void addViewInputToCache(Input input){
        if (input instanceof ViewInput){
            mViewInputSet.add((ViewInput) input);
        }
    }
}
