package com.example.partyflipper;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.Locale;

public class Fragment_BeginGame extends Fragment {
    private ConstraintLayout screen;
    private CountDownTimer mCountDownTimer;
    private TextView mCountdownTime;
    private  final long START_TIME_IN_MILLIS = 3000;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;



    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState){

        View view  = inflater.inflate(R.layout.fragment_begin_game, container, false);
        mCountdownTime = view.findViewById(R.id.text_view_countdown);
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
                updateCountDownText();
            }
            public void onFinish() {
                Game.replaceFragment(Game.GAME_SCREEN_FRAGMENT);
            }
        }.start();
    }

    private void updateCountDownText() {
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%01d", seconds);
        mCountdownTime.setText(timeLeftFormatted);
    }
}


