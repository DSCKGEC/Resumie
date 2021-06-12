package com.example.resumie.CV;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.EditText;
import android.widget.Toast;

import com.example.resumie.R;
import com.example.resumie.SharedPrefManager.SharedPrefManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CVFragment extends Fragment {

    private static final String TAG = "TAGCVFragment";
    RecyclerView recyclerView;
    CVAdapter cvAdapter;
    ArrayList<CVitem> items;
    FloatingActionButton fab;

    SharedPrefManager sharedPrefManager;

    public CVFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerview_cv);
        items=new ArrayList<>();

        Log.i(TAG, "onViewCreated: ");

        sharedPrefManager = new SharedPrefManager(getActivity());
        addingCVItems();

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
                                    items.add(items.size(), cVitem);
                                    cvAdapter.notifyItemInserted(items.size());


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
        Log.i(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_c_v, container, false);
    }



    private void addingCVItems() {

        if(sharedPrefManager.getUserPortFolio() == null){
            items.add(new CVitem("Your Experience Heading","Describe your experience here"));
            return;
        }


        items = sharedPrefManager.getUserPortFolio();
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
        sharedPrefManager.setUserPortfolio(items);
        //Toast.makeText(getActivity(),"Saved "+ items.size() ,Toast.LENGTH_SHORT).show();
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
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
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