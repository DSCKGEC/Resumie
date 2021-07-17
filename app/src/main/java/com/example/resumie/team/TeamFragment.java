package com.example.resumie.team;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.resumie.CV.CVAdapter;
import com.example.resumie.CV.CVitem;
import com.example.resumie.R;

import java.util.ArrayList;
import java.util.List;

public class TeamFragment extends Fragment {

    public static final String TAG = "TAGTeamFragment";
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
        Log.i(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_team, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.i(TAG, "onViewCreated: ");

        recyclerView = view.findViewById(R.id.recyclerview_team);
        items=new ArrayList<>();
        items.add(new TeamItem(getString(R.string.Adrishyantee),getString(R.string.Adridescription),R.drawable.adri));
        items.add(new TeamItem("Mahmood Ahmad","Simply an Android nerd",R.drawable.download));
        items.add(new TeamItem("Chirag Ghosh","Fixed the colour scheme and fixed the PDF activity",R.drawable.chirag));
        teamAdapter=new TeamAdapter(items);
        recyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        recyclerView.setAdapter(teamAdapter);
    }


    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");

    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");


        TransitionInflater inflater = TransitionInflater.from(requireContext());
        setExitTransition(inflater.inflateTransition(R.transition.fade));

        TransitionInflater inflater1 = TransitionInflater.from(requireContext());
        setEnterTransition(inflater1.inflateTransition(R.transition.slide_right));
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: ");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i(TAG, "onViewStateRestored: ");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState: ");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: ");
    }
}
