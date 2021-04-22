package com.example.resumie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

import static com.google.android.material.internal.ContextUtils.getActivity;
import static java.util.jar.Pack200.Packer.ERROR;

public class PDFActivity extends AppCompatActivity {

    private EditText myEditText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_d_f);


        myEditText = findViewById(R.id.TestText1);
        button=findViewById(R.id.pdfcreator1);
        ActivityCompat.requestPermissions(PDFActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

    button.setOnClickListener(new View.OnClickListener() {
        @SuppressLint("RestrictedApi")
        @Override
            public void onClick(View v) {
                createMyPDF(button);
            Toast.makeText(getActivity(PDFActivity.this),"Created",Toast.LENGTH_SHORT).show();
            }

            public void createMyPDF (Button button){

                PdfDocument myPdfDocument = new PdfDocument();
                PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();
                PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);

                Paint myPaint = new Paint();
                String myString = myEditText.getText().toString();
                int x = 10, y = 25;

                for (String line : myString.split("\n")) {
                    myPage.getCanvas().drawText(line, x, y, myPaint);
                    y += myPaint.descent() - myPaint.ascent();
                }

                myPdfDocument.finishPage(myPage);

                String myFilePath = Environment.getExternalStorageDirectory().getPath() + "/Resume.pdf";
                File myFile = new File(myFilePath);
                try {
                    myPdfDocument.writeTo(new FileOutputStream(myFile));
                } catch (Exception e) {
                    e.printStackTrace();
                    myEditText.setText("ERROR");
                }
                myPdfDocument.close();
            }
    });
    }
}