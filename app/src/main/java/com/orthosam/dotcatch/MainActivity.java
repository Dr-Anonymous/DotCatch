package com.orthosam.dotcatch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton b1, b2, b3, b4, b5, b6, b7, b8;
    TextView textView, score;
    public static String LEVEL;
    public int level;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        if (intent != null)
            level = intent.getIntExtra(MainActivity.LEVEL, 1);
        else
            level = 1;
        //check score and level up
        levelUp(0);
        //set layout and define objects inside it
        setContentView(R.layout.activity_main);
        //set the title
        getSupportActionBar().setTitle("Level " + String.valueOf(level));
        textView = findViewById(R.id.text);
        score = findViewById(R.id.score);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);

        textView.setText("Ready?");
    }

    public void buttonOnClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.text:
                    textView.setText("Catch the dot!!!");
                    textView.setClickable(false);
                    set();
                    break;
                case R.id.b1:
                    //getResources().getDrawable(R.drawable.on).getConstantState()
                    b1.getDrawable().getConstantState();
                    b1.setImageResource(0);
                    score();
                    set();
                    break;
                case R.id.b2:
                    b2.getDrawable().getConstantState();
                    b2.setImageResource(0);
                    score();
                    set();
                    break;
                case R.id.b3:
                    b3.getDrawable().getConstantState();
                    b3.setImageResource(0);
                    set();
                    score();
                    break;
                case R.id.b4:
                    b4.getDrawable().getConstantState();
                    b4.setImageResource(0);
                    set();
                    score();
                    break;
                case R.id.b5:
                    b5.getDrawable().getConstantState();
                    b5.setImageResource(0);
                    set();
                    score();
                    break;
                case R.id.b6:
                    b6.getDrawable().getConstantState();
                    b6.setImageResource(0);
                    set();
                    score();
                    break;
                case R.id.b7:
                    b7.getDrawable().getConstantState();
                    b7.setImageResource(0);
                    set();
                    score();
                    break;
                case R.id.b8:
                    b8.getDrawable().getConstantState();
                    b8.setImageResource(0);
                    set();
                    score();
                    break;
            }
        } catch (Exception e) {
            textView.setText("Game Over.\nPlay again ?");
            textView.setClickable(true);
            b1.setImageResource(0);
            b2.setImageResource(0);
            b3.setImageResource(0);
            b4.setImageResource(0);
            b5.setImageResource(0);
            b6.setImageResource(0);
            b7.setImageResource(0);
            b8.setImageResource(0);
            score.setText("0");
        }
    }

    public void score() {
        CharSequence v1 = score.getText();
        int q = Integer.parseInt(v1.toString());
        q += 1;
        score.setText(q + "");
        levelUp(q);
    }

    public void set() {
        switch (random()) {
            case 1:
                b1.setImageResource(R.drawable.on);
                break;
            case 2:
                b2.setImageResource(R.drawable.on);
                break;
            case 3:
                b3.setImageResource(R.drawable.on);
                break;
            case 4:
                b4.setImageResource(R.drawable.on);
                break;
            case 5:
                b5.setImageResource(R.drawable.on);
                break;
            case 6:
                b6.setImageResource(R.drawable.on);
                break;
            case 7:
                b7.setImageResource(R.drawable.on);
                break;
            case 8:
                b8.setImageResource(R.drawable.on);
                break;

        }
    }

    public void levelUp(int i) {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        int levPoints = 4 * level; //points for each level
        if (i == 0) {
            i = sharedPref.getInt(String.valueOf(level), 0);
            if (i == levPoints) {
                startActivity(new Intent(this, MainActivity.class).putExtra(LEVEL, level + 1));
                finish();
            }
        } else if (i == levPoints) {
            //register the final score
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(String.valueOf(level), i);
            editor.apply();
            //and level-up
            Toast.makeText(this, "Level up!!", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class).putExtra(LEVEL, level + 1));
            finish();
        } else {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt(String.valueOf(level), i);
            editor.apply();
        }
    }

    public int random() {
        final int min = 1;
        final int max;
        if (level == 1)
            max = 4;
        else if (level == 2)
            max = 6;
        else max = 8;
        return new Random().nextInt((max - min) + 1) + min;
    }
}