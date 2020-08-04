package com.stonybrook.dapeterson.hackathonproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by djp217 on 11/15/2015.
 */
public class SongPicked extends Activity {
    Button button;
    Boolean answer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        answer = openDialog();
        if(answer == false)
        {
           Playlist p = new Playlist("Example Playlist");
            Song s = new Song(1234, "Welccome to the Black Parade", "My Chemical Romance");
           p.setSongList(s);
        }
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;

        button = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity2.class);
                startActivity(intent);

            }

        });

    }

    public boolean openDialog() {
        final boolean[] answer = new boolean[1];
        answer[0] = true;
        Button button3 = (Button) findViewById(R.id.dialog_ok);
        Button button2 = (Button) findViewById(R.id.dialog_cancel);
        final Dialog dialog = new Dialog(this); // context, this etc.
        dialog.setContentView(R.layout.dialog_demo);
        dialog.setTitle(R.string.dialog_title);
        dialog.show();
        //return answer[0];
     /*   button3.setOnClickListener(new View.OnClickListener() {
        //    @Override
            public void OnClick2(View v) {
                answer[0] = true;
                dialog.dismiss();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
      //      @Override
            public void OnClick3(View v) {
                answer[0] = false;
                dialog.dismiss();
            }
        });
        //dialog.show();*/
        return answer[0];
    }

}
