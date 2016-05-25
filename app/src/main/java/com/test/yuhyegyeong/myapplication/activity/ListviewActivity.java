package com.test.yuhyegyeong.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.test.yuhyegyeong.myapplication.R;
import com.test.yuhyegyeong.myapplication.adapter.ListviewAdapter;
import com.test.yuhyegyeong.myapplication.model.Listview;

import java.util.ArrayList;

/**
 * Created by yuhyegyeong on 2016. 5. 13..
 */
public class ListviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview1);

        ListView listview = (ListView) findViewById(R.id.listview1);     //import android.widget.ListView;

        ArrayList<Listview> data = new ArrayList<>();
        Listview black = new Listview(R.drawable.dog_black, "black");
        Listview white = new Listview(R.drawable.dog_white, "white");

        data.add(black);
        data.add(white);

        ListviewAdapter adapter = new ListviewAdapter(this, R.layout.listviewitem1, data);
        listview.setAdapter(adapter);
    }
}
