package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    // 0-x
    //1-o
    //2=null
    boolean gameActive = false;
    int ActivePlayer = 0;
    int[] GameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //taking advantage of limited wining position
    int[][] winPostions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},//horizontal
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},//vertical
            {0, 4, 8}, {2, 4, 6}};//cross

    public void Tap(View view) {
        ImageView img = (ImageView) view;
        int TappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive) {
          gameReset(view);
        }

        if (GameState[TappedImage] == 2) {
            GameState[TappedImage] = ActivePlayer;
            img.setTranslationY(-1000f);
            if (ActivePlayer == 0) {
                img.setImageResource(R.drawable.x);
                ActivePlayer = 1;
                TextView status = findViewById(R.id.Status);
                status.setText("O's turn tap to play");
            } else {
                img.setImageResource(R.drawable.o);
                ActivePlayer = 0;
                TextView status = findViewById(R.id.Status);
                status.setText("X's turn tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        String result;
        // checking if any player won or not
        for (int[] winp : winPostions) {
            if (GameState[winp[0]] == GameState[winp[1]] &&
                    GameState[winp[1]] == GameState[winp[2]] && GameState[winp[0]] != 2) {
                //won
                gameActive = false;
                if (GameState[winp[0]] == 0) {
                    result = "X WON";
                } else {
                    result = "O WON";
                }
                TextView ShowingResult = findViewById(R.id.Status);
                ShowingResult.setText(result);
                return;
            }

        }
    }


    public void gameReset(View view){
        ActivePlayer=0;
        gameActive=true;
//        for(int i=0; i<GameState.length; i++){
//            GameState[i]=2;
//        }
//
        int[] resetGameState={2,2,2,2,2,2,2,2,2};
        GameState=resetGameState;
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
         Tap(view);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}