package com.vipin.shortquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vipin.shortquiz.model.QuizModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView questionNo, question;
    private RadioGroup radioGroup;
    private RadioButton option1, option2, option3, option4;
    private String answer;
    private Button nextButton, skipButton;

    private int total_questions = 0;
    private int questionCount = 0;
    private int score = 0;


    private ArrayList<QuizModel> quizData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionNo = findViewById(R.id.questionNo);
        question = findViewById(R.id.question);
        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextButton = findViewById(R.id.nextButton);
        skipButton = findViewById(R.id.skipButton);

        try {
            quizData = QuizBank.load();
        }catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }finally {
            total_questions = quizData.size();
            if(total_questions > 0){
                setQuizData(questionCount);
            }
        }

    }

    private void setQuizData(int i) {
        radioGroup.clearCheck();
        if (i < total_questions) {
            if (i == total_questions-1){
                nextButton.setText(R.string.submit);
            }
            QuizModel data = quizData.get(i);
            question.setText(data.getQuestion());
            option1.setText(data.getOption1());
            option2.setText(data.getOption2());
            option3.setText(data.getOption3());
            option4.setText(data.getOption4());
            answer= data.getAnswer();

            String num = "Question "+ ++i +"/" + total_questions;
            questionNo.setText(num);
            questionCount++;
        }else {
            Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
            intent.putExtra("Score", score);
            intent.putExtra("OutOf", total_questions);
            MainActivity.this.finish();
            startActivity(intent);
        }
    }



    @Override
    protected void onStart() {

        skipButton.setOnClickListener(v -> setQuizData(questionCount));
        nextButton.setOnClickListener(v -> {
            if (option1.isChecked()) {
                if (answer.equals("Option1")) {
                    score++;
                }
                setQuizData(questionCount);
            }else if (option2.isChecked()) {
                if (answer.equals("Option2")) {
                    score++;
                }
                setQuizData(questionCount);
            }else if (option3.isChecked()) {
                if (answer.equals("Option3")) {
                    score++;
                }
                setQuizData(questionCount);
            }else if (option4.isChecked()) {
                if (answer.equals("Option4")) {
                    score++;
                }
                setQuizData(questionCount);
            }else {
                Toast.makeText(MainActivity.this, "Select Your Answer First!", Toast.LENGTH_SHORT).show();
            }

        });



        super.onStart();
    }
}