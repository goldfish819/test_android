package com.test.yuhyegyeong.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.test.yuhyegyeong.myapplication.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by yuhyegyeong on 2016. 5. 25..
 */
public class Act1Activity extends AppCompatActivity{

    private static final int PICK_FILE_REQUEST =1;

    EditText act1Title;
    EditText act1Content;
    Button act1BtnCamera;
    ImageView act1Photo;

    private Bitmap bitmap;
    private String KEY_IMAGE = "image";
    private String KEY_NAME = "name";

    // private String selectedFilePath;

    // using Volley?

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_act1);

        init();
    }

    private void init(){
        act1Title = (EditText) findViewById(R.id.act1_title);
        act1Content = (EditText) findViewById(R.id.act1_content);
        act1BtnCamera = (Button) findViewById(R.id.act1_btn_camera);
        act1Photo = (ImageView) findViewById(R.id.act1_photo);

        act1BtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_FILE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FILE_REQUEST && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {
                //Getting the Bitmap from Gallery
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //Setting the Bitmap to ImageView
                act1Photo.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Converting Bitmap to Base64 string
    public String getStringImage(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }
}
