package com.detroitlabs.tyndallm.helloandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener, Animation.AnimationListener{

    public static final String EXTRA_SCORE = "EXTRA_SCORE";
    public final String STATE_INCREASES = "STATE_INCREASES";
    public final String STATE_DECREASES = "STATE_DECREASES";

    public int currentScore = 0;

    public int increaseClickedCount = 0;
    public int decreaseClickedCount = 0;

    public Button increaseBtn;
    public Button decreaseBtn;
    public Button winBtn;
    public TextView increaseTextView;
    public TextView decreaseTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("MainActivity", "onCreate() called");

        setContentView(R.layout.activity_main);

        increaseBtn = (Button) findViewById(R.id.increase_score_btn);
        decreaseBtn = (Button) findViewById(R.id.decrease_score_btn);
        winBtn = (Button) findViewById(R.id.win_btn);
        increaseTextView = (TextView) findViewById(R.id.increaseCountText);
        decreaseTextView = (TextView) findViewById(R.id.decreaseCountText);

        increaseBtn.setOnClickListener(this);
        decreaseBtn.setOnClickListener(this);
        winBtn.setOnClickListener(this);

        if(savedInstanceState != null) {
            increaseClickedCount = savedInstanceState.getInt(STATE_INCREASES);
            decreaseClickedCount = savedInstanceState.getInt(STATE_DECREASES);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        Log.v("MainActivity", "onSaveInstanceState() called");
        // Save the user's current game state
        savedInstanceState.putInt(STATE_INCREASES, increaseClickedCount);
        savedInstanceState.putInt(STATE_DECREASES, decreaseClickedCount);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.increase_score_btn:
                Log.v("MainActivity", "increaseScoreBtn clicked");
                increaseClickedCount ++;
                increaseTextView.setText("Increase clicked: " + increaseClickedCount);
                currentScore ++;
                break;
            case R.id.decrease_score_btn:
                Log.v("MainActivity", "decreaseScoreBtn clicked");
                decreaseClickedCount ++;
                decreaseTextView.setText("Decrease clicked: " + decreaseClickedCount);
                currentScore --;
                break;
            case R.id.win_btn:
                Log.v("MainActivity", "winBtn clicked");
                int totalScore = increaseClickedCount + (decreaseClickedCount * -1);

                increaseClickedCount = 0;
                decreaseClickedCount = 0;

                Intent scoreIntent = new Intent(this, MainActivity.class);
                scoreIntent.putExtra(EXTRA_SCORE, totalScore);
                startActivity(scoreIntent);
                break;
            default:
                // do nothing
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("MainActivity", "onResume() called");

        increaseTextView.setText("Increase clicked: " + increaseClickedCount);
        decreaseTextView.setText("Decrease clicked: " + decreaseClickedCount);
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.v("MainActivity", "onPause() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("MainActivity", "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("MainActivity", "onDestroy called");
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
