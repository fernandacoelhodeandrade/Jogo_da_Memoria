package com.example.jogo_da_memoria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView sequenceTextView;
    private Button startButton;

    private String sequence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sequenceTextView = findViewById(R.id.sequence_textview);
        startButton = findViewById(R.id.start_button);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateSequence();
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("sequence", sequence);
                startActivity(intent);
            }
        });
    }

    private void generateSequence() {
        ArrayList<Character> characters = new ArrayList<>();
        for (char c = 'a'; c <= 'd'; c++) {
            characters.add(c);
        }
        Collections.shuffle(characters, new Random());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(characters.get(i));
        }

        sequence = sb.toString();
        sequenceTextView.setText("Sequência: " + sequence);
    }
}



