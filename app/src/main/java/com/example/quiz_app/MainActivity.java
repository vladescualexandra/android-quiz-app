package com.example.quiz_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup vladescu_alexandra_main_rg_language;
    private RadioButton vladescu_alexandra_main_rb_language_italian;
    private RadioButton vladescu_alexandra_main_rb_language_spanish;
    private RadioButton vladescu_alexandra_main_rb_language_french;
    private Button vladescu_alexandra_main_btn_go;

    private static int key = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setComponents();

        vladescu_alexandra_main_btn_go.setOnClickListener(startQuizEvent());

    }

    private View.OnClickListener startQuizEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WordActivity.class);
                intent.putExtra(getString(R.string.vladescu_alexandra_language_key), String.valueOf(key));
                startActivity(intent);
                finish();
            }
        };
    }


    @SuppressLint("NonConstantResourceId")
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.vladescu_alexandra_main_rb_language_italian:
                if (checked) {
                    key = 1;
                }
                break;
            case R.id.vladescu_alexandra_main_rb_language_spanish:
                if (checked) {
                    key = 2;
                }
                break;
            case R.id.vladescu_alexandra_main_rb_language_french:
                if (checked) {
                    key = 3;
                }
                break;
        }
    }

    public void setComponents() {
        vladescu_alexandra_main_rg_language = findViewById(R.id.vladescu_alexandra_main_rg_language);
        vladescu_alexandra_main_rb_language_italian = findViewById(R.id.vladescu_alexandra_main_rb_language_italian);
        vladescu_alexandra_main_rb_language_spanish = findViewById(R.id.vladescu_alexandra_main_rb_language_spanish);
        vladescu_alexandra_main_rb_language_french = findViewById(R.id.vladescu_alexandra_main_rb_language_french);
        vladescu_alexandra_main_btn_go = findViewById(R.id.vladescu_alexandra_main_btn_go);
    }
}