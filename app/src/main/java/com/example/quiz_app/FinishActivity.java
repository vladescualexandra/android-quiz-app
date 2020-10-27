package com.example.quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz_app.R;


public class FinishActivity extends AppCompatActivity {

    public static String CORRECT_ANSWERS;
    public static String NUMBER_OF_QUESTIONS;
    private Intent intent;
    private TextView vladescu_alexandra_finish_tv_result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        intent = getIntent();
        vladescu_alexandra_finish_tv_result = findViewById(R.id.vladescu_alexandra_finish_tv_result);
        CORRECT_ANSWERS = intent.getStringExtra("CORRECT_ANSWERS");
        NUMBER_OF_QUESTIONS = intent.getStringExtra("NUMBER_OF_QUESTIONS");


        String result = CORRECT_ANSWERS + "/" + NUMBER_OF_QUESTIONS;

        vladescu_alexandra_finish_tv_result.setText(result);


    }
}
