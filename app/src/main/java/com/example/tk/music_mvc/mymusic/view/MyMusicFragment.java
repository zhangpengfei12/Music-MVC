package com.example.tk.music_mvc.mymusic.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tk.music_mvc.R;

/**
 * Created by TK on 2017/11/26.
 */

public class MyMusicFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.my_music_fragment, container, false);
    }
}
