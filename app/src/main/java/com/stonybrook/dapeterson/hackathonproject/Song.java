package com.stonybrook.dapeterson.hackathonproject;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by djp217 on 11/14/2015.
 */
public class Song {
    private long id;
    private String title;
    private String artist;

    public Song(long songID, String songTitle, String songArtist)
    {
        id=songID;
        title=songTitle;
        artist=songArtist;
    }

    public long getID()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }
    public String getArtist()
    {
        return artist;
    }



}
