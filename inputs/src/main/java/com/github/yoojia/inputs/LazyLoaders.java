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
public class LazyLoaders {

    private final View mFormView;

    public LazyLoaders(View formView) {
        mFormView = formView;
    }

    public LazyLoaders(Activity activity) {
        this(activity.getWindow().getDecorView());
    }

    public TextLazyLoader fromTextView(int viewId){
        return new TextLazyLoader((TextView) mFormView.findViewById(viewId));
    }

    public TextLazyLoader fromEditText(int viewId) {
        return new TextLazyLoader((EditText) mFormView.findViewById(viewId));
    }

    public static TextLazyLoader fromEditText(EditText view) {
        return new TextLazyLoader(view);
    }

    public static TextLazyLoader fromTextView(TextView view) {
        return new TextLazyLoader(view);
    }

}
