package com.jhonnymoniz.lesson5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Question> questions = new ArrayList<>();
    TextView questionView = null;
    Button falseButton = null;
    Button trueButton = null;
    Button previousButton = null;
    Button nextButton = null;
    int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questions.add(new Question("Spiders are insects", false));
        questions.add(new Question("The Koala is type of bear", false));
        questions.add(new Question("O3  is oxygen  ", true));
        questions.add(new Question("The capital of South Korea is Seoul ", true));

        questionView = findViewById(R.id.question);
        falseButton = findViewById(R.id.falseButton);
        trueButton = findViewById(R.id.trueButton);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);

        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

        question(0);
    }

    public void onClick(View v) {
        if (v == falseButton) {
            checkQuestion(false);
        } else if (v == trueButton) {
            checkQuestion(true);
        } else if (v == previousButton) {
            question(-1);
        } else if (v == nextButton) {
            question(1);
        }
    }

    public void checkQuestion(boolean answer) {
        String result = questions.get(currentQuestion).answer() == answer ? "Correct" : "Incorrect";
        Toast msg = Toast.makeText(this, result, Toast.LENGTH_LONG);
        msg.show();
    }

    public void question(int inc) {
        int nextQuestion = currentQuestion + inc;
        if (nextQuestion >= 0 && nextQuestion < questions.size()) {
            currentQuestion = nextQuestion;
            questionView.setText(questions.get(currentQuestion).getQuestion());
        }

        previousButton.setEnabled(currentQuestion > 0);
        nextButton.setEnabled(currentQuestion < questions.size() - 1);
    }
}