package com.test.yuhyegyeong.myapplication.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.test.yuhyegyeong.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);     // 화면고정
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        Button gotoact1 = (Button) findViewById(R.id.btn_act1);
        Button gotoact2 = (Button) findViewById(R.id.btn_act2);
        Button gotoact3 = (Button) findViewById(R.id.btn_act3);
        Button gotologin = (Button) findViewById(R.id.btn_gotologin);

        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        });

        gotoact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAct1();
            }
        });

        gotoact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAct2();
            }
        });

        gotoact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAct3();
            }
        });
    }

    private void goToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    // photo upload
    private void goToAct1() {
        Intent intent = new Intent(MainActivity.this, Act1Activity.class);
        startActivity(intent);
    }

    //list view
    private void goToAct2() {
//        Intent intent = new Intent(MainActivity.this, Act2Activity.class);
//        startActivity(intent);
    }

    private void goToAct3() {
//        Intent intent = new Intent(MainActivity.this, Act3Activity.class);
//        startActivity(intent);
    }

    // Toast 많이 쓰면 common.sendToast 만들어도 괜찮을듯
}
