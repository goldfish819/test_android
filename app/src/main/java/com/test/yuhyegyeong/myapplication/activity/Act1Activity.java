package com.test.yuhyegyeong.myapplication.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sangcomz.fishbun.FishBun;
import com.sangcomz.fishbun.define.Define;
import com.test.yuhyegyeong.myapplication.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.jar.Manifest;

/**
 * Created by yuhyegyeong on 2016. 5. 25..
 */
public class Act1Activity extends AppCompatActivity{

    private static final int PICK_FILE_REQUEST =1;
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private static final int MY_PERMISSION_REQUEST_READ_EXTERNAL_STORAGE = 2;
    private final int REQUEST_CODE_SELECT = 100;
    EditText act1Title;
    EditText act1Content;
    Button act1BtnCamera;
    ImageView act1Photo;
    private String UPLOAD_URL = "http://text.com";
    private Bitmap bitmap;
    private String KEY_IMAGE = "image";
    private String KEY_NAME = "name";
    private ArrayList<String> mImages;

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
        // act1Photo = (ImageView) findViewById(R.id.act1_photo);

        act1BtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // showFileChooser();
                if (ActivityCompat.checkSelfPermission(Act1Activity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    Log.d("11", "11");
                    ActivityCompat.requestPermissions(Act1Activity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST_READ_EXTERNAL_STORAGE);
                    //TODO temporary null
                } else {
//                    PhotoPickerIntent intent = new PhotoPickerIntent(ReviewActivity.this);
//                    intent.setPhotoCount(1);
//                    intent.setShowCamera(false);
//                    intent.setShowGif(false);
//                    startActivityForResult(intent, IMAGE_PICKER);
                    Log.d("11", "22");
                    FishBun.with(Act1Activity.this).setPickerCount(1).startAlbum();
                }
            }
        });
    }

//    private void showFileChooser() {
//        //갤러리 사용 권한 체크(사용권한이 없을경우)
//        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
//            //권한이 없을 경우
//            //최초 권한 요청인지, 사용자에 의한 재요청인지 확인
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)){
//                //사용자가 임의로 권한을 취소시킨 경우
//                //권한 재요청
//                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
//            }else {
//                //최초로 권한을 요청하는 경우(갤러리 첫실행)
//                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);
//            }
//        }else {
//            //사용 권한이 있을때
//            chooseFile();
//        }
//    }

//    private void chooseFile(){
//        Log.d("choose","Image");
//        FishBun.with(Act1Activity.this).setPickerCount(1).startAlbum();
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        switch (requestCode){
//            case MY_PERMISSION_REQUEST_READ_EXTERNAL_STORAGE: {
//                //갤러리 사용권한에 대한 콜백 받음
//                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                    //권한동의
//                    Log.d("access","disagree");
//                    chooseFile();
//                }else {
//                    //권한동의 안함
//                    Log.d("access", "disagree");
//                    Toast.makeText(Act1Activity.this, "동의필수", Toast.LENGTH_SHORT).show();
//                    finish();
//                }
//                return;
//            }
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /*if(requestCode == IMAGE_PICKER && resultCode == PhotoPickerActivity.RESULT_OK) {
            if(data != null) {
                mImages = data.getStringArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
                for (int i=0; i<mImages.size(); i++) {
                    String path = mImages.get(i);
                    Log.d(TAG, "path: " + path);
                    String thumbPath = Common.getThumnailPath(ReviewActivity.this, path);
//                    Bitmap bitmap = BitmapFactory.decodeFile(thumbPath == null ? path : thumbPath);
//                    mThumb.setImageBitmap(bitmap);
                    Glide.with(this).load(new File(thumbPath)).into(mThumb);
                    mThumbLayout.setVisibility(View.VISIBLE);
                }
            }
        }*/

        switch (requestCode) {
            case Define.ALBUM_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    ArrayList path = data.getStringArrayListExtra(Define.INTENT_PATH);
                    Log.d("path", "" + data.getExtras());

                    if (data != null) {
                        mImages = data.getStringArrayListExtra(Define.INTENT_PATH);
                        for (int i = 0; i < mImages.size(); i++) {
                            String path1 = mImages.get(i);
                            Bitmap bitmap = BitmapFactory.decodeFile(path1);
                            Log.d("11", "path1=" + mImages.get(i) + " /bitmap=" + bitmap);
                            act1Photo = (ImageView) findViewById(R.id.act1_photo);
                            act1Photo.setImageBitmap(bitmap);
                        }
                    }
//
//                  try {
//                        //Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
//                        Bitmap bitmap = BitmapFactory.decodeFile(path);
//                        act1Photo = (ImageView)findViewById(R.id.act1_photo);
//                        act1Photo.setImageBitmap(bitmap);
//                        Log.d("1","33"+bitmap);
//                    }catch (FileNotFoundException e){
//                        e.printStackTrace();
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }


                }
        }
    }
}
