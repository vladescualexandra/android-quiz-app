package com.example.quiz_app;

import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz_app.data.Word;
import com.example.quiz_app.data.Words;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.O)
public class WordActivity extends AppCompatActivity {

    private static String LANGUAGE_KEY;
    private static String LANGUAGE_NAME;

    ImageView vladescu_alexandra_word_iv_image;
    RadioGroup vladescu_alexandra_word_rg_options;
    RadioButton vladescu_alexandra_word_rb_option1;
    RadioButton vladescu_alexandra_word_rb_option2;
    RadioButton vladescu_alexandra_word_rb_option3;
    RadioButton vladescu_alexandra_word_rb_option4;
    Button vladescu_alexandra_word_btn_next;
    private static final int MAX_QUESTIONS = 5;
    private static ArrayList<Word> words;
    private static Words allWords = new Words();
    private static int counter = 1;
    private static int correctAnswers = 0;
    private static int right = 0;

    private Intent intent;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        counter = 1;
        correctAnswers = 0;

        setComponents();

        // SETTING THE LANGUAGE:
        LANGUAGE_KEY = getIntent().getStringExtra(getString(R.string.vladescu_alexandra_language_key));
        if (LANGUAGE_KEY != null) {
            switch (LANGUAGE_KEY) {
                case "2":
                    LANGUAGE_NAME = getString(R.string.vladescu_alexandra_language_spanish);
                    break;
                case "3":
                    LANGUAGE_NAME = getString(R.string.vladescu_alexandra_language_french);
                    break;
                default:
                    LANGUAGE_NAME = getString(R.string.vladescu_alexandra_language_italian);
                    break;
            }



            words = new ArrayList<>();
            setQuestions();

            right = newQuestion();
            vladescu_alexandra_word_btn_next.setOnClickListener(questionSetup());
        }
    }

    private void setQuestions() {
        Random rand = new Random();

        int i = 0;
        while (i<=5) {

            int index = rand.nextInt(allWords.getWords().size());
            if (!words.contains(allWords.getWords().get(index))) {
                words.add(allWords.getWords().get(index));
                i++;
            }
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
            Toast.makeText(getApplicationContext(),
                    getString(R.string.vladescu_alexandra_correct),
                    Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.vladescu_alexandra_wrong),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private View.OnClickListener questionSetup() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == 5) {
                    vladescu_alexandra_word_btn_next.setText(R.string.vladescu_alexandra_btn_finish);
                }
                if (counter <= MAX_QUESTIONS) {
                    checkIfCorrect(right);
                    newQuestion();
                } else {
                    checkIfCorrect(right);
                    endQuiz();
                }

            }
        };
    }

    private int newQuestion() {
        Word word = words.get(counter);

        String url = word.getUrl();
        int imageResource = getResources().getIdentifier(url, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        vladescu_alexandra_word_iv_image.setImageDrawable(res);

        counter++;

        right = setAnswers(word);

        return right;
    }

    private int randIndex(int i) {
        switch(i) {
            case 0:
                return 1;
            case 1:
                return 8;
            case 2:
                return 3;
            case 3:
                return 6;
        }
        return 2;
    }

    private int setAnswers(Word word) {

        Random rand = new Random();
        String[] answers = new String[4];
        int indexOfRightAnswer = rand.nextInt(4);
        List<Word> wrongAnswers = new ArrayList<>();


        switch (LANGUAGE_KEY) {
            case "1": // ITALIAN
                answers[indexOfRightAnswer] = word.getItalian();
                for (int i = 0; i < allWords.getWords().size(); i++) {
                    if (!allWords.getWords().get(i).equals(word.getItalian())) {
                        wrongAnswers.add(allWords.getWords().get(i));
                    }
                }


                for (int i = 0; i < 4; i++) {
                    if (i != indexOfRightAnswer) {
                        answers[i] = wrongAnswers.get(randIndex(i)).getItalian();
                    }
                }
                break;
            case "2": // SPANISH
                answers[indexOfRightAnswer] = word.getSpanish();

                for (int i = 0; i < allWords.getWords().size(); i++) {
                    if (!allWords.getWords().get(i).equals(word.getSpanish())) {
                        wrongAnswers.add(allWords.getWords().get(i));
                    }
                }

                for (int i = 0; i < 4; i++) {
                    if (i != indexOfRightAnswer) {
                        answers[i] = wrongAnswers.get(randIndex(i)).getSpanish();
                    }
                }
                break;
            case "3": // FRENCH
                answers[indexOfRightAnswer] = word.getFrench();

                for (int i = 0; i < allWords.getWords().size(); i++) {
                    if (!allWords.getWords().get(i).equals(word.getFrench())) {
                        wrongAnswers.add(allWords.getWords().get(i));
                    }
                }

                for (int i = 0; i < 4; i++) {
                    if (i != indexOfRightAnswer) {
                        answers[i] = wrongAnswers.get(randIndex(i)).getFrench();
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
        intent.putExtra(getString(R.string.vladescu_alexandra_correct_answers), String.valueOf(correctAnswers));
        intent.putExtra(getString(R.string.vladescu_alexandra_number_of_questions), String.valueOf(MAX_QUESTIONS));
        startActivity(intent);
        finish();
    }

    private void setComponents() {
        intent = getIntent();
        vladescu_alexandra_word_iv_image = findViewById(R.id.vladescu_alexandra_word_iv_image);
        vladescu_alexandra_word_rg_options = findViewById(R.id.vladescu_alexandra_word_rg_options);
        vladescu_alexandra_word_rb_option1 = findViewById(R.id.vladescu_alexandra_word_rb_option1);
        vladescu_alexandra_word_rb_option2 = findViewById(R.id.vladescu_alexandra_word_rb_option2);
        vladescu_alexandra_word_rb_option3 = findViewById(R.id.vladescu_alexandra_word_rb_option3);
        vladescu_alexandra_word_rb_option4 = findViewById(R.id.vladescu_alexandra_word_rb_option4);
        vladescu_alexandra_word_btn_next = findViewById(R.id.vladescu_alexandra_word_btn_next);
    }
}
