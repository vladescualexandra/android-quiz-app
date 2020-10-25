package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView vladescu_alexandra_main_tv_welcome_text;
    RadioGroup vladescu_alexandra_main_rg_language;
    RadioButton vladescu_alexandra_main_rb_language_italian;
    RadioButton vladescu_alexandra_main_rb_language_spanish;
    RadioButton vladescu_alexandra_main_rb_language_french;
    Button vladescu_alexandra_main_btn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setComponents();


    }

    public void setComponents() {
         vladescu_alexandra_main_tv_welcome_text = findViewById(R.id.vladescu_alexandra_main_tv_welcome_text);
         vladescu_alexandra_main_rg_language = findViewById(R.id.vladescu_alexandra_main_rg_language);
         vladescu_alexandra_main_rb_language_italian = findViewById(R.id.vladescu_alexandra_main_rb_language_italian);
         vladescu_alexandra_main_rb_language_spanish = findViewById(R.id.vladescu_alexandra_main_rb_language_spanish);
         vladescu_alexandra_main_rb_language_french = findViewById(R.id.vladescu_alexandra_main_rb_language_french);
         vladescu_alexandra_main_btn_go = findViewById(R.id.vladescu_alexandra_main_btn_go);
    }

    @SuppressLint("NonConstantResourceId")
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String language = "x";
        
        switch (view.getId()) {
            case R.id.vladescu_alexandra_main_rb_language_italian:
                if (checked) {
                    // TODO set Italian
                    language = "Italian"; // just debug
                }
                break;
            case R.id.vladescu_alexandra_main_rb_language_spanish:
                if (checked) {
                    // TODO set Spanish
                    language = "Spanish"; // just debug
                }
                break;
            case R.id.vladescu_alexandra_main_rb_language_french:
                if (checked) {
                    // TODO set French
                    language = "French"; // just debug
                }
                break;
        }

        
        // TEST
        Toast.makeText(getApplicationContext(),
                language, 
                Toast.LENGTH_LONG).show();
        
    }
    
    
}