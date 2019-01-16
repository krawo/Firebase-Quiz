package com.example.krawo.firebasequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartingActivity extends AppCompatActivity {

    Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

    buttonStart = (Button) findViewById(R.id.buttonStart);
    buttonStart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(StartingActivity.this, MainActivity.class));
        }
    });

    }
}
