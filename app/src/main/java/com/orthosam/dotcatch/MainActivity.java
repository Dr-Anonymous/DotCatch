package com.orthosam.dotcatch;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton btn1, btn2, btn3, btn4;
    TextView textView, score;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //set layout and define objects inside it
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        score = findViewById(R.id.score);
        btn1 = findViewById(R.id.imageButton1);
        btn2 = findViewById(R.id.imageButton2);
        btn3 = findViewById(R.id.imageButton3);
        btn4 = findViewById(R.id.imageButton4);
        textView.setText("Ready?");
    }

    public void buttonOnClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.text:
                    textView.setText("Catch !!!");
                    textView.setClickable(false);
                    set();
                    break;
                case R.id.imageButton1:
                    //getResources().getDrawable(R.drawable.on).getConstantState()
                    btn1.getDrawable().getConstantState();
                    btn1.setImageResource(0);
                    score();
                    set();
                    break;
                case R.id.imageButton2:
                    btn2.getDrawable().getConstantState();
                    btn2.setImageResource(0);
                    score();
                    set();
                    break;
                case R.id.imageButton3:
                    btn3.getDrawable().getConstantState();
                    btn3.setImageResource(0);
                    set();
                    score();
                    break;
                case R.id.imageButton4:
                    btn4.getDrawable().getConstantState();
                    btn4.setImageResource(0);
                    set();
                    score();
                    break;
            }
        } catch (Exception e) {
            textView.setText("Game Over\nPlay again?");
            textView.setClickable(true);
            btn1.setImageResource(0);
            btn2.setImageResource(0);
            btn3.setImageResource(0);
            btn4.setImageResource(0);
            score.setText("0");
        }
    }


    public void score() {
        CharSequence v1 = score.getText();
        int q = Integer.parseInt(v1.toString());
        q += 1;
        score.setText(q + "");
    }

    public void set() {
        switch (random()) {
            case 1:
                btn1.setImageResource(R.drawable.on);
                break;
            case 2:
                btn2.setImageResource(R.drawable.on);
                break;
            case 3:
                btn3.setImageResource(R.drawable.on);
                break;
            case 4:
                btn4.setImageResource(R.drawable.on);
                break;
        }
    }


    public int random() {
        final int min = 1;
        final int max = 4;
        return new Random().nextInt((max - min) + 1) + min;
    }
}