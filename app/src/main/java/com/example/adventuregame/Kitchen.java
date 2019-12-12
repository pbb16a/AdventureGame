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

public class Kitchen extends AppCompatActivity {
    private TextView textView;
    private TextView buttonText1;
    private TextView buttonText2;
    private TextView buttonText3;
    public static boolean rbf_bw = false;
    boolean entered = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
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




        if(!entered || rbf_bw){
            entered = true;
            textView.setText(R.string.k_enter);
            buttonText1.setText(R.string.k_option1);
            buttonText2.setText(R.string.k_option2);
            buttonText3.setText(R.string.k_option3);

            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    textView.setText(R.string.k_option1_2);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rbf_bw = true;
//                    textView.setText(R.string.k_option2_2);
                    startActivity(new Intent(Kitchen.this, Dining.class));
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    rbf_bw = false;
                    textView.setText(R.string.k_option3_2);
                    button2.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                    if(Dining.book){
                        buttonText1.setText(R.string.use_book);
                        button1.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                textView.setText(R.string.af_give_book);
                                buttonText1.setText(R.string.exit_k);
                            }
                        });
                    }
                    else{
                        buttonText1.setText(R.string.look_book);
                        button1.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                startActivity(new Intent(Kitchen.this, Dining.class));
                            }
                        });
                    }
                    //if you have book, or go back to dinning room
                }
            });
        }
        else if(entered){
            textView.setText(R.string.k_enter_after);
            button3.setVisibility(View.GONE);
            if(Dining.book){
                buttonText1.setText(R.string.use_book);
                button1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        textView.setText(R.string.af_give_book);
                        buttonText1.setText(R.string.exit_k);
                    }
                });
            }
            else{
                buttonText1.setText(R.string.no_book);
                button1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Kitchen.this, Dining.class));
                    }
                });
            }
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
//    startActivity(new Intent(Table.this, Table.class));

}
