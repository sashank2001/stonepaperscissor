package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SinglePlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
        final EditText name = (EditText) findViewById(R.id.player_name) ;

        final EditText roundnumber = (EditText) findViewById(R.id.no_of_rounds) ;
        final Button playbutton = findViewById(R.id.play_button_id);

        playbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SinglePlayerGame.class);

                if(!name.getText().toString().isEmpty()){
                    final String playername = name.getText().toString();
                    intent.putExtra("playername", playername);}
                else {
                    Toast.makeText(getApplicationContext(),"please enter PLAYER name",Toast.LENGTH_SHORT).show();}

                if(!roundnumber.getText().toString().isEmpty()){
                    final String rounds = roundnumber.getText().toString();
                    intent.putExtra("no. of rounds", rounds);}
                else {
                    Toast.makeText(getApplicationContext(),"please enter number of ROUNDS",Toast.LENGTH_SHORT).show();}


           if(!name.getText().toString().isEmpty()&&!roundnumber.getText().toString().isEmpty())
           {startActivityForResult(intent, 0);}


            }
        });
    }
}
