package com.example.krawo.firebasequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {


    private Button buttonQuit;
    private TextView mScoreTextView;
    private TextView mScorePercentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        mScoreTextView = (TextView)findViewById(R.id.textViewScore);
        mScorePercentTextView = (TextView) findViewById(R.id.textViewPercent);
        buttonQuit = (Button) findViewById(R.id.buttonQuit);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int finalScore = bundle.getInt("wynik");
        long count = bundle.getLong("ilosc");


        //double procent = 100.0 *  finalScore/count; - tak też można, całkiem spoko

        double procent = ((double)finalScore/count)*100;


        mScoreTextView.setText(""+finalScore +"/"+count);
        mScorePercentTextView.setText(""+procent+"%` ");

        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SummaryActivity.this, StartingActivity.class));
            }
        });




    }
}
