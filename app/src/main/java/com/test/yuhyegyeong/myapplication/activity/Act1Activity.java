package com.test.yuhyegyeong.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.test.yuhyegyeong.myapplication.R;

/**
 * Created by yuhyegyeong on 2016. 5. 25..
 */
public class Act1Activity extends AppCompatActivity{

    private static final int PICK_FILE_REQUEST =1;
    EditText act1Title;
    EditText act1Content;
    Button act1BtnCamera;
    ImageView act1Photo;
    private String selectedFilePath;

    // using Volley?

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_act1);
    }

    private void init(){
        act1BtnCamera = (Button) findViewById(R.id.act1_btn_camera);
        act1BtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // showFileChooser();
                Intent intent = new Intent();
                intent.setType("file/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Choose File to Upload"), PICK_FILE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PICK_FILE_REQUEST) {
                if (data == null) {
                    //no data present
                    return;
                }

                Uri selectedFileUri = data.getData();
            }
        }
    }
}
