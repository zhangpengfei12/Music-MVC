package com.example.tk.music_mvc.mymusic.model;

import java.io.Serializable;

/**
 * Created by User on 2017/11/27.
 */

public class MusicModel implements Serializable{



    private static final long serialVersionUID = 1L;
    private String name;
    private String artist;
    private long duration;
    private int image;
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


}
