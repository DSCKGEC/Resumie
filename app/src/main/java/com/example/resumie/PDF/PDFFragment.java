package com.example.resumie.PDF;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.resumie.MainActivity;
import com.example.resumie.PDFActivity;
import com.example.resumie.R;

public class PDFFragment extends Fragment {

    private EditText myEditText;
    Button button;

    public PDFFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_p_d_f, container, false);
        button=view.findViewById(R.id.pdfcreator);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                makepdf();
                Toast.makeText(getActivity(),"Created", Toast.LENGTH_SHORT).show();
            }

            private void makepdf() {
                Intent i = new Intent(getActivity(), PDFActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });
        return view;
    }
}