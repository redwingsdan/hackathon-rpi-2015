package com.stonybrook.dapeterson.hackathonproject;

/**
 * Created by djp217 on 11/14/2015.
 */
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
public class PlaylistAdapter extends BaseAdapter{
    private ArrayList<Playlist> playlists;
    private LayoutInflater playlistInf;

    public PlaylistAdapter(){
        playlists = null;
        playlistInf = null;
    }

    public PlaylistAdapter(Context c, ArrayList<Playlist> theSongs){
        playlists = theSongs;
        playlistInf = LayoutInflater.from(c);
    }

    @Override
    public int getCount()
    {
        return playlists.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LinearLayout songLay = (LinearLayout) playlistInf.inflate(R.layout.playlist, parent, false);
        TextView playlistView = (TextView) songLay.findViewById(R.id.playlistList);
        Playlist currSong = playlists.get(position);
        playlistView.setText(currSong.getName());
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