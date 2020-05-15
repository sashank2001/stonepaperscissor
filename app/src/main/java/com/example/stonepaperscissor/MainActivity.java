package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button dualplayers = findViewById(R.id.button2);
        final Button singleplayer = findViewById(R.id.button);

        dualplayers.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent dualPlayerIntent= new Intent(MainActivity.this,DualPlayer.class);
                startActivity(dualPlayerIntent);
            }
             });
        singleplayer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent singlePlayerIntent= new Intent(MainActivity.this,SinglePlayer.class);
                startActivity(singlePlayerIntent);
            }
        });
    }
}
