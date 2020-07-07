package com.orthosam.dotcatch;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton btn1, btn2, btn3, btn4;
    TextView textView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //set layout and define objects inside it
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        btn1 = findViewById(R.id.imageButton1);
        btn2 = findViewById(R.id.imageButton2);
        btn3 = findViewById(R.id.imageButton3);
        btn4 = findViewById(R.id.imageButton4);
        textView.setText("Ready?");
    }

    public void buttonOnClick(View view) {
        switch (view.getId()) {
            case R.id.imageButton1:
                if (btn1.getDrawable().getCurrent().isVisible()) {
                    btn1.setVisibility(View.INVISIBLE);
                    btn2.setVisibility(View.VISIBLE);
                } else {
                    textView.setText("Game Over.....");
                }
                break;
            case R.id.imageButton2:
                if (btn2.getDrawable().isVisible()) {
                    btn2.setVisibility(View.INVISIBLE);
                    btn3.setVisibility(View.VISIBLE);
                    ;
                } else {
                    textView.setText("Game Over.....");
                }
                break;
            case R.id.imageButton3:
                if (btn3.getDrawable().isVisible()) {
                    btn3.setVisibility(View.INVISIBLE);
                    btn4.setVisibility(View.VISIBLE);
                    ;
                } else {
                    textView.setText("Game Over.....");
                }
                break;
            case R.id.imageButton4:
                if (btn4.getDrawable().isVisible()) {
                    btn4.setVisibility(View.INVISIBLE);
                    btn1.setVisibility(View.VISIBLE);
                    ;
                } else {
                    textView.setText("Game Over.....");
                }
                break;

        }
    }

   /* public void startGame() {
        try {
            Thread.sleep( 1000);
            textView.setText("set");
            Thread.sleep( 1000);
            textView.setText("Catch !!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
}