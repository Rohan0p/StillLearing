package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    // 0-x
    //1-o
    //2=null
    int activePlayer=0;
    int[] gameState={2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 ,2 };
    //taking advantage of limited wining position
    int [][] winPostions={ {0,1,2},{3,4,5},{6,7,8},//horizontal
                            {0,3,6},{1,4,7},{2,5,8},//vertical
                                {0,4,8},{2,4,6} };//cross
    public void Tap(View view ){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}