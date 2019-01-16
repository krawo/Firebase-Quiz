package com.example.krawo.firebasequiz;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public long count = 5;

    private TextView mScoreView;
    private TextView mQuestion;

    private Button mButtonChoice1, mButtonChoice2,mButtonChoice3,mButtonChoice4, mButtonQuit;

    public int mScore = 0;
    private int mQuestionNumber = 0;
    private String mAnswer;

    private Firebase mQuestionCount, mQuestionRef, mchoice1Ref, mchoice2Ref,mchoice3Ref,mchoice4Ref, manswerRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestion = (TextView)findViewById(R.id.question);

        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);
        mButtonQuit = (Button) findViewById(R.id.quit);


        updateQuestions();

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice1.getText().equals(mAnswer)){
                    toastCorrect();
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestions();
                } else {
                    toastWrong();
                    updateQuestions();

                }
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice2.getText().equals(mAnswer)){
                    toastCorrect();
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestions();
                } else {
                    toastWrong();
                    updateQuestions();
                }
            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice3.getText().equals(mAnswer)){
                    toastCorrect();
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestions();
                } else {
                    toastWrong();
                    updateQuestions();
                }
            }
        });
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice4.getText().equals(mAnswer)){
                    toastCorrect();
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestions();
                } else {
                    toastWrong();
                    updateQuestions();
                }
            }
        });

        mButtonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, StartingActivity.class));
            }
        });


    }

    private void updateScore(int score){
        mScoreView.setText("" +mScore);
    }

    private void toastCorrect(){
        Toast correct = Toast.makeText(MainActivity.this, "Poprawna odpowiedź!", Toast.LENGTH_SHORT);
        correct.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
        correct.show();
    }
    private void toastWrong(){
        Toast wrong = Toast.makeText(MainActivity.this, "Niepoprawna odpowiedź!", Toast.LENGTH_SHORT);
        wrong.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
        wrong.show();
    }

    public void updateQuestions(){


        mQuestionCount = new Firebase("https://fir-quiz-793e6.firebaseio.com/");
        mQuestionCount.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                long count = dataSnapshot.getChildrenCount();


                if(count == mQuestionNumber-1) {

                    Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
                    intent.putExtra("wynik", mScore);
                    intent.putExtra("ilosc", count);
                    startActivity(intent);
                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        mQuestionRef = new Firebase("https://fir-quiz-793e6.firebaseio.com/"+mQuestionNumber +"/question");
        mQuestionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {




                String question  = dataSnapshot.getValue(String.class);
                mQuestion.setText(question);



            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mchoice1Ref = new Firebase("https://fir-quiz-793e6.firebaseio.com/"+mQuestionNumber + "/choice1");
        mchoice1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice1.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mchoice2Ref = new Firebase("https://fir-quiz-793e6.firebaseio.com/"+mQuestionNumber + "/choice2");
        mchoice2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice2.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mchoice3Ref = new Firebase("https://fir-quiz-793e6.firebaseio.com/"+mQuestionNumber + "/choice3");
        mchoice3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice3.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mchoice4Ref = new Firebase("https://fir-quiz-793e6.firebaseio.com/"+mQuestionNumber + "/choice4");
        mchoice4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice4.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        manswerRef = new Firebase("https://fir-quiz-793e6.firebaseio.com/"+mQuestionNumber + "/answer");
        manswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mAnswer = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mQuestionNumber++;

    }
}
