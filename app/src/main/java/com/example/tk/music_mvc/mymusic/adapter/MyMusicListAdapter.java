package com.example.tk.music_mvc.mymusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tk.music_mvc.R;
import com.example.tk.music_mvc.mymusic.model.MyMusicModel;

import java.util.List;
import java.util.Map;

/**
 * Created by User on 2017/11/27.
 */

public class MyMusicListAdapter extends BaseAdapter {
    private List<MyMusicModel> list;
    private LayoutInflater mInflater;

    public MyMusicListAdapter(Context context,List<MyMusicModel> list){
        this.list = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.adapter_my_music_list, null);
        }
        final ViewHolder holder = getViewHolder(convertView);
        MyMusicModel model = list.get(position);
        holder.tv_name.setText(model.getName());
        holder.iv_image.setBackgroundResource(model.getImage());
        holder.tv_details.setText(model.getDetails());
        holder.iv_icon.setBackgroundResource(model.getToIcon());
        return convertView;
    }

    private ViewHolder getViewHolder(View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        return holder;
    }

    private class ViewHolder {

        private TextView tv_name;
        private ImageView iv_image;
        private TextView tv_details;
        private ImageView iv_icon;

        ViewHolder(View view) {
            tv_name = (TextView) view.findViewById(R.id.name);
            iv_icon = (ImageView) view.findViewById(R.id.toIcon);
            tv_details = (TextView) view.findViewById(R.id.details);
            iv_image = (ImageView) view.findViewById(R.id.image);
        }
    }
}
