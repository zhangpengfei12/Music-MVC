package com.example.tk.music_mvc.mymusic.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    private List<MusicModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.music_deatil_fragment,container,false);

        listView = (ListView)view.findViewById(R.id.music_detail_list_layout);

        list = MusicUtil.getMusicData(getActivity());
        adaptor = new MusicDetailAdaptor(list , getActivity());
        listView.setAdapter(adaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MusicFragment mf = new MusicFragment();

                Bundle bundle = new Bundle();
                bundle.putInt("position",position);
                mf.setArguments(bundle);

                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.my_music_fragment,mf,null);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }


}
