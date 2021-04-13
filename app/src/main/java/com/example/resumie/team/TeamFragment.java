package com.example.resumie.team;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.resumie.CV.CVAdapter;
import com.example.resumie.CV.CVitem;
import com.example.resumie.R;

import java.util.ArrayList;
import java.util.List;

public class TeamFragment extends Fragment {

    RecyclerView recyclerView;
    TeamAdapter teamAdapter;
    List<TeamItem> items;

    public TeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_team);
        items=new ArrayList<>();
        items.add(new TeamItem(getString(R.string.author_name),getString(R.string.author_description),R.drawable.user));
        items.add(new TeamItem(getString(R.string.author_name),getString(R.string.author_description),R.drawable.user));
        items.add(new TeamItem(getString(R.string.author_name),getString(R.string.author_description),R.drawable.user));
        items.add(new TeamItem(getString(R.string.author_name),getString(R.string.author_description),R.drawable.user));
        items.add(new TeamItem(getString(R.string.author_name),getString(R.string.author_description),R.drawable.user));
        items.add(new TeamItem(getString(R.string.author_name),getString(R.string.author_description),R.drawable.user));

        teamAdapter=new TeamAdapter(items);
        recyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        recyclerView.setAdapter(teamAdapter);
    }
    }
