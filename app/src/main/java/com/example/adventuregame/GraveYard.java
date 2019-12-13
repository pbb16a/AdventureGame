package com.example.adventuregame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GraveYard extends AppCompatActivity {
    public static boolean gotKey = false;
    public static boolean explored = false;
    private TextView textView;
    private TextView buttonText1;
    private TextView buttonText2;
    private TextView buttonText3;
    private ImageView imageViewMonster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grave_yard);
        imageViewMonster = findViewById(R.id.image_view_monster);
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

        graveyard.start();

        if(!explored) {

            textView.setText(R.string.court_yard2);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.GONE);
            buttonText1.setText(R.string.cy_opt1); //gy
            buttonText2.setText(R.string.cy_opt2); //house
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    explored = true;
                    textView.setText(R.string.gy_cont);
                    buttonText1.setText(R.string.cont);
                    button2.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                    button1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) { //after you hit continue..
                            textView.setText(R.string.gy_cont2);
                            imageViewMonster.setImageResource(R.drawable.skelliesdone);
                            buttonText1.setText(R.string.gy_cont_opt1);
                            buttonText2.setText(R.string.gy_cont_opt2);
                            buttonText3.setText(R.string.gy_cont_opt3);
                            button2.setVisibility(View.VISIBLE);
                            button3.setVisibility(View.VISIBLE);
                            button1.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) { //after you hit continue..
                                    textView.setText(R.string.talk);
                                }
                            });
                            button2.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) { //after you hit continue..
                                    textView.setText(R.string.joke1);
                                    buttonText1.setText(R.string.cont);
                                    button2.setVisibility(View.GONE);
                                    button3.setVisibility(View.GONE);
                                    button1.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) { //after you hit continue..
                                            textView.setText(R.string.joke2);
                                            button1.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View v) { //after you hit continue..
                                                    textView.setText(R.string.joke3);
                                                    gotKey = true;
                                                    button2.setVisibility(View.VISIBLE);
                                                    buttonText1.setText(R.string.go_gate);
                                                    buttonText2.setText(R.string.cy_opt2); //porch
                                                    button1.setOnClickListener(new View.OnClickListener() {
                                                        public void onClick(View v) { //after you hit continue..
                                                            textView.setText(R.string.gate);
                                                            buttonText1.setText(R.string.cont);
                                                            button2.setVisibility(View.GONE);
                                                            button1.setOnClickListener(new View.OnClickListener() {
                                                                public void onClick(View v) {
                                                                    startActivity(new Intent(GraveYard.this, Porch.class));
                                                                }
                                                            });
                                                        }
                                                    });

                                                    button2.setOnClickListener(new View.OnClickListener() {
                                                        public void onClick(View v) { //after you hit continue..
                                                            startActivity(new Intent(GraveYard.this, Porch.class));
                                                        }
                                                    });
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                            button3.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) { //after you hit continue..
                                    textView.setText(R.string.fight);
                                }
                            });
                        }
                    });
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(GraveYard.this, Porch.class));
                }
            });
        }
        else if(explored){

            textView.setText(R.string.gy_cont);
            buttonText1.setText(R.string.cont);
            button2.setVisibility(View.GONE);
            button3.setVisibility(View.GONE);
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) { //after you hit continue..
                    textView.setText(R.string.gy_cont2);
                    buttonText1.setText(R.string.gy_cont_opt1);
                    buttonText2.setText(R.string.gy_cont_opt2);
                    buttonText3.setText(R.string.gy_cont_opt3);
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    button1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) { //after you hit continue..
                            textView.setText(R.string.talk);
                        }
                    });
                    button2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) { //after you hit continue..
                            textView.setText(R.string.joke1);
                            buttonText1.setText(R.string.cont);
                            button2.setVisibility(View.GONE);
                            button3.setVisibility(View.GONE);
                            button1.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) { //after you hit continue..
                                    textView.setText(R.string.joke2);
                                    button1.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View v) { //after you hit continue..
                                            textView.setText(R.string.joke3);
                                            gotKey = true;
                                            button2.setVisibility(View.VISIBLE);
                                            buttonText1.setText(R.string.go_gate);
                                            buttonText2.setText(R.string.cy_opt2); //porch
                                            button1.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View v) { //after you hit continue..
                                                    textView.setText(R.string.gate);
                                                    buttonText1.setText(R.string.cont);
                                                    button2.setVisibility(View.GONE);
                                                    button1.setOnClickListener(new View.OnClickListener() {
                                                        public void onClick(View v) {
                                                            startActivity(new Intent(GraveYard.this, Porch.class));
                                                        }
                                                    });
                                                }
                                            });

                                            button2.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View v) { //after you hit continue..
                                                    startActivity(new Intent(GraveYard.this, Porch.class));
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                        }
                    });
                    button3.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) { //after you hit continue..
                            textView.setText(R.string.fight);
                        }
                    });
                }
            });
        }
    }
}
