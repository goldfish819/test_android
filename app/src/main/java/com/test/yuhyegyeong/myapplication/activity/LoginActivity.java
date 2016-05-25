package com.test.yuhyegyeong.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.test.yuhyegyeong.myapplication.R;

/**
 * Created by yuhyegyeong on 2016. 5. 25..
 */
public class LoginActivity extends AppCompatActivity{

    EditText mId;
    EditText mPw;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        init();
    }

    private void init(){
        Button dologin = (Button) findViewById(R.id.btn_login);
        dologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });

        TextView gotosignup = (TextView) findViewById(R.id.btn_gotosignup);
        gotosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
    private void doLogin(){
        mId = (EditText) findViewById(R.id.input_id);
        mPw = (EditText) findViewById(R.id.input_pw);

        if (mId.getText().toString().length() == 0){
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show(); return;
        }else {
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
