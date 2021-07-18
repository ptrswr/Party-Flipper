package com.example.partyflipper;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class Fragment_Good  extends Fragment {
    private ConstraintLayout screen;
    private CountDownTimer mCountDownTimer;
    private  final long START_TIME_IN_MILLIS = 2000;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState){

        View view  = inflater.inflate(R.layout.fragment_good, container, false);
        screen=view.findViewById(R.id.good_layout);
        screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game.POINTS++;
                Game.CURRENT_ROUND++;
                if(Game.CURRENT_ROUND ==Game.NUM_OF_ROUNDS)
                    Game.replaceFragment(Game.SCORE_FRAGMENT);
                else Game.replaceFragment(Game.GAME_SCREEN_FRAGMENT);
            }
        });
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        mCountDownTimer.cancel();
    }
    @Override
    public void onResume() {
        super.onResume();
        resetTimer();
        startTimer();
    }

    private void resetTimer() {

        mTimeLeftInMillis = START_TIME_IN_MILLIS;
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
            }
            public void onFinish() {
                Game.POINTS++;
                Game.CURRENT_ROUND++;
                if(Game.CURRENT_ROUND ==Game.NUM_OF_ROUNDS)
                    Game.replaceFragment(Game.SCORE_FRAGMENT);
                else Game.replaceFragment(Game.GAME_SCREEN_FRAGMENT);
            }
        }.start();
    }
}


