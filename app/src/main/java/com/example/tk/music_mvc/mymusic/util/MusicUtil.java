package com.example.tk.music_mvc.mymusic.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;

import com.example.tk.music_mvc.mymusic.model.MusicModel;
import com.example.tk.music_mvc.mymusic.model.MyMusicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2017/11/29.
 */

public class MusicUtil {
    //获取mp3文件
//    public static List<MusicModel> getMusicData(Context context){
//        List<MusicModel> mList = new ArrayList<MusicModel>();
//        ContentResolver contentResolver = context.getContentResolver();
//        Cursor cursor = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
//        while (cursor.moveToNext()){
//            MusicModel musicModel = new MusicModel();
//            String name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
//            String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
//            String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
//            long duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
//
//            if(artist.equals("<unknown>")){
//                artist = "未知艺人";
//            }
//            if(duration > 0){ //   >20000
//                musicModel.setName(name);
//                musicModel.setArtist(artist);
//                musicModel.setPath(path);
//                musicModel.setDuration(duration);
//            }
//        }
//
//        return  mList;
//    }

    /*定义与音乐相关的信息集合*/
    public static final String[] AUDIO_KEYS = new String[]{
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.TITLE_KEY,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.ARTIST_KEY,
            MediaStore.Audio.Media.COMPOSER,
            MediaStore.Audio.Media.ALBUM,
            MediaStore.Audio.Media.ALBUM_KEY,
            MediaStore.Audio.Media.DISPLAY_NAME,
            MediaStore.Audio.Media.MIME_TYPE,
            MediaStore.Audio.Media.DATA,

            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.ARTIST_ID,
            MediaStore.Audio.Media.ALBUM_ID,
            MediaStore.Audio.Media.YEAR,
            MediaStore.Audio.Media.TRACK,
            MediaStore.Audio.Media.DURATION,
            MediaStore.Audio.Media.SIZE,

            MediaStore.Audio.Media.IS_RINGTONE,
            MediaStore.Audio.Media.IS_PODCAST,
            MediaStore.Audio.Media.IS_ALARM,
            MediaStore.Audio.Media.IS_MUSIC,
            MediaStore.Audio.Media.IS_NOTIFICATION,
    };

    public static ArrayList<MusicModel> getMusicData(Context context)
    {
        ArrayList<MusicModel> audioList = new ArrayList<MusicModel>();
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                AUDIO_KEYS, null, null, null);

        for ( cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext() )
        {
            Bundle bundle = new Bundle();

            for ( int i = 0; i < AUDIO_KEYS.length; i++ )
            {
                final String key = AUDIO_KEYS[i];
                final int colIndex = cursor.getColumnIndex(key);
                final int type = cursor.getType(colIndex);

                switch (type)
                {
                    case Cursor.FIELD_TYPE_BLOB:
                        break;

                    case Cursor.FIELD_TYPE_FLOAT:
                        float fValue = cursor.getFloat(colIndex);
                        bundle.putFloat(key, fValue);
                        break;

                    case Cursor.FIELD_TYPE_INTEGER:
                        int iValue = cursor.getInt(colIndex);
                        bundle.putInt(key, iValue);
                        break;

                    case Cursor.FIELD_TYPE_NULL:
                        break;

                    case Cursor.FIELD_TYPE_STRING:
                        String sValue = cursor.getString(colIndex);
                        bundle.putString(key, sValue);
                        break;
                }
            }

            MusicModel audio = new MusicModel(bundle);
            audioList.add(audio);
        }

        cursor.close();
        return audioList;
    }
}
