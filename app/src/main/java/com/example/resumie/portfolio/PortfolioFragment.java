package com.example.resumie.portfolio;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resumie.R;
import com.example.resumie.SharedPrefManager.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

public class PortfolioFragment extends Fragment implements PortfolioCallback {

    private static final String TAG = "TAGPortfolioFragment";
    public List<PortfolioItem> mdata;
    RecyclerView recyclerView;
    PortfolioAdapter portfolioAdapter;
    EditText editText;
    private SharedPrefManager sharedPrefManager;

    public PortfolioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_portfolio);
        editText = view.findViewById(R.id.textView13);
        Log.i(TAG, "onViewCreated: ");

        sharedPrefManager = new SharedPrefManager(getActivity());

        editText.setText(sharedPrefManager.getUserIntro());


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedPrefManager.setUserIntro(editText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mdata = new ArrayList<>();
        mdata.add(new PortfolioItem(R.drawable.astro));
        mdata.add(new PortfolioItem(R.drawable.astro));
        mdata.add(new PortfolioItem(R.drawable.astro));
        mdata.add(new PortfolioItem(R.drawable.astro));
        mdata.add(new PortfolioItem(R.drawable.astro));
        mdata.add(new PortfolioItem(R.drawable.astro));


        portfolioAdapter = new PortfolioAdapter(mdata, this);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(portfolioAdapter);
    }

    @Override
    public void onPortfolioItemClick(int pos) {


        PortfolioDetailsFragment portfolioDetailsFragment =
                new PortfolioDetailsFragment();


        Bundle bundle = new Bundle();
        bundle.putSerializable("object", mdata.get(pos));
        portfolioDetailsFragment.setArguments(bundle);

        portfolioDetailsFragment.show(getActivity().getSupportFragmentManager(), "tagname");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
        sharedPrefManager.setUserIntro(editText.getText().toString());

    }

    @Override
    public void onDestroy() {
        sharedPrefManager.setUserIntro(editText.getText().toString());
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
