package com.example.tk.music_mvc.mymusic.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.tk.music_mvc.R;
import com.example.tk.music_mvc.mymusic.adapter.MusicDetailAdaptor;
import com.example.tk.music_mvc.mymusic.model.MusicModel;
import com.example.tk.music_mvc.mymusic.util.MusicUtil;

import java.util.List;

/**
 * Created by User on 2017/11/29.
 */

public class MusicListFragment extends Fragment {
    private ListView listView;
    private MusicDetailAdaptor adaptor;
    List<MusicModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.music_deatil_fragment,container,false);

        listView = (ListView)view.findViewById(R.id.music_detail_list_layout);


        list = MusicUtil.getMusicData(getActivity());
        adaptor = new MusicDetailAdaptor(list , getActivity());
        listView.setAdapter(adaptor);

        return view;
    }


}
