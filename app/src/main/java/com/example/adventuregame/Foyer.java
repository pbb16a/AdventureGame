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

public class Foyer extends AppCompatActivity {
    private TextView textView;
    private TextView buttonText1;
    private TextView buttonText2;
    private TextView buttonText3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foyer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //get textviews
        textView = findViewById(R.id.textView3);
        buttonText1 = findViewById(R.id.button_1);
        buttonText2 = findViewById(R.id.button_2);
        buttonText3 = findViewById(R.id.button_3);

        //get buttons
        final Button button1 = findViewById(R.id.button_1);
        final Button button2 = findViewById(R.id.button_2);
        final Button button3 = findViewById(R.id.button_3);


        textView.setText(R.string.foyer);
        buttonText1.setText(R.string.door1); //dining room
        buttonText2.setText(R.string.door2);//kitchen
        buttonText3.setText(R.string.door3);//stair case

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //after you hit continue..
//                startActivity(new Intent(Foyer.this, Dining.class));
                //to be continued
                textView.setText(R.string.tbd);
                buttonText1.setText(R.string.play_again);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Foyer.this, MainActivity.class));
                    }
                });


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //after you hit continue..
                textView.setText(R.string.k_locked);
//                startActivity(new Intent(GraveYard.this, Porch.class));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //after you hit continue..
                textView.setText(R.string.s_blocked);
//                startActivity(new Intent(GraveYard.this, Porch.class));
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
