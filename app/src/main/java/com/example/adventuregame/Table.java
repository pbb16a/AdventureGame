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

public class Table extends AppCompatActivity {

    private TextView textView;
    private TextView buttonText1;
    private TextView buttonText2;
    private TextView buttonText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(Dining.book && Dining.glasses){
            startActivity(new Intent(Table.this, Dining.class));
        }

        //get textviews
        textView = findViewById(R.id.textView3);
        buttonText1 = findViewById(R.id.button_1);
        buttonText2 = findViewById(R.id.button_2);
        buttonText3 = findViewById(R.id.button_3);

        //get buttons
        final Button button1 = findViewById(R.id.button_1);
        final Button button2 = findViewById(R.id.button_2);
        final Button button3 = findViewById(R.id.button_3);


        textView.setText(R.string.check_table);
        button3.setVisibility(View.VISIBLE);
        buttonText1.setText(R.string.goblet);
        buttonText2.setText(R.string.glasses);
        buttonText3.setText(R.string.book);


        //goblet
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //after you hit continue..
                textView.setText(R.string.af_goblet);
                buttonText1.setText(R.string.drink);
                buttonText2.setText(R.string.put_back);
                button3.setVisibility(View.GONE);
                button1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) { //after you hit continue..
                        textView.setText(R.string.af_drink);
                        buttonText1.setText(R.string.table);
                        button2.setVisibility(View.GONE);

                        button1.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Dining.goblet = true;
                                startActivity(new Intent(Table.this, Table.class));
                            }
                        });
                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Table.this, Table.class));
                    }
                });

            }
        });

        //glasses
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(R.string.af_glasses);
                buttonText1.setText(R.string.put_on);
                buttonText2.setText(R.string.put_back);
                button3.setVisibility(View.GONE);
                button1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        textView.setText(R.string.w_glasses);
                        buttonText1.setText(R.string.go_door);
                        button2.setVisibility(View.GONE);
                        button1.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Dining.glasses = true;
                                startActivity(new Intent(Table.this, Kitchen.class));
                            }
                        });
                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Table.this, Table.class));
                    }
                });
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { //after you hit continue..
                textView.setText(R.string.af_book);
                buttonText1.setText(R.string.hold_on);
                buttonText2.setText(R.string.put_back);
                button3.setVisibility(View.GONE);

                button1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Dining.book = true;
                        startActivity(new Intent(Table.this, Table.class));

                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Table.this, Table.class));
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
