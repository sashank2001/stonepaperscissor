package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DualPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_player);

        final EditText name1 = (EditText) findViewById(R.id.player_1_name) ;
        final EditText name2 = (EditText) findViewById(R.id.player_2_name) ;
        final EditText roundnumber = (EditText) findViewById(R.id.no_of_rounds) ;
        final Button playbutton = findViewById(R.id.play_button_id);

        playbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DualPlayerGame.class);
                if(!name1.getText().toString().isEmpty()){
                final String player1name = name1.getText().toString();
                    intent.putExtra("player1name", player1name);}
                else {
                    Toast.makeText(getApplicationContext(),"please enter PLAYER1 name",Toast.LENGTH_SHORT).show();}

                if(!name2.getText().toString().isEmpty()){
                    final String player2name = name2.getText().toString();
                    intent.putExtra("player2name", player2name);}
                else {
                    Toast.makeText(getApplicationContext(),"please enter PLAYER2 name",Toast.LENGTH_SHORT).show();}


                if(!roundnumber.getText().toString().isEmpty()){
                    final String rounds = roundnumber.getText().toString();
                    intent.putExtra("no. of rounds", rounds);}
                else {
                    Toast.makeText(getApplicationContext(),"please enter number of ROUNDS",Toast.LENGTH_SHORT).show();}

                if(!name1.getText().toString().isEmpty() && !name2.getText().toString().isEmpty() && !roundnumber.getText().toString().isEmpty())
                {startActivityForResult(intent, 0);}


            }
        });
    }
}
