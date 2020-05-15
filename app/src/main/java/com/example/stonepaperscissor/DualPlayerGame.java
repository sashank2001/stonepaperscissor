package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DualPlayerGame extends AppCompatActivity {

    String player1choice ;
    String player2choice ;
    String result;
    String player1name,player2name,rounds;
    int n,i=0;
    int player1score=0,player2score=0;
    int g=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_player_game);
        player1name = getIntent().getStringExtra("player1name");
        player2name = getIntent().getStringExtra("player2name");

         rounds = getIntent().getStringExtra("no. of rounds");
         n = Integer.parseInt(rounds);


        TextView textView = (TextView) findViewById(R.id.player_1_turn);
        String textViewText =  player1name+" 's choice";
        textView.setText(textViewText);
        TextView textView2 = (TextView) findViewById(R.id.player_2_turn);
        String textViewText2 =  player2name+" 's choice";
        textView2.setText(textViewText2);

        TextView textView3 = (TextView) findViewById(R.id.player1_score);
        textView3.setText(player1name + " : 0");
        TextView textView4 = (TextView) findViewById(R.id.player2_score);
        textView4.setText(player2name + " : 0");

        ImageView stoneImage =(ImageView)findViewById(R.id.stone_image);
        ImageView paperImage =(ImageView)findViewById(R.id.paper_image);
        ImageView scissorImage =(ImageView)findViewById(R.id.scissor_image);

        ImageView stoneImage2 =(ImageView)findViewById(R.id.stone_image_2);
        ImageView paperImage2 =(ImageView)findViewById(R.id.paper_image_2);
        ImageView scissorImage2 =(ImageView)findViewById(R.id.scissor_image_2);


        stoneImage.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
              player1choice ="stone";
                ++i;
                check(v);

            }
        });

        paperImage.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                player1choice ="paper";
                ++i;
                check(v);
            }
        });




        scissorImage.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                player1choice ="scissor";
                ++i;
                check(v);


            }
        });


            stoneImage2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    player2choice = "stone";
                    ++i;
                    check(v);
                }
            });

            paperImage2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    player2choice = "paper";
                    ++i;
                    check(v);
                }
            });

            scissorImage2.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    player2choice = "scissor";
                    ++i;
                  check(v);
                }
            });
        }
        public void check(View v){
            ++g;

            if(g>=((n*2)+1)){
                Intent scoreintent = new Intent(v.getContext(), DualPlayerResult.class);
                scoreintent.putExtra("player1name", player1name);
                scoreintent.putExtra("player2name", player2name);
                scoreintent.putExtra("player1score",player1score);
                scoreintent.putExtra("player2score",player2score);
                startActivityForResult(scoreintent, 0);
            }else {proceed();

        }}
        public void proceed(){


            if (i == 2) {
                winner();
                i = 0;
            }
        }



    public void winner(){
        if(player1choice=="stone"&&player2choice=="stone"){
            result="DRAW";

        }  if(player1choice=="paper"&&player2choice=="paper"){
            result="DRAW";

        }  if(player1choice=="scissor"&&player2choice=="scissor"){
            result="DRAW";

        }  else if (player1choice=="stone"&&player2choice=="paper"){
            result=player2name+" wins this round";
            player2score++;
        }else if (player1choice=="stone"&&player2choice=="scissor"){
            result=player1name+" wins this round";
             player1score++;
        }else if (player1choice=="paper"&&player2choice=="stone"){
            result=player1name+" wins this round";
            player1score++;
        }else if (player1choice=="paper"&&player2choice=="scissor"){
            result=player2name+" wins this round";
            player2score++;
        }else if (player1choice=="scissor"&&player2choice=="stone"){
            result=player2name+" wins this round";
            player2score++;
        }else if (player1choice=="scissor"&&player2choice=="paper"){
            result=player1name+" wins this round";
            player1score++;
        }else if (player1choice==""&&player2choice==""){
            result="please make a choice";

        }
        Toast.makeText(DualPlayerGame.this, result,Toast.LENGTH_SHORT).show();
        TextView player_1_score = (TextView) findViewById(R.id.player1_score);
        String player1scoreText = player1name+": "+ player1score;
        player_1_score.setText(player1scoreText);

        TextView player_2_score = (TextView) findViewById(R.id.player2_score);
        String player2scoreText = player2name+": "+ player2score;
        player_2_score.setText(player2scoreText);

        if(g==(n*2)){
            Toast.makeText(DualPlayerGame.this, "MATCH OVER.Click any image to continue",Toast.LENGTH_SHORT).show();

        }


    }

}
