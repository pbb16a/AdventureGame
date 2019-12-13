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

public class Dining extends AppCompatActivity {
    private TextView textView;
    private TextView buttonText1;
    private TextView buttonText2;
    private TextView buttonText3;

    public static boolean goblet = false;
    public static boolean glasses = false;
    public static boolean book = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);
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

        if(Kitchen.rbf_bw){
            textView.setText(R.string.k_option2_2);
        }
        else if(book && glasses){
            textView.setText(R.string.dining2);
        }
        else {
            textView.setText(R.string.dining);
        }
        buttonText1.setText(R.string.to_door);//kitchen
        buttonText2.setText(R.string.ex_items);//stair case
        button3.setVisibility(View.GONE);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //after you hit continue..
                if(!glasses)
                    textView.setText(R.string.wo_glasses);
                else if(glasses)
                    startActivity(new Intent(Dining.this, Kitchen.class));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //after you hit continue..
                startActivity(new Intent(Dining.this, Table.class));
            }
        });
    }
}
