
package com.example.resumie.home;

import android.content.Context;
import android.os.Bundle;
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

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class HomeFragment extends Fragment {

    EditText name,designation,selfdescription,edudescription,skilldescription;
    TextView diffname,diffdesignation;
    Button button;

    // File modification (1) started here
    private SharedPrefManager sharedPrefManager;
    // File modification (1) ended here    

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        button=view.findViewById(R.id.button);
        name=view.findViewById(R.id.name);
        diffname=view.findViewById(R.id.diffname);
        designation=view.findViewById(R.id.designation);
        diffdesignation=view.findViewById(R.id.diffdesignation);
        selfdescription=view.findViewById(R.id.self_description);
        edudescription=view.findViewById(R.id.edu_description);
        skilldescription=view.findViewById(R.id.skill_description);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                update();
                Toast.makeText(getActivity(),"Saved", Toast.LENGTH_SHORT).show();
            }

            private void update() {
                name.setVisibility(GONE);
                edudescription.setVisibility(GONE);
                designation.setVisibility(GONE);
                skilldescription.setVisibility(GONE);
                selfdescription.setVisibility(GONE);
                button.setVisibility(GONE);
                diffname.setText(name.getText());
                diffname.setVisibility(VISIBLE);
                diffdesignation.setText(designation.getText());
                diffdesignation.setVisibility(VISIBLE);
                //more to add for other things as well.
            }
        });
        return view;
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
    
}
