package com.example.tk.music_mvc.mymusic.controller;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tk.music_mvc.R;
import com.example.tk.music_mvc.mymusic.adapter.MyMusicListAdapter;
import com.example.tk.music_mvc.mymusic.model.MyMusicModel;

/**
 * Created by TK on 2017/11/26.
 */

public class MyMusicFragment extends Fragment {
    private MyMusicListAdapter adapter;
    private MyMusicModel myMusicModel;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.my_music_fragment,container,false);

        myMusicModel = new MyMusicModel();
        adapter = new MyMusicListAdapter(getActivity(),myMusicModel.getList());
        listView = (ListView)view.findViewById(R.id.my_music_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.my_music_fragment, new MusicListFragment(), null)
                                .addToBackStack(null)
                                .commit();
                }
            }
        });

        return view;
    }

}
