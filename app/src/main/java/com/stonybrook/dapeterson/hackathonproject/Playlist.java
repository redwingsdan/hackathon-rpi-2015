package com.stonybrook.dapeterson.hackathonproject;

import java.util.ArrayList;

/**
 * Created by djp217 on 11/14/2015.
 */
public class Playlist {

    private String name;
    private ArrayList<Song> songList;

    public Playlist(String name)
    {
        this.name = name;
    }

    public String getName(){return name;}

    public void setSongList(Song s)
    {songList.add(new Song(s.getID(),s.getTitle(), s.getArtist()));}

    public ArrayList<Song> getSongList()
    {
        return songList;
    }

}
