package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DualPlayerResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_player_result);
        Button playagain =findViewById(R.id.playagain);
        Button gotohome =findViewById(R.id.gotohome);
        int player1score = getIntent().getIntExtra("player1score",0);
        int player2score = getIntent().getIntExtra("player2score",0);
       String player1name = getIntent().getStringExtra("player1name");
       String player2name = getIntent().getStringExtra("player2name");

        TextView finalscore=(TextView)findViewById(R.id.final_score);
        TextView finalresult=(TextView)findViewById(R.id.final_result);

        if(player1score>player2score){
            finalresult.setText(player1name+" WINS");
            finalscore.setText(player1name+":"+player1score+" "+player2name+ " :"+player2score);

        }else

        if(player2score>player1score){
            finalresult.setText(player2name+" WINS");
            finalscore.setText(player1name+":"+player1score+" "+player2name+ " :"+player2score);
        }else

        if(player2score==player1score){
            finalresult.setText(" DRAW");
            finalscore.setText(player1name+":"+player1score+" "+player2name+ " :"+player2score);
        }
        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playagain= new Intent(DualPlayerResult.this,DualPlayer.class);
                startActivity(playagain);
            }
        });
        gotohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotohome= new Intent(DualPlayerResult.this,MainActivity.class);
                startActivity(gotohome);
            }
        });
    }
}
