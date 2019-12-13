//this is the intro page that includes losing the game
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

public class Gate extends AppCompatActivity {

    private TextView textView;
    private TextView buttonText1;
    private TextView buttonText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gate);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final MediaPlayer into = MediaPlayer.create(this, R.raw.into);

        //get textviews
        textView = findViewById(R.id.textView3);
        buttonText1 = findViewById(R.id.button_1);
        buttonText2 = findViewById(R.id.button_2);

        //get buttons
        final Button button1 = findViewById(R.id.button_1);
        final Button button2 = findViewById(R.id.button_2);
        final Button button3 = findViewById(R.id.button_3);

        into.start();


        //set text to starting point
        textView.setText(R.string.intro);
        buttonText1.setText(R.string.yes);
        buttonText2.setText(R.string.no);

        into.start();

        //hide 3rd button
        button3.setVisibility(View.GONE);

        //button 1 says yes
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(R.string.court_yard);
                buttonText1.setText(R.string.cy_opt1); //gy
                buttonText2.setText(R.string.cy_opt2); //house

                button1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Gate.this, GraveYard.class));
                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Gate.this, Porch.class));
                    }
                });
            }
        });
//        button 2 says no
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(R.string.loose);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                buttonText1.setText(R.string.try_again);
                button1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Gate.this, Gate.class));
                    }
                });
            }
        });

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
