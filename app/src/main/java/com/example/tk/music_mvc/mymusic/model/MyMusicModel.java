package com.example.tk.music_mvc.mymusic.model;


import com.example.tk.music_mvc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2017/11/27.
 */

public class MyMusicModel {
    private String name;
    private int image;
    private String details;
    private int toIcon;

    private static List<MyMusicModel> list = new ArrayList<>();

    static {
        MyMusicModel model_localMusic = new MyMusicModel("本地音乐",R.drawable.my_music_list_item1,"8",R.drawable.toicon);
        MyMusicModel model_recentPlay = new MyMusicModel("最近播放",R.drawable.my_music_list_item2,"228",R.drawable.toicon);
        MyMusicModel model_myStation = new MyMusicModel("我的电台",R.drawable.my_music_list_item3,"666",R.drawable.toicon);
        MyMusicModel model_myCollection = new MyMusicModel("我的收藏",R.drawable.my_music_list_item4,"专辑/歌手/MV/专栏",R.drawable.toicon);
        list.add(model_localMusic);
        list.add(model_recentPlay);
        list.add(model_myStation);
        list.add(model_myCollection);
    }

    public MyMusicModel(){

    }
    public MyMusicModel(String name,int image,String details,int toIcon){
        this.name = name;
        this.image = image;
        this.details = details;
        this.toIcon = toIcon;
    }

    public int getToIcon() {
        return toIcon;
    }

    public void setToIcon(int toIcon) {
        this.toIcon = toIcon;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MyMusicModel> getList(){
        return list;
    }


}
