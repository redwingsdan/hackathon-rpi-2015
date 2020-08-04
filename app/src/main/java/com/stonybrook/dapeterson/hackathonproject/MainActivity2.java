package com.stonybrook.dapeterson.hackathonproject;

/**
 * Created by djp217 on 11/14/2015.
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import android.net.Uri;
import android.content.ContentResolver;
import android.database.Cursor;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity2 extends Activity {

    Button button;
    private ArrayList<Song> songList;
    private ListView songView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_main2);
            songView = (ListView) findViewById(R.id.songList);
            songList = new ArrayList<Song>();
            getSongList();
            Collections.sort(songList, new Comparator<Song>() {
                public int compare(Song a, Song b) {
                    return a.getTitle().compareTo(b.getTitle());
                }
            });
            SongAdapter songAdt = new SongAdapter(this, songList);
            songView.setAdapter(songAdt);
        }
        catch(Exception e)
        {
            long thisId1 = 12345;
            String thisTitle1 = "Sample Title";
            String thisArtist1 = "Test Song";
            songList.add(new Song(thisId1, thisTitle1,thisArtist1));
            thisTitle1 = "Breath";
            thisArtist1 = "Breaking Benjamin";
            songList.add(new Song(thisId1, thisTitle1, thisArtist1));
            thisTitle1 = "Fall for you";
            thisArtist1 = "Secondhand Serenade";
            songList.add(new Song(thisId1, thisTitle1, thisArtist1));
            thisTitle1 = "Fly away home";
            thisArtist1 = "Pink Zebra";
            songList.add(new Song(thisId1, thisTitle1, thisArtist1));
            thisTitle1 = "The Mountain";
            thisArtist1 = "Ryan Lofty";
            songList.add(new Song(thisId1, thisTitle1, thisArtist1));
            thisTitle1 = "America";
            thisArtist1 = "XYLO";
            songList.add(new Song(thisId1, thisTitle1, thisArtist1));
            thisTitle1 = "Letterbomb";
            thisArtist1 = "Green Day";
            songList.add(new Song(thisId1, thisTitle1, thisArtist1));
            thisTitle1 = "Fall Down";
            thisArtist1 = "Spencer Tarring";
            songList.add(new Song(thisId1, thisTitle1, thisArtist1));
            thisTitle1 = "Freaks";
            thisArtist1 = "Timmy Trumpet";
            songList.add(new Song(thisId1, thisTitle1, thisArtist1));

            Collections.sort(songList, new Comparator<Song>() {
                public int compare(Song a, Song b) {
                    return a.getTitle().compareTo(b.getTitle());
                }
            });
            SongAdapter songAdt = new SongAdapter(this, songList);
            songView.setAdapter(songAdt);
        }
        addListenerOnButton();
       // addListenerOnButton2();
    }

    public void addListenerOnButton() {

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

    public void openDialog() {
        final Dialog dialog = new Dialog(this); // context, this etc.
        final AlertDialog.Builder dialog2 = new AlertDialog.Builder(this);
        dialog2.setMessage(R.string.error);
        dialog2.setTitle(R.string.dialog_title);


        dialog.setContentView(R.layout.dialog_demo);
        dialog.setTitle(R.string.dialog_title);
        dialog.show();
    }
/*
    public void addListenerOnButton2() {

        //openDialog();

        View button2;
        button2 = findViewById(R.id.song_title);

        button2.setOnClickListener(new View.OnClickListener() {
*/
            public void onClick1(View v) {

                //Intent intent = new Intent(context, SongPicked.class);
                //startActivity(intent);
                openDialog();

            }
/*
        });

    }
*/
    public void getSongList() {
        long thisId = 54321;
        String thisTitle = "Riot";
        String thisArtist = "Three Days Grace";
        songList.add(new Song(thisId, thisTitle,thisArtist));
        ContentResolver musicResolver = getContentResolver();
        Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);
        if(musicCursor!=null && musicCursor.moveToFirst()){
            //get columns
            int titleColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.TITLE);
            int idColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media._ID);
            int artistColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.ARTIST);
            //add songs to list
            do {
                if(songList.isEmpty())
                {
                    long thisId1 = 54321;
                    String thisTitle1 = "Riot";
                    String thisArtist1 = "Three Days Grace";
                    songList.add(new Song(thisId1, thisTitle1,thisArtist1));
                }
                long thisId1 = musicCursor.getLong(idColumn);
                String thisTitle1 = musicCursor.getString(titleColumn);
                String thisArtist1 = musicCursor.getString(artistColumn);
                songList.add(new Song(thisId1, thisTitle1, thisArtist1));
            }
            while (musicCursor.moveToNext());
        }
    }

}