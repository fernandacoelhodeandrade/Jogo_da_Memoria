package com.example.jogo_da_memoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GameActivity extends AppCompatActivity {

    private EditText answerEditText;
    private Button submitButton;

    private String sequence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        answerEditText = findViewById(R.id.answer_edittext);
        submitButton = findViewById(R.id.submit_button);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            sequence = extras.getString("sequence");
        }

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = answerEditText.getText().toString();
                if (answer.equals(sequence)) {
                    Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                    intent.putExtra("result", "Acertouuu!! :)");
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(GameActivity.this, ResultActivity.class);
                    intent.putExtra("result", "Poxa, você errou... :(");
                    startActivity(intent);
                }
            }
        });
    }
}



