package com.example.sgda3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int countQuest = 1;
    String[] tests;

    Resources resources;

    TextView theme;
    TextView quest;
    TextView numQuest;
    TextView numQuest1;
    RadioGroup varAnswers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resources = getResources();
        theme = findViewById(R.id.theme);
        quest = findViewById(R.id.quest);
        numQuest = findViewById(R.id.numQuest);
        numQuest1 = findViewById(R.id.numQuest1);
        varAnswers = findViewById(R.id.varAnswers);
        tests = resources.getStringArray(R.array.tests);

        theme.setText("Тест по теме: Математический анализ");
        numQuest.setText(("Вопрос #" + countQuest));
        quest.setText(tests[countQuest - 1]);
        numQuest1.setText((countQuest + "/" + tests.length / 5));

        for (int i = 0; i != varAnswers.getChildCount(); ++i){
            ((RadioButton)varAnswers.getChildAt(i)).setTextSize(1, 20);

            if(tests[i + 1].endsWith("+")) {
                ((RadioButton)varAnswers.getChildAt(i)).setText(tests[i + 1].substring(0, tests[i + 1].length() - 1));
                continue;
            }
            ((RadioButton)varAnswers.getChildAt(i)).setText(tests[i + 1]);
        }
    }

    public void onButton(View view) {
        //RadioButton.isChecked();

        //Смена ответа
        ++countQuest;

        if (countQuest < tests.length) {
            numQuest.setText(("Вопрос #" + countQuest));
            quest.setText(tests[(countQuest - 1) * 5]);
            numQuest1.setText((countQuest + "/" + tests.length / 5));

            for (int i = 0; i != varAnswers.getChildCount(); ++i) {
                if (tests[i + 1 + (countQuest - 1) * 5].endsWith("+")) {
                    ((RadioButton) varAnswers.getChildAt(i)).setText(tests[i + 1 + (countQuest - 1) * 5].substring(0, tests[i + 1 + (countQuest - 1) * 5].length() - 1));
                    continue;
                }
                ((RadioButton) varAnswers.getChildAt(i)).setText(tests[i + 1 + (countQuest - 1) * 5]);
            }
            return;
        }
    }
}