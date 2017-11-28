package com.example.tk.music_mvc.mymusic.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.tk.music_mvc.R;

/**
 * Created by TK on 2017/11/26.
 */

public class MyMusicActivity extends AppCompatActivity {
    private MyMusicFragment myMusicFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_music);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.my_music_fragment, new MyMusicFragment());
        transaction.commit();
    }


}
