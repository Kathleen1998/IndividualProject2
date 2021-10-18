package com.homework.individualproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class GameScreen extends AppCompatActivity {

    private final GameQuestions gameQuestions = new GameQuestions();
    private TextView amountEarned;
    private TextView theQuestions;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button confirmBtn;

    private String theAnswers;
    private int score = 0;
    private int qNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        amountEarned = findViewById(R.id.Score);
        theQuestions = findViewById(R.id.question);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        confirmBtn = findViewById(R.id.Confirmbutton);
        updateTheQuestion();

        confirmBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                //theAnswers = gameQuestions.getOptions2(int a);//some how needs to comb through the array | (int a)
                if (radioButton1.getText() == theAnswers){ // !== theAnswers - keeps showing same results
                    score = score + 1000;
                    updateTheScore(score);
                    updateTheQuestion();
                    Toast.makeText(GameScreen.this,"Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(GameScreen.this,"Wrong", Toast.LENGTH_SHORT).show();
                }
                if (radioButton2.getText() == theAnswers){
                    score = score + 1000;
                    updateTheScore(score);
                    updateTheQuestion();
                    Toast.makeText(GameScreen.this,"Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(GameScreen.this,"Wrong", Toast.LENGTH_SHORT).show();
                }
                if (radioButton3.getText() == theAnswers){
                    score = score + 1000;
                    updateTheScore(score);
                    updateTheQuestion();
                    Toast.makeText(GameScreen.this,"Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(GameScreen.this,"Wrong", Toast.LENGTH_SHORT).show();
                }
                if (radioButton4.getText() == theAnswers){
                    score = score + 1000;
                    updateTheScore(score);
                    updateTheQuestion();
                    Toast.makeText(GameScreen.this,"Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(GameScreen.this,"Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void updateTheQuestion()
    {
        theQuestions.setText(gameQuestions.getquestion(qNumber));
        radioButton1.setText(gameQuestions.getOptions1(qNumber));
        radioButton2.setText(gameQuestions.getOptions1(qNumber));
        radioButton3.setText(gameQuestions.getOptions1(qNumber));
        radioButton4.setText(gameQuestions.getOptions1(qNumber));

        theAnswers = gameQuestions.theRightAnswers(qNumber);
        qNumber++;
    }
    private void updateTheScore (int s)
    {
        amountEarned.setText(score);
    }

}