package com.example.tk.music_mvc.mymusic.controller;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tk.music_mvc.R;
import com.example.tk.music_mvc.mymusic.model.MusicModel;
import com.example.tk.music_mvc.mymusic.util.MusicUtil;

import java.util.List;

/**
 * Created by User on 2017/11/27.
 */

public class MusicFragment extends Fragment implements View.OnClickListener{
    private Button btn_previous;
    private Button btn_play;
    private Button btn_next;
    private List<MusicModel> list;
    private MusicModel musicModel;
    private MediaPlayer myMediaPlayer;
    static int currentListItem;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music_player_layout, null);

        list = MusicUtil.getMusicData(getActivity());

        myMediaPlayer=new MediaPlayer();
        int currentListItem = getArguments().getInt("position");
        playMusic(list.get(currentListItem));

        return view;
    }

    public void playMusic(MusicModel musicModel){

        try {
            myMediaPlayer.reset();
            myMediaPlayer.setDataSource(musicModel.getData());
            myMediaPlayer.prepare();
            myMediaPlayer.start();
            myMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    nextMusic();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void nextMusic(){
        if(++currentListItem >= list.size()){
            currentListItem = 0;
        }
        else{
            playMusic(list.get(currentListItem));
        }
    }

    void previousMusic(){
        if(currentListItem != 0)
        {
            if(--currentListItem >= 0){
                currentListItem = list.size();
            } else{
                playMusic(list.get(currentListItem));
            }
        }  else{
            playMusic(list.get(0));
        }
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.next:
                nextMusic();

            case R.id.previous:
                previousMusic();

            case R.id.play:
                if(myMediaPlayer.isPlaying()){
                    btn_play.setBackgroundResource(R.drawable.pause);
                    myMediaPlayer.pause();
                }else{
                    btn_play.setBackgroundResource(R.drawable.ic_play);
                    myMediaPlayer.start();
                }
        }
    }
}
