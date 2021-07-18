package com.example.partyflipper;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_Score extends Fragment {
    private TextView score;
    private LinearLayout screen;
    private CountDownTimer mCountDownTimer;
    private static final long START_TIME_IN_MILLIS = 5000;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_score, container, false);
        score = view.findViewById(R.id.score);
        String points_scored = "You scored  " + Game.POINTS + " / " + Game.NUM_OF_ROUNDS;
        score.setText(points_scored);

        screen = view.findViewById(R.id.score_layout);
        screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    getActivity().finish();
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
                getActivity().finish();
            }
        }.start();
    }
}
