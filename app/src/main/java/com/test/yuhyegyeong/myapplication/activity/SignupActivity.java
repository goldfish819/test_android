package com.test.yuhyegyeong.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.test.yuhyegyeong.myapplication.R;

/**
 * Created by yuhyegyeong on 2016. 5. 25..
 */
public class SignupActivity extends AppCompatActivity{

    EditText mSignupId;
    EditText mSignupPw;
    EditText mSignupPwCon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);
    }

    private void init(){
        Button btnSignup = (Button) findViewById(R.id.btn_signup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSignup();
            }
        });
    }

    private void doSignup(){
        mSignupId = (EditText) findViewById(R.id.signup_id);
        mSignupPw = (EditText) findViewById(R.id.signup_pw);
        mSignupPwCon = (EditText) findViewById(R.id.signup_pw_confirm);

        if (mSignupId.getText().toString().length() == 0 || mSignupPw.getText().toString().length() == 0
                || mSignupPwCon.getText().toString().length() == 0) {
            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show(); return;
        }

        if (!mSignupPw.getText().toString().equals(mSignupPwCon.getText().toString())) {
            Toast.makeText(this, "different", Toast.LENGTH_SHORT).show(); return;
        }

        // create new user data
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SignupActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
