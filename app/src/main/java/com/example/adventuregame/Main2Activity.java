//this is the intro page that includes losing the game
package com.example.adventuregame;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView textViewNum;
    private TextView buttonText1;
    private TextView buttonText2;
    private TextView buttonText3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //get textviews
        textViewNum = findViewById(R.id.textView3);
        buttonText1 = findViewById(R.id.button_1);
        buttonText2 = findViewById(R.id.button_2);
        buttonText3 = findViewById(R.id.button_3);

        //get buttons
        final Button button1 = findViewById(R.id.button_1);
        final Button button2 = findViewById(R.id.button_2);
        final Button button3 = findViewById(R.id.button_3);


        //set text to starting point
        textViewNum.setText(R.string.intro);
        buttonText1.setText(R.string.yes);
        buttonText2.setText(R.string.no);

        //hide 3rd button
        button3.setVisibility(View.GONE);

        //button 1 says yes
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this, Main3Activity.class));
            }
        });
        //button 2 says no
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textViewNum.setText(R.string.loose);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                buttonText1.setText(R.string.try_again);
                button1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Main2Activity.this, Main2Activity.class));
                    }
                });
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
