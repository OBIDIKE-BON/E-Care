package com.stackfloat.e_care.activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.stackfloat.e_care.QuestionUtils;
import com.stackfloat.e_care.QuestionsArray;
import com.stackfloat.e_care.R;
import com.stackfloat.e_care.adapters.QuestionsRecyclerAdapter;

public class QuestionsActivity extends AppCompatActivity {

    private static final int QUESTION_NOT_SET = -1;
    public static final String QUESTIONS_INDEX = "com.stackfloat.e_care.QUESTIONS_INDEX";
    private QuestionUtils mQuestionUtils;
    private QuestionsRecyclerAdapter mQuestionsRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initDiplayContent();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initDiplayContent() {
        Intent intent = getIntent();
        int questionsIndex = intent.getIntExtra(QUESTIONS_INDEX, QUESTION_NOT_SET);
        mQuestionUtils = new QuestionUtils();
        String[][] questions = getQuestions(questionsIndex);
        if (questions != null)
            mQuestionsRecyclerAdapter = new QuestionsRecyclerAdapter(this, questions);
        RecyclerView questionsRecyclerView = findViewById(R.id.rv_questions);
        questionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        questionsRecyclerView.setAdapter(mQuestionsRecyclerAdapter);
    }

    private String[][] getQuestions(int questionsIndex) {
        return mQuestionUtils.getQuestionsAtIndex(questionsIndex);
    }
}