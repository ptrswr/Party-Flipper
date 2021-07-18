package com.example.partyflipper;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

public class Fragment_GameScreen extends Fragment  {

    private static final long START_TIME_IN_MILLIS = 60000;

    private LinearLayout screen;


    private String[] clues;

    private TextView mTextViewCountDown;
    private TextView mTextViewCurrentClue;
    private Button mButtonPause;
    private Button mButtonExit;

    private CountDownTimer mCountDownTimer;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    private RotationSensor rotationSensor;

    public static Fragment_GameScreen newInstance(String[] clues) {
        Fragment_GameScreen f = new Fragment_GameScreen();
        Bundle args = new Bundle();
        args.putStringArray("clues", clues);
        f.setArguments(args);
        return f;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState){
        View view  = inflater.inflate(R.layout.fragment_game_screen, container, false);
        mTextViewCountDown = view.findViewById(R.id.text_view_countdown);
        mTextViewCurrentClue = view.findViewById(R.id.current_clue);

        rotationSensor = new RotationSensor(getActivity());
        rotationSensor.setListener(new RotationSensor.Listener() {
            @Override
            public void onRotation(float x_axis, float y_axis, float z_axis) {
                if (z_axis < 60){
                    Game.replaceFragment(Game.PASS_FRAGMENT);

                }
                else if(z_axis > 92){
                    Game.replaceFragment(Game.GOOD_FRAGMENT);
                }
            }
        });

        Bundle args = getArguments();
        clues = args.getStringArray("clues");

        screen=view.findViewById(R.id.game_screen);
        screen.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Game.replaceFragment(Game.GOOD_FRAGMENT);
                                      }
                                  });
        screen.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Game.replaceFragment(Game.PASS_FRAGMENT);
                return false;
            }
        });

        mButtonExit =view.findViewById(R.id.exit_game);
        mButtonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        mButtonPause = view.findViewById(R.id.button_pause);
        mButtonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonExit.getVisibility() == View.INVISIBLE) {
                    mButtonExit.setVisibility(View.VISIBLE);
                    pauseTimer();
                } else {
                    mButtonExit.setVisibility(View.INVISIBLE);
                    startTimer();
                }
            }
        });
        return view;
    }
    @Override
    public void onPause() {
        super.onPause();
        rotationSensor.unregister();
        pauseTimer();
    }
    @Override
    public void onResume() {
        super.onResume();
        if (mButtonExit.getVisibility() == View.VISIBLE)
            mButtonExit.setVisibility(View.INVISIBLE);
        resetTimer();
        startTimer();
        rotationSensor.register();
        mTextViewCurrentClue.setText(clues[Game.CURRENT_ROUND]);
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                System.out.println(Game.CURRENT_ROUND);
                Game.replaceFragment(Game.PASS_FRAGMENT);
            }
        }.start();
    }
    private void pauseTimer() {
        mCountDownTimer.cancel();
    }
    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
    }
    private void updateCountDownText() {
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d", seconds);
        mTextViewCountDown.setText(timeLeftFormatted);
    }


}
