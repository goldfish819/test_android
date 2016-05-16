package com.test.yuhyegyeong.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.yuhyegyeong.myapplication.R;
import com.test.yuhyegyeong.myapplication.model.Listview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhyegyeong on 2016. 5. 16..
 */
public class ListviewAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<Listview> data;
    private int layout;

    public ListviewAdapter(Context context, int layout, ArrayList<Listview> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        Listview listview = data.get(position);

        ImageView icon = (ImageView) convertView.findViewById(R.id.imageviewitem1);
        icon.setImageResource(listview.getIcon());

        TextView name = (TextView) convertView.findViewById(R.id.textviewitem1);
        name.setText(listview.getName());

        return convertView;
    }
}
