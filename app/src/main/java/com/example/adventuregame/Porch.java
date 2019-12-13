package com.example.adventuregame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Porch extends AppCompatActivity {

    private TextView textView;
    private TextView buttonText1;
    private TextView buttonText2;
    private TextView buttonText3;
    boolean gotKey = GraveYard.gotKey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porch);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final MediaPlayer graveyard = MediaPlayer.create(this, R.raw.graveyard);

        //get textviews
        textView = findViewById(R.id.textView3);
        buttonText1 = findViewById(R.id.button_1);
        buttonText2 = findViewById(R.id.button_2);
        buttonText3 = findViewById(R.id.button_3);

        //get buttons
        final Button button1 = findViewById(R.id.button_1);
        final Button button2 = findViewById(R.id.button_2);
        final Button button3 = findViewById(R.id.button_3);

        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);

        graveyard.start();

        if(gotKey) {
            textView.setText(R.string.open_door);

            buttonText1.setText(R.string.cont);
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) { //after you hit continue..
                    startActivity(new Intent(Porch.this, Foyer.class));
                }
            });
        }
        else{
            textView.setText(R.string.open_door_fail);
            buttonText1.setText(R.string.look_for_key);
            buttonText1.setText(R.string.cont);
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) { //after you hit continue..
                    startActivity(new Intent(Porch.this, GraveYard.class));
                }
            });
        }

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
