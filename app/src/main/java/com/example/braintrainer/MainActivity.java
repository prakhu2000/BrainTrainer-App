package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

ArrayList<Integer> ans=new ArrayList<>();
    Button goButton;
    TextView sumTextView;
    int locationOfCorrectAns;
    TextView resultTextView;
    int score;
    int numberOfQues;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView scoreTextView;
    TextView timerTextView;
    Button playAgainButton;
    ConstraintLayout gameLayout;
    public void playAgain(View view){
score=0;
numberOfQues=0;
timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQues));
       playAgainButton.setVisibility(View.INVISIBLE);
       resultTextView.setText("");
        newQuestion();
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished / 1000)+"s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Done!");
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }.start();


    }
    public void chooseAnswer(View view){
        if(Integer.toString(locationOfCorrectAns).equals(view.getTag().toString())){
           resultTextView.setText("Correct! :)");
           score++;
        }
        else{
           resultTextView.setText("Wrong! :(");
        }
        numberOfQues++;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQues));
        newQuestion();
    }
    public void start(View view){
goButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.timerTextView));// doesnt matter whichever view we pass as we are not going to use it in play again method
    }
    public void newQuestion() {
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));
        locationOfCorrectAns = rand.nextInt(4);
        ans.clear();
        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAns)
                ans.add(a + b);
            else {
                int wrongAns = rand.nextInt(41);
                while (wrongAns == a + b) {
                    wrongAns = rand.nextInt(41);
                }
                ans.add(wrongAns);
            }
        }

        button0.setText(Integer.toString(ans.get(0)));
        button1.setText(Integer.toString(ans.get(1)));
        button2.setText(Integer.toString(ans.get(2)));
        button3.setText(Integer.toString(ans.get(3)));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sumTextView=findViewById(R.id.sumTextView);
        goButton=findViewById(R.id.startButton);
        resultTextView=findViewById(R.id.resultTextView);
         button0=findViewById(R.id.button0);
         button1=findViewById(R.id.button1);
         button2=findViewById(R.id.button2);
         button3=findViewById(R.id.button3);
        scoreTextView=findViewById(R.id.scoreTextView);
timerTextView=findViewById(R.id.timerTextView);
playAgainButton=findViewById(R.id.playAgainButton);
gameLayout=findViewById(R.id.gameLayout);
goButton=findViewById(R.id.startButton);
       goButton.setVisibility(View.VISIBLE);
       gameLayout.setVisibility(View.INVISIBLE);

    }
}