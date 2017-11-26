package com.example.tk.music_mvc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;

import com.example.tk.music_mvc.mymusic.view.MyMusicActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.my_music_layout:
                Intent intent = new Intent(MainActivity.this, MyMusicActivity.class);
                startActivity(intent);
                break;

            case R.id.toolbar:
                Intent intent2 = new Intent(MainActivity.this, MyMusicActivity.class);
                startActivity(intent2);
                break;

        }
    }
}
