package com.example.partyflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Game_Logic logic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button randomGame = findViewById(R.id.randomGame);
        Button choseCategory= findViewById(R.id.choose_cat);
        final Intent startGame = new Intent(this, Game.class);
        final Intent showCategories = new Intent(this,Categories.class);

        randomGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(logic == null)
                    logic =  new Game_Logic();
                startGame.putExtra("clues", logic.loadRandomClues(Game.NUM_OF_ROUNDS) );
                startActivity(startGame);
            }
        });
        choseCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(showCategories);
            }

        });

        ImageView logo1=(ImageView)findViewById(R.id.logo1); //cast the iv imageView button
        Animation anim= AnimationUtils.loadAnimation(MainActivity.this, R.anim.flip_logo);
        logo1.setAnimation(anim);
        ImageView logo2=(ImageView)findViewById(R.id.logo2); //cast the iv imageView button
        logo2.setAnimation(anim);

    }
}