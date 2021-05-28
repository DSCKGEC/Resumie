package com.example.resumie.CV;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.example.resumie.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CVFragment extends Fragment {

    RecyclerView recyclerView;
    CVAdapter cvAdapter;
    List<CVitem> items;
    FloatingActionButton fab;

    public CVFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_cv);
        items=new ArrayList<>();

        cvAdapter=new CVAdapter(items);
        recyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        recyclerView.setAdapter(cvAdapter);

        fab = (FloatingActionButton) view.findViewById(R.id.create_cv);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(getContext());
                View v = li.inflate(R.layout.layout_dialog_cv, null);

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());

                alertDialog.setTitle("Add Data");
                EditText title = v.findViewById(R.id.cv_edittext_title);
                EditText description = v.findViewById(R.id.cv_editview_description);
                alertDialog.setView(v);

                alertDialog.setPositiveButton("Add",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {

                                Gson gson = new Gson();
                                try {
                                    JSONObject jsonObject = new JSONObject();
                                    jsonObject.put("title", title.getText().toString());
                                    jsonObject.put("description", description.getText().toString());
                                    CVitem cVitem = gson.fromJson(String.valueOf(jsonObject), CVitem.class);
                                    items.add(cVitem);
                                    cvAdapter.notifyDataSetChanged();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                alertDialog.setNegativeButton("cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                dialog.cancel();
                            }
                        });
                alertDialog.show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c_v, container, false);
    }
}