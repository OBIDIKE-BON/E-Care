package com.stackfloat.e_care.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.stackfloat.e_care.R;
import com.stackfloat.e_care.Viewmodels.ProfileViewModel;
import com.stackfloat.e_care.Viewmodels.QuizzesViewModel;
import com.stackfloat.e_care.activities.QuestionsActivity;
import com.stackfloat.e_care.adapters.LessonsRecyclerAdapter;
import com.stackfloat.e_care.adapters.QuizzesRecyclerAdapter;

public class Quizzes_Fragment extends Fragment {

    private QuizzesRecyclerAdapter mQuizzesRecyclerAdapter;
    private RecyclerView mQuizzesRecyclerView;

    private QuizzesViewModel mQuizzesViewModel;

    public static Quizzes_Fragment newInstance() {
        return new Quizzes_Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.quizzes_fragment, container, false);
//        TextView textView = inflate.findViewById(R.id.testQuestion);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getContext(), QuestionsActivity.class));
//            }
//        });
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context = view.getContext();
        String[] lessonNames = context.getResources().getStringArray(R.array.lesson_names);
        mQuizzesRecyclerAdapter= new QuizzesRecyclerAdapter(context, lessonNames);
        mQuizzesRecyclerView= view.findViewById(R.id.rv_quizzes);
        AssetManager assets = context.getAssets();
//        assets.
        mQuizzesRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mQuizzesRecyclerView.setAdapter(mQuizzesRecyclerAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mQuizzesViewModel =new ViewModelProvider(this).get(QuizzesViewModel.class);
        // TODO: Use the ViewModel
    }

}
