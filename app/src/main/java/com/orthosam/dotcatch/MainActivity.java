package com.orthosam.dotcatch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static String LEVEL;
    public int level;
    ImageButton b1, b2, b3;
    TextView textView, score;
    RelativeLayout parent;

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
        textView.setText(R.string.ready);
        score = findViewById(R.id.score);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        parent = findViewById(R.id.parent);
        parent.setClickable(false);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        set(b1);
        set(b2);
    }

    public void buttonOnClick(View view) {
        switch (view.getId()) {
            case R.id.text:
                textView.setText(R.string.DotCatch);
                textView.setClickable(false);
                parent.setClickable(true);
                b1.setVisibility(View.VISIBLE);
                set(b1);
                if (level > 5) {
                   /* ImageButton myButton = new ImageButton(this);
                    myButton.setLayoutParams(new RelativeLayout.LayoutParams(
                            RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT));
                    */
                    b2.setVisibility(View.VISIBLE);
                    set(b2);
                }
                break;
            case R.id.parent:
                textView.setText(R.string.over);
                textView.setClickable(true);
                parent.setClickable(false);
                b1.setVisibility(View.GONE);
                b2.setVisibility(View.GONE);
                score.setText("0");
                break;
            case R.id.b1:
                score();
                set(b1);
                break;
            case R.id.b2:
                score();
                set(b2);
                break;
        }

    }

    public void score() {
        CharSequence v1 = score.getText();
        int q = Integer.parseInt(v1.toString());
        q += 1;
        score.setText(q + "");
        levelUp(q);
    }

    public void set(View v) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = random()[0];
        params.topMargin = random()[1];
        v.setLayoutParams(params);
       /* switch (i) {
            case 1:
                b1.setLayoutParams(params);
                break;
            case 2:
                b2.setLayoutParams(params);
                break;
        }*/

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

    public int[] random() {
        int w = Resources.getSystem().getDisplayMetrics().widthPixels;
        int h = Resources.getSystem().getDisplayMetrics().heightPixels;
        w = w - 180;//do the adjustments  w-200 and h-300
        h = h - 300;
        final int min = 0;
        w = new Random().nextInt((w - min) + 1) + min;
        h = new Random().nextInt((h - min) + 1) + min;
        return new int[]{w, h};
    }
}