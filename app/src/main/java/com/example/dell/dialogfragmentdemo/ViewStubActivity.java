package com.example.dell.dialogfragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 创建日期：2018/10/9
 * 作者:baiyang
 * 参考https://blog.csdn.net/xyz_lmn/article/details/14524567
 * https://blog.csdn.net/hitlion2008/article/details/6737537
 * 缺点
 * ViewStub所要替代的layout文件中不能有<merge>标签
 * ViewStub在加载完后会被移除，或者说是被加载进来的layout替换掉了
 * android:inflatedId 这个说的是代替layout root 的id
 */
public class ViewStubActivity extends AppCompatActivity {
    private static final String TAG = "ViewStubActivity";
    private Button btn_click;
    private ViewStub vs_1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstub);
        btn_click = (Button) findViewById(R.id.btn_click);
        vs_1 = (ViewStub) findViewById(R.id.vs_1);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置visible也相当于inflate 把布局加载进来但是只能加载一次
                //vs_1.setVisibility(View.VISIBLE);
                try {
                    View inflate = vs_1.inflate();
                    TextView textView = (TextView) inflate.findViewById(R.id.tv_view_stub);
                    textView.setText("海贼王");
                } catch (Exception e) {
                    if (e instanceof IllegalStateException) {
                        Toast.makeText(ViewStubActivity.this, "ViewStub只能Inflate一次，之后会被置空", Toast.LENGTH_SHORT).show();
                    }
                    Log.e(TAG, "onClick: " + e.getMessage().toString());
                }

            }
        });
    }
}
