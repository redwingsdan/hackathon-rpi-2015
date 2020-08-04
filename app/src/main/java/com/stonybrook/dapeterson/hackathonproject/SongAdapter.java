package com.stonybrook.dapeterson.hackathonproject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * Created by djp217 on 11/14/2015.
 */
public class SongAdapter extends BaseAdapter{
    private ArrayList<Song> songs;
    private LayoutInflater songInf;

    public SongAdapter(){
        songs = null;
        songInf = null;
    }

    public SongAdapter(Context c, ArrayList<Song> theSongs){
        songs = theSongs;
        songInf = LayoutInflater.from(c);
    }

    @Override
    public int getCount()
    {
        return songs.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LinearLayout songLay = (LinearLayout) songInf.inflate(R.layout.song, parent, false);
        TextView songView = (TextView) songLay.findViewById(R.id.song_title);
        TextView artistView = (TextView) songLay.findViewById(R.id.song_artist);
        Song currSong = songs.get(position);
        songView.setText(currSong.getTitle());
        artistView.setText(currSong.getArtist());
        songLay.setTag(position);
        return songLay;
    }

    @Override public Song getItem(int x)
    {
        return null;
    }

    @Override public long getItemId(int x)
    {
        return 0;
    }
}