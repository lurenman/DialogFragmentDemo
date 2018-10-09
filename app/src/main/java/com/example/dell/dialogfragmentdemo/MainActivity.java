package com.example.dell.dialogfragmentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dell.dialogfragmentdemo.dialog.EditNameDialogFragment;
import com.example.dell.dialogfragmentdemo.dialog.LoginDialogFragment;

/**
 * https://blog.csdn.net/lmj623565791/article/details/37815413/
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button btn_edit;
    private Button btn_login;
    private Button btn_Merge;
    private Button btn_ViewStub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_edit = (Button) findViewById(R.id.btn_edit);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_Merge = (Button) findViewById(R.id.btn_Merge);
        btn_ViewStub = (Button) findViewById(R.id.btn_ViewStub);

        btn_edit.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        btn_Merge.setOnClickListener(this);
        btn_ViewStub.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_edit:
                EditNameDialogFragment editNameDialogFragment = new EditNameDialogFragment();
                editNameDialogFragment.show(getSupportFragmentManager(), "EditNameDialogFragment");
                break;
            case R.id.btn_login:
                LoginDialogFragment loginDialogFragment = new LoginDialogFragment();
                loginDialogFragment.show(getSupportFragmentManager(), "LoginDialogFragment");
                break;
            case R.id.btn_Merge:
                startActivity(new Intent(this, MergeActivity.class));
                break;
            case R.id.btn_ViewStub:
                startActivity(new Intent(this, ViewStubActivity.class));
                break;
        }
    }
}
