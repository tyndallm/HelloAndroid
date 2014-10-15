package com.detroitlabs.tyndallm.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tyndallm on 10/2/14.
 */
public class ScoreActivity extends Activity {



    Button restartBtn;
    TextView scoreTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("ScoreActivity", "onCreate() called");

        setContentView(R.layout.activity_score);

        scoreTextView = (TextView) findViewById(R.id.scoreText);
        restartBtn = (Button) findViewById(R.id.restartBtn);

        restartBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.v("ScoreActivity", "restartBtn clicked");

                finish();
            }
        });

        Intent intent = getIntent();
        if(intent.hasExtra(MainActivity.EXTRA_SCORE)){
            int score = intent.getIntExtra("STATE_SCORE", 0);
            scoreTextView.setText("Your score: " + score);
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.v("ScoreActivity", "onPause() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("ScoreActivity", "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("ScoreActivity", "onDestroy() called");
    }
}
