package com.example.resumie.CV;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.resumie.R;

import java.util.ArrayList;
import java.util.List;

public class CVFragment extends Fragment {

    RecyclerView recyclerView;
    CVAdapter cvAdapter;
    List<CVitem> items;


    public CVFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_cv);

        items=new ArrayList<>();
        items.add(new CVitem(getString(R.string.senior_web_developer),getString(R.string.text2)));
        items.add(new CVitem(getString(R.string.senior_web_developer),getString(R.string.text2)));
        items.add(new CVitem(getString(R.string.senior_web_developer),getString(R.string.text2)));
        items.add(new CVitem(getString(R.string.senior_web_developer),getString(R.string.text2)));
        items.add(new CVitem(getString(R.string.senior_web_developer),getString(R.string.text2)));

        cvAdapter=new CVAdapter(items);
        recyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        recyclerView.setAdapter(cvAdapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c_v, container, false);
    }
}