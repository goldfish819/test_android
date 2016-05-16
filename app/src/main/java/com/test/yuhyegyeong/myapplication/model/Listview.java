package com.test.yuhyegyeong.myapplication.model;

/**
 * Created by yuhyegyeong on 2016. 5. 13..
 */
public class Listview {
    private int icon;
    private String name;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Listview(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }
}
