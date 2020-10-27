package com.example.quiz_app;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz_app.data.Word;
import com.example.quiz_app.data.Words;

import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.O)
public class WordActivity extends AppCompatActivity {

    private static String LANGUAGE_KEY;
    private static String LANGUAGE_NAME;

    TextView vladescu_alexandra_word_tv_word;
    ImageView vladescu_alexandra_word_iv_image;
    RadioGroup vladescu_alexandra_word_rg_options;
    RadioButton vladescu_alexandra_word_rb_option1;
    RadioButton vladescu_alexandra_word_rb_option2;
    RadioButton vladescu_alexandra_word_rb_option3;
    RadioButton vladescu_alexandra_word_rb_option4;
    Button vladescu_alexandra_word_btn_next;
    private static final int MAX_QUESTIONS = 5;
    private static final Words words = new Words();
    private static int counter = 1;
    private static int correctAnswers = 0;
    private static int right;

    private Intent intent;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);


        setComponents();

        // SETTING THE LANGUAGE:
        LANGUAGE_KEY = getIntent().getStringExtra("LANGUAGE_KEY");
        vladescu_alexandra_word_tv_word.append("Correct answers: ");
        if (LANGUAGE_KEY != null) {
            switch (LANGUAGE_KEY) {
                case "2":
                    LANGUAGE_NAME = "Spanish";
                    break;
                case "3":
                    LANGUAGE_NAME = "French";
                    break;
                default:
                    LANGUAGE_NAME = "Italian";
                    break;
            }

            right = newQuestion();
            vladescu_alexandra_word_btn_next.setOnClickListener(questionSetup());

        } else {
            Log.e("DEBUG", "LANGUAGE_KEY IS NULL!");
        }

    }

    private boolean checkIfCorrect(int rightAnswer) {
        RadioButton rb = null;
        switch (rightAnswer) {
            case 0:
                rb = vladescu_alexandra_word_rb_option1;
                break;
            case 1:
                rb = vladescu_alexandra_word_rb_option2;
                break;
            case 2:
                rb = vladescu_alexandra_word_rb_option3;
                break;
            case 3:
                rb = vladescu_alexandra_word_rb_option4;
                break;
        }

        if (rb.isChecked()) {
            correctAnswers++;
            return true;
        }
        else return false;
    }

    private View.OnClickListener questionSetup() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter <= MAX_QUESTIONS) {
                    checkIfCorrect(right);
                    newQuestion();
                } else {
                    checkIfCorrect(right);
                    vladescu_alexandra_word_btn_next.setText("Finish");
                    endQuiz();
                }

            }
        };
    }

    private int newQuestion() {
        Random rand = new Random();
        int index = rand.nextInt(26);
        Word word = words.getWords().get(index);

        String url = word.getUrl();
        int imageResource = getResources().getIdentifier(url, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        vladescu_alexandra_word_iv_image.setImageDrawable(res);
        counter++;

        right = setAnswers(word);
        vladescu_alexandra_word_tv_word.setText("Correct: " + correctAnswers);

        return right;
    }

    private int setAnswers(Word word) {

        Random rand = new Random();
        String[] answers = new String[4];
        int indexOfRightAnswer = rand.nextInt(4);

        switch (LANGUAGE_KEY) {
            case "1": // ITALIAN
                answers[indexOfRightAnswer] = word.getItalian();

                for (int i = 0; i < 4; i++) {
                    if (i != indexOfRightAnswer) {
                        answers[i] = words.getWords().get(rand.nextInt(words.getWords().size())).getItalian();
                    }
                }
                break;
            case "2": // SPANISH
                answers[indexOfRightAnswer] = word.getSpanish();

                for (int i = 0; i < 4; i++) {
                    if (i != indexOfRightAnswer) {
                        answers[i] = words.getWords().get(rand.nextInt(words.getWords().size())).getSpanish();
                    }
                }
                break;
            case "3": // FRENCH
                answers[indexOfRightAnswer] = word.getFrench();

                for (int i = 0; i < 4; i++) {
                    if (i != indexOfRightAnswer) {
                        answers[i] = words.getWords().get(rand.nextInt(words.getWords().size())).getFrench();
                    }
                }
                break;
        }

        vladescu_alexandra_word_rb_option1.setText(answers[0]);
        vladescu_alexandra_word_rb_option2.setText(answers[1]);
        vladescu_alexandra_word_rb_option3.setText(answers[2]);
        vladescu_alexandra_word_rb_option4.setText(answers[3]);

        return indexOfRightAnswer;
    }

    private void endQuiz() {
        // TODO endQuiz
        Intent intent = new Intent(getApplicationContext(), FinishActivity.class);
        intent.putExtra("CORRECT_ANSWERS", String.valueOf(correctAnswers));
        intent.putExtra("NUMBER_OF_QUESTIONS", String.valueOf(MAX_QUESTIONS));
        startActivity(intent);
        finish();
    }

    private void setComponents() {
        intent = getIntent();
        vladescu_alexandra_word_tv_word = findViewById(R.id.vladescu_alexandra_word_tv_word);
        vladescu_alexandra_word_iv_image = findViewById(R.id.vladescu_alexandra_word_iv_image);
        vladescu_alexandra_word_rg_options = findViewById(R.id.vladescu_alexandra_word_rg_options);
        vladescu_alexandra_word_rb_option1 = findViewById(R.id.vladescu_alexandra_word_rb_option1);
        vladescu_alexandra_word_rb_option2 = findViewById(R.id.vladescu_alexandra_word_rb_option2);
        vladescu_alexandra_word_rb_option3 = findViewById(R.id.vladescu_alexandra_word_rb_option3);
        vladescu_alexandra_word_rb_option4 = findViewById(R.id.vladescu_alexandra_word_rb_option4);
        vladescu_alexandra_word_btn_next = findViewById(R.id.vladescu_alexandra_word_btn_next);
    }
}
