package com.stonybrook.dapeterson.hackathonproject;

/**
 * Created by djp217 on 11/14/2015.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity3 extends Activity {

    Button button;

    private ArrayList<Playlist> playlistList;
    private ListView playlistView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_main3);
            playlistView = (ListView) findViewById(R.id.playlistList);
            playlistList = new ArrayList<Playlist>();
            getPlaylistList();
            Collections.sort(playlistList, new Comparator<Playlist>() {
                public int compare(Playlist a, Playlist b) {
                    return a.getName().compareTo(b.getName());
                }
            });
            PlaylistAdapter playlistAdt = new PlaylistAdapter(this, playlistList);
            playlistView.setAdapter(playlistAdt);
        }
        catch(Exception e)
        {
           /*
           String thisTitle1 = "Workout Playlist";
            playlistList.add(new Playlist(thisTitle1));
            thisTitle1 = "Progressive Playlist";
            playlistList.add(new Playlist(thisTitle1));
            thisTitle1 = "Trap Playlist";
            playlistList.add(new Playlist(thisTitle1));

            Collections.sort(songList, new Comparator<Song>() {
                public int compare(Song a, Song b) {
                    return a.getTitle().compareTo(b.getTitle());
                }
            });
            SongAdapter songAdt = new SongAdapter(this, songList);
            songView.setAdapter(songAdt);
            */
        }
        addListenerOnButton3();
    }

    public void addListenerOnButton3() {

        final Context context = this;

        button = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity1.class);
                startActivity(intent);

            }

        });

    }

    public void getPlaylistList() {

        String thisTitle1 = "Workout Playlist";
        playlistList.add(new Playlist(thisTitle1));
        thisTitle1 = "Progressive Playlist";
        playlistList.add(new Playlist(thisTitle1));
        thisTitle1 = "Trap Playlist";
        playlistList.add(new Playlist(thisTitle1));

    }

    public void openDialog() {
        Playlist p = new Playlist("Example Playlist");
        playlistList.add(new Playlist(p.getName()));
        Song s = new Song(1234, "Welccome to the Black Parade", "My Chemical Romance");
        p.setSongList(s);
        SongAdapter songAdt = new SongAdapter(this, playlistList.get(0).getSongList());
        playlistView.setAdapter(songAdt);
    }

    public void playlistPicked(View v) {
        openDialog();
    }

}