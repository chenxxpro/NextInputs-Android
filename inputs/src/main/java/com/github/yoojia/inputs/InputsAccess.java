package com.github.yoojia.inputs;

import android.app.Activity;
import android.view.View;

/**
 * 使用 WidgetAccess 来替代；
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.0
 */
@Deprecated
public class InputsAccess extends WidgetAccess{

    public InputsAccess(View formView) {
        super(formView);
    }

    public InputsAccess(Activity activity) {
        super(activity);
    }
}
