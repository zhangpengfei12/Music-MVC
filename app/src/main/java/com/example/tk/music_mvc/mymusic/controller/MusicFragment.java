package com.example.tk.music_mvc.mymusic.controller;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.tk.music_mvc.R;
import com.example.tk.music_mvc.mymusic.model.MusicModel;
import com.example.tk.music_mvc.mymusic.util.MusicUtil;

import java.util.List;

/**
 * Created by User on 2017/11/27.
 */

public class MusicFragment extends Fragment {
    private ImageView btn_previous;
    private ImageView btn_play;
    private ImageView btn_next;
    private ImageView music_img;
    private List<MusicModel> list;
    private MusicModel musicModel;
    private MediaPlayer myMediaPlayer;
    private Animation animation;
    static int currentListItem;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music_player_layout, container, false);

        list = MusicUtil.getMusicData(getActivity());

        myMediaPlayer=new MediaPlayer();
        currentListItem = getArguments().getInt("position");
        playMusic(list.get(currentListItem));

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        music_img = (ImageView) getActivity().findViewById(R.id.background);
        animation = AnimationUtils.loadAnimation(getActivity(), R.anim.img_animtion);
        LinearInterpolator lin = new LinearInterpolator();//设置动画匀速运动
        animation.setInterpolator(lin);
        music_img.startAnimation(animation);

        btn_play = (ImageView) getActivity().findViewById(R.id.play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myMediaPlayer.isPlaying()){
                    btn_play.setImageResource(R.drawable.ic_play);
                    myMediaPlayer.pause();
                    music_img.clearAnimation();
                }else{
                    btn_play.setImageResource(R.drawable.pause);
                    myMediaPlayer.start();
                    music_img.startAnimation(animation);
                }
            }
        });

        btn_previous = (ImageView) getActivity().findViewById(R.id.previous);
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousMusic();
            }
        });

        btn_next = (ImageView) getActivity().findViewById(R.id.next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextMusic();
            }
        });



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
        playMusic(list.get(currentListItem));
    }

    void previousMusic(){
        if(--currentListItem < 0) {
            currentListItem = 0;
        }
        playMusic(list.get(currentListItem));
    }



}
