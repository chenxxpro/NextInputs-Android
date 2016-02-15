package com.github.yoojia.inputs;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 *
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.0
 */
public class FormLoader {

    private final View mFormView;

    public FormLoader(View formView) {
        mFormView = formView;
    }

    public FormLoader(Activity activity) {
        this(activity.getWindow().getDecorView());
    }

    public TextLoader findTextView(int viewId){
        return new TextLoader((TextView) mFormView.findViewById(viewId));
    }

    public TextLoader findEditText(int viewId) {
        return new TextLoader((EditText) mFormView.findViewById(viewId));
    }

}
