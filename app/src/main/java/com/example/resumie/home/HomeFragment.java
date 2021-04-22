
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
//        button=view.findViewById(R.id.pdfcreatorbutton);
//        name=view.findViewById(R.id.name);
//        diffname=view.findViewById(R.id.diffname);
//        designation=view.findViewById(R.id.designation);
//        diffdesignation=view.findViewById(R.id.diffdesignation);
//        selfdescription=view.findViewById(R.id.self_description);
//        edudescription=view.findViewById(R.id.edu_description);
//        skilldescription=view.findViewById(R.id.skill_description);
//
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                update();
//                Toast.makeText(getActivity(),"Saved", Toast.LENGTH_SHORT).show();
//            }
//
//            private void update() {
//                name.setVisibility(GONE);
//                edudescription.setVisibility(GONE);
//                designation.setVisibility(GONE);
//                skilldescription.setVisibility(GONE);
//                selfdescription.setVisibility(GONE);
//                button.setVisibility(GONE);
//                diffname.setText(name.getText());
//                diffname.setVisibility(VISIBLE);
//                diffdesignation.setText(designation.getText());
//                diffdesignation.setVisibility(VISIBLE);
//                //more to add for other things as well.
//            }
//        });
        return view;
    }
}