package com.stackfloat.e_care.fragments;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.stackfloat.e_care.R;
import com.stackfloat.e_care.Viewmodels.LessonsViewModel;
import com.stackfloat.e_care.adapters.LessonsRecyclerAdapter;

public class Lessons_Fragment extends Fragment {

    private LessonsRecyclerAdapter mLessonsRecyclerAdapter;
    private RecyclerView mLessonsRecyclerView;

    private LessonsViewModel mLessonsViewModel;

    public static Lessons_Fragment newInstance() {
        return new Lessons_Fragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLessonsViewModel =new ViewModelProvider(this).get(LessonsViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lessons_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] lessonNames = view.getContext().getResources().getStringArray(R.array.lesson_names);
        mLessonsRecyclerAdapter= new LessonsRecyclerAdapter(  view.getContext(), lessonNames);
        mLessonsRecyclerView= view.findViewById(R.id.rv_lessons);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        AssetManager assets = view.getContext().getAssets();
//        assets.
        mLessonsRecyclerView.setLayoutManager(layoutManager);
        mLessonsRecyclerView.setAdapter(mLessonsRecyclerAdapter);
    }
}
