package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SinglePlayerResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_result);
        Button playagain =findViewById(R.id.playagain);
        Button gotohome =findViewById(R.id.gotohome);
        int playerscore = getIntent().getIntExtra("playerscore",0);
        int computerscore = getIntent().getIntExtra("computerscore",0);

        TextView finalscore=(TextView)findViewById(R.id.final_score);
        TextView finalresult=(TextView)findViewById(R.id.final_result);

        if(playerscore>computerscore){
            finalresult.setText("YOU WIN");
            finalscore.setText("COMPUTER:"+computerscore+" YOU:"+playerscore);
            LinearLayout bg = (LinearLayout) findViewById(R.id.container);
            bg.setBackgroundColor(Color.GREEN);

        }else
        if(computerscore>playerscore){
            finalresult.setText("YOU LOSE");
            finalscore.setText("COMPUTER:"+computerscore+" YOU:"+playerscore);
            LinearLayout bg = (LinearLayout) findViewById(R.id.container);
            bg.setBackgroundColor(Color.RED);

        }
        else
        if(computerscore==playerscore){
            finalresult.setText("DRAW");
            finalscore.setText("COMPUTER:"+computerscore+" YOU:"+playerscore);

        }
        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playagain= new Intent(SinglePlayerResult.this,SinglePlayer.class);
                startActivity(playagain);
            }
        });
        gotohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotohome= new Intent(SinglePlayerResult.this,MainActivity.class);
                startActivity(gotohome);
            }
        });
    }
}
