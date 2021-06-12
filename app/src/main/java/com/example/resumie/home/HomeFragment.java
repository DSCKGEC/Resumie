
package com.example.resumie.home;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.resumie.R;
import com.example.resumie.SharedPrefManager.SharedPrefManager;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class HomeFragment extends Fragment {

    EditText name,designation,selfdescription,edudescription,skilldescription;
    Button button;
    public static final String TAG = "TAGHomeFragment";

    // File modification (1) started here
    private SharedPrefManager sharedPrefManager;
    // File modification (1) ended here    

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_home,container,false);
    }
    
    // File modification (2) started here
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name = view.findViewById(R.id.name);
        designation = view.findViewById(R.id.designation);
        selfdescription = view.findViewById(R.id.self_description);
        edudescription = view.findViewById(R.id.edu_description);
        skilldescription = view.findViewById(R.id.skill_description);

        Log.i(TAG, "onViewCreated: ");

        sharedPrefManager = new SharedPrefManager(getActivity());

        name.setText(sharedPrefManager.getHomeData().getName());
        designation.setText(sharedPrefManager.getHomeData().getDesignation());
        selfdescription.setText(sharedPrefManager.getHomeData().getSelf());
        edudescription.setText(sharedPrefManager.getHomeData().getEdu());
        skilldescription.setText(sharedPrefManager.getHomeData().getSkill());

        //as you don't have any button, then you can save the data, while editing
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedPrefManager.setHomeData(name.getText().toString().trim() , 1);
                //1 means name, you can use any other methods too
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
        designation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedPrefManager.setHomeData(designation.getText().toString().trim() , 2);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        selfdescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedPrefManager.setHomeData(selfdescription.getText().toString().trim() , 3);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edudescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedPrefManager.setHomeData(edudescription.getText().toString().trim() , 4);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        skilldescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sharedPrefManager.setHomeData(skilldescription.getText().toString().trim() , 5);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    // File modification (2) ended here


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
