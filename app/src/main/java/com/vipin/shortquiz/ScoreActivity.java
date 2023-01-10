package com.vipin.shortquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private String score_text = "Score: ";
    private String correctAnswer_text = "Correct Answers- ";
    private String totalQuestions_text = "Total Questions- ";

    private Button backBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView scoreTV = findViewById(R.id.scoreTV);
        TextView correctAnswersTV = findViewById(R.id.correctAnswersTV);
        TextView totalQuestionsTV = findViewById(R.id.totalQuestionsTV);
        backBT = findViewById(R.id.backBT);

        int score, total_questions;
        Intent intent = getIntent();
        score = intent.getIntExtra("Score", 0);
        total_questions = intent.getIntExtra("OutOf", 0);
        correctAnswer_text = correctAnswer_text + score;
        totalQuestions_text = totalQuestions_text + total_questions;

        score = (score*100)/total_questions;
        score_text = score_text + score + "%";

        if (score <= 40){
            scoreTV.setTextColor(Color.RED);
        }else if (score <= 80){
            scoreTV.setTextColor(Color.BLUE);
        }else {
            scoreTV.setTextColor(Color.GREEN);
        }
        scoreTV.setText(score_text);
        correctAnswersTV.setText(correctAnswer_text);
        totalQuestionsTV.setText(totalQuestions_text);
    }

    @Override
    protected void onStart() {
        backBT.setOnClickListener(v -> {
            ScoreActivity.this.finish();
            startActivity(new Intent(ScoreActivity.this, MainActivity.class));
        });
        super.onStart();
    }
}