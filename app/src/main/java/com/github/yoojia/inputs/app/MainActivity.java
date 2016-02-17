package com.github.yoojia.inputs.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.yoojia.inputs.AndroidNextInputs;
import com.github.yoojia.inputs.FormInput;
import com.github.yoojia.inputs.FormLoader;
import com.github.yoojia.inputs.StaticPattern;
import com.github.yoojia.inputs.ValuePattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AndroidNextInputs inputs = new AndroidNextInputs();
        final FormInput form = new FormInput(this);
        final FormLoader loader = new FormLoader(this);
        // 必选，手机号
        inputs.add(form.findEditText(R.id.form_field_1), StaticPattern.Required(), StaticPattern.ChineseMobile());
        // 信用卡
        inputs.add(form.findEditText(R.id.form_field_2), StaticPattern.BlankCard());
        // 必选，数字，最大20字符
        inputs.add(form.findEditText(R.id.form_field_3), StaticPattern.Required(), StaticPattern.Digits(), ValuePattern.MaxLength(20));
        // 必选，邮件
        inputs.add(form.findEditText(R.id.form_field_4), StaticPattern.Required(), StaticPattern.Email());
        // 必选，与邮件相同
        inputs.add(form.findEditText(R.id.form_field_5), ValuePattern.Required(), ValuePattern.EqualsTo(loader.findEditText(R.id.form_field_4)));
        // Host
        inputs.add(form.findEditText(R.id.form_field_6), StaticPattern.Host());
        // URL
        inputs.add(form.findEditText(R.id.form_field_6), StaticPattern.URL());
        // MaxLength
        inputs.add(form.findEditText(R.id.form_field_7), ValuePattern.MaxLength(5));
        // MinLength
        inputs.add(form.findEditText(R.id.form_field_8), ValuePattern.MinLength(4));
        // RangeLength
        inputs.add(form.findEditText(R.id.form_field_9), ValuePattern.RangeLength(4, 8));
        // Not Blank
        inputs.add(form.findEditText(R.id.form_field_10), StaticPattern.NotBlank());
        // Numeric
        inputs.add(form.findEditText(R.id.form_field_11), StaticPattern.Numeric());
        // MaxValue
        inputs.add(form.findEditText(R.id.form_field_12), ValuePattern.MaxValue(100));
        // MinValue
        inputs.add(form.findEditText(R.id.form_field_13), ValuePattern.MinValue(20));
        // RangeValue
        inputs.add(form.findEditText(R.id.form_field_14), ValuePattern.RangeValue(18, 30));


        final Button submit = (Button) findViewById(R.id.form_commit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean passed = inputs.test();
                if (passed) {
                    submit.setText("校验通过");
                }else{
                    submit.setText("校验失败");
                }
            }
        });
    }
}
