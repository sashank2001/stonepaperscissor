package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SinglePlayerGame extends AppCompatActivity {
    ImageView stoneImage,paperImage,scissorImage;
    TextView score;
    ImageView iv_computerchoice,iv_playerchoice;
    String result;
    int playerscore=0,computerscore=0;
    int n, p=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_game);
        String playername = getIntent().getStringExtra("playername");

        String rounds = getIntent().getStringExtra("no. of rounds");
         n = Integer.parseInt(rounds);


        TextView textView = (TextView) findViewById(R.id.textView3);
        String textViewText =  playername+" 's CHOICE";
        textView.setText(textViewText);

         stoneImage =(ImageView)findViewById(R.id.imageView3);
         paperImage =(ImageView)findViewById(R.id.imageView4);
         scissorImage =(ImageView)findViewById(R.id.imageView5);

        iv_computerchoice=(ImageView)findViewById(R.id.imageView) ;
        iv_playerchoice=(ImageView)findViewById(R.id.imageView2) ;

         stoneImage.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 iv_playerchoice.setImageResource(R.drawable.rock);

                 if(p<n){
                 player_turn("stone");}else
                 {  Intent scoreintent = new Intent(v.getContext(), SinglePlayerResult.class);
                     scoreintent.putExtra("playerscore",playerscore);
                     scoreintent.putExtra("computerscore",computerscore);
                     startActivityForResult(scoreintent, 0);}

             }
         });
        paperImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_playerchoice.setImageResource(R.drawable.paper);

                if(p<n){
                    player_turn("paper");}else
                {     Intent scoreintent2 = new Intent(v.getContext(), SinglePlayerResult.class);
                    scoreintent2.putExtra("playerscore",playerscore);
                    scoreintent2.putExtra("computerscore",computerscore);
                    startActivityForResult(scoreintent2, 0);}

            }
        });
        scissorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_playerchoice.setImageResource(R.drawable.scissor);

                if(p<n){
                    player_turn("scissor");}else
                {  Intent scoreintent3 = new Intent(v.getContext(), SinglePlayerResult.class);
                    scoreintent3.putExtra("playerscore",playerscore);
                    scoreintent3.putExtra("computerscore",computerscore);
                    startActivityForResult(scoreintent3, 0);}

            }
        });



    }
    public void player_turn(String player_choice){
        String computer_choice="";
        Random r = new  Random();
        int computer_choice_number = r.nextInt(3) +1;
        if(computer_choice_number==1){
            computer_choice="stone";
        }else
        if(computer_choice_number==2){
            computer_choice="paper";
        }else
        if(computer_choice_number==3){
            computer_choice="scissor";
        }

        if(computer_choice=="stone"){
            iv_computerchoice.setImageResource(R.drawable.rock);
        }else
        if(computer_choice=="paper"){
            iv_computerchoice.setImageResource(R.drawable.paper);
        }else
        if(computer_choice=="scissor"){
            iv_computerchoice.setImageResource(R.drawable.scissor);
        }

        if(player_choice==computer_choice){
            result="DRAW";
        } else if (player_choice=="stone"&&computer_choice=="paper") {
            result = "you lost this round";
            computerscore++;
        }else if (player_choice=="stone"&&computer_choice=="scissor") {
            result = "you won this round";
            playerscore++;
        }else if (player_choice=="paper"&&computer_choice=="stone") {
            result = "you won this round";
            playerscore++;
        }else if (player_choice=="paper"&&computer_choice=="scissor") {
            result = "you lost this round";
            computerscore++;
        }else if (player_choice=="scissor"&&computer_choice=="stone") {
            result = "you lost this round";
            computerscore++;
        }else if (player_choice=="scissor"&&computer_choice=="paper") {
            result = "you won this round";
            playerscore++;
        }
        Toast.makeText(SinglePlayerGame.this, result,Toast.LENGTH_SHORT).show();

        TextView score = (TextView) findViewById(R.id.textView5);
        String textViewText = "COMPUTER:"+computerscore+ " YOU:"+ playerscore;
        score.setText(textViewText);


        if(  result == "you won this round"){
            LinearLayout bg = (LinearLayout) findViewById(R.id.rootlayout);
            bg.setBackgroundColor(Color.GREEN);

        }else
        if( result == "you lost this round"){
            LinearLayout bg = (LinearLayout) findViewById(R.id.rootlayout);
            bg.setBackgroundColor(Color.RED);

        }
        else
        if( result == "DRAW"){
            LinearLayout bg = (LinearLayout) findViewById(R.id.rootlayout);
            bg.setBackgroundColor(Color.WHITE);

        }

        ++p;
        if(p==n){
            Toast.makeText(SinglePlayerGame.this, "MATCH IS OVER.Click any image to continue",Toast.LENGTH_SHORT).show();

        }




    }

}
