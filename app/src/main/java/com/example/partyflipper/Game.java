package com.example.partyflipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Game extends AppCompatActivity {
    public  static  final int PASS_FRAGMENT =3;
    public  static  final int GAME_SCREEN_FRAGMENT =2;
    public  static  final int GOOD_FRAGMENT =1;
    public  static  final int SCORE_FRAGMENT =4;
    public  static  final int BEGIN_FRAGMENT =0;

    public static final int  NUM_OF_ROUNDS = 8;
    public static  int  CURRENT_ROUND = 0;
    public static int POINTS =0;


    private GameStateAdapter mGameStateAdapter;
    private static ViewPager2 mViewPager;
    private String[] clues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CURRENT_ROUND=0;
        POINTS=0;

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        mGameStateAdapter = new GameStateAdapter(this);


        Bundle b = getIntent().getExtras();
        if (b!=null)
            clues = b.getStringArray("clues");

        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);
        setViewPager(BEGIN_FRAGMENT);


    }

    private void setupViewPager(ViewPager2 viewPager){
        mGameStateAdapter.addFragment(new Fragment_BeginGame(), "Fragment_BeginGame");
        mGameStateAdapter.addFragment(new Fragment_Good(), "Fragment_Good");
        mGameStateAdapter.addFragment(Fragment_GameScreen.newInstance(clues), "Fragment_GameScreen");
        mGameStateAdapter.addFragment(new Fragment_Pass(), "Fragment_Pass");
        mGameStateAdapter.addFragment(new Fragment_Score(), "Fragment_Score");

        viewPager.setAdapter(mGameStateAdapter);
    }

    public static void replaceFragment(int page){setViewPager(page);}
    private static  void setViewPager(int fragmentNumber){
        mViewPager.setCurrentItem(fragmentNumber);
    }





}