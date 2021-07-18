package com.example.partyflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Categories extends AppCompatActivity {
    private Game_Logic logic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        logic =  new Game_Logic();

        final Intent startGame = new Intent(this, Game.class);

        ImageView category = findViewById(R.id.cat_logo);
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame.putExtra("clues", logic.loadClues(Game.NUM_OF_ROUNDS, "WK") );
                startActivity(startGame);
            }
        });


        Button animals_cat = findViewById(R.id.animals_cat);
        animals_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame.putExtra("clues", logic.loadClues(Game.NUM_OF_ROUNDS, "ANIMALS") );
                startActivity(startGame);
            }
        });
        Button movies_cat = findViewById(R.id.movies_cat);
        movies_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame.putExtra("clues", logic.loadClues(Game.NUM_OF_ROUNDS, "MOVIES") );
                startActivity(startGame);
            }
        });
        Button food_cat = findViewById(R.id.food_cat);
        food_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame.putExtra("clues", logic.loadClues(Game.NUM_OF_ROUNDS, "FOOD") );
                startActivity(startGame);
            }
        });
        Button books_cat = findViewById(R.id.books_cat);
        books_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame.putExtra("clues", logic.loadClues(Game.NUM_OF_ROUNDS, "BOOKS") );
                startActivity(startGame);
            }
        });
        Button sport_cat = findViewById(R.id.sport_cat);
        sport_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame.putExtra("clues", logic.loadClues(Game.NUM_OF_ROUNDS, "SPORT") );
                startActivity(startGame);
            }
        });
        Button geography_cat = findViewById(R.id.geography_cat);
        geography_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame.putExtra("clues", logic.loadClues(Game.NUM_OF_ROUNDS, "GEOGRAPHY") );
                startActivity(startGame);
            }
        });
        Button games_cat = findViewById(R.id.games_cat);
        games_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame.putExtra("clues", logic.loadClues(Game.NUM_OF_ROUNDS, "GAMES") );
                startActivity(startGame);
            }
        });
        Button fame_cat = findViewById(R.id.fame_cat);
        fame_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame.putExtra("clues", logic.loadClues(Game.NUM_OF_ROUNDS, "FAME") );
                startActivity(startGame);
            }
        });
        Button songs_cat = findViewById(R.id.songs_cat);
        songs_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame.putExtra("clues", logic.loadClues(Game.NUM_OF_ROUNDS, "SONGS") );
                startActivity(startGame);
            }
        });
        Button disney_cat = findViewById(R.id.disney_cat);
        disney_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame.putExtra("clues", logic.loadClues(Game.NUM_OF_ROUNDS, "DISNEY") );
                startActivity(startGame);
            }
        });


    }
}