package com.example.tk.music_mvc.mymusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tk.music_mvc.R;
import com.example.tk.music_mvc.mymusic.model.MusicModel;

import java.util.List;

/**
 * Created by User on 2017/11/29.
 */

public class MusicDetailAdaptor extends BaseAdapter {
    private List<MusicModel> mList;
    private Context mContext;
    private LayoutInflater mInflater;

    public MusicDetailAdaptor(List<MusicModel> list,Context context){
        this.mList = list;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public int getCount(){
        return mList.size();
    }

    @Override
    public Object getItem(int position){
        return mList.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View view, ViewGroup parent){
        ViewHolder holder = null;
        if(view == null){
            holder = new ViewHolder();
            view = mInflater.inflate(R.layout.adapter_music_list,null);

            holder.name = view.findViewById(R.id.name);
            holder.artist = view.findViewById(R.id.artis);
            holder.album = view.findViewById(R.id.album);
            holder.size = view.findViewById(R.id.size);

            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }
        holder.name.setText(mList.get(position).getTitle());
        holder.artist.setText(mList.get(position).getArtist());
        holder.album.setText(mList.get(position).getAlbum());
        holder.size.setText(Double.toString(Math.ceil(((mList.get(position).getSize()/1024.0)/1024.0)*10)/10) + "M");

        return view;
    }

    class ViewHolder{
        TextView name;
        TextView artist;
        TextView album;
        TextView size;
    }

}
