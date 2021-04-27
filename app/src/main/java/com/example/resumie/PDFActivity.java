package com.example.resumie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.resumie.SharedPrefManager.SharedPrefManager;

import java.io.File;
import java.io.FileOutputStream;

import static com.google.android.material.internal.ContextUtils.getActivity;
import static java.util.jar.Pack200.Packer.ERROR;

public class PDFActivity extends AppCompatActivity {

    private EditText name;
    private EditText designation;
    private EditText job;
    private EditText education;
    private EditText skill;
    private EditText project;
    private EditText profession;
    private EditText social;
    private EditText address;
    Button button;

    private SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_d_f);


        name = findViewById(R.id.name);
        designation=findViewById(R.id.designation);
        address = findViewById(R.id.address);
        social = findViewById(R.id.socials);
        job=findViewById(R.id.job_description);
        education=findViewById(R.id.edu_description);
        skill=findViewById(R.id.skill_description);
        project=findViewById(R.id.projects);
        profession=findViewById(R.id.profession);
        button=findViewById(R.id.pdfcreator1);

        sharedPrefManager = new SharedPrefManager(PDFActivity.this);

        name.setText(sharedPrefManager.getHomeData().getName());
//        designation.setText(sharedPrefManager.getHomeData().getDesignation());
//        selfdescription.setText(sharedPrefManager.getHomeData().getSelf());
//        edudescription.setText(sharedPrefManager.getHomeData().getEdu());
//        skilldescription.setText(sharedPrefManager.getHomeData().getSkill());
        
        
        
        
        ActivityCompat.requestPermissions(PDFActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                createMyPDF(view);
                Toast.makeText(getActivity(PDFActivity.this),"Created",Toast.LENGTH_SHORT).show();
            }

            public void createMyPDF (View view){

                PdfDocument myPdfDocument = new PdfDocument();
                PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();
                PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);

                Paint myPaint = new Paint();
                String myString = name.getText().toString();
                int x = 10, y = 25;

                for (String line : myString.split("\n")) {
                    myPage.getCanvas().drawText(line, x, y, myPaint);
                    y += myPaint.descent() - myPaint.ascent();
                }
                Paint myPaint1 = new Paint();
                String myString1 = designation.getText().toString();
                int x1 = 10, y1 = y+20;


                for (String line : myString1.split("\n")) {
                    myPage.getCanvas().drawText(line, x1, y1, myPaint1);
                    y1 += myPaint1.descent() - myPaint1.ascent();
                }
                Paint myPaint2 = new Paint();
                String myString2 = address.getText().toString();
                int x2 = 200, y2 = 25;



                for (String line : myString2.split("\n")) {
                    myPage.getCanvas().drawText(line, x2, y2, myPaint2);
                    y2 += myPaint2.descent() - myPaint2.ascent();
                }
                Paint myPaint3 = new Paint();
                String myString3 = social.getText().toString();
                int x3 = 180, y3 = 45;


                for (String line : myString3.split("\n")) {
                    myPage.getCanvas().drawText(line, x3, y3, myPaint3);
                    y3 += myPaint3.descent() - myPaint3.ascent();
                }

                Paint myPaint4 = new Paint();
                String myString4 = job.getText().toString();
                int x4 = 10, y4 = y1+40;


                for (String line : myString4.split("\n")) {
                    myPage.getCanvas().drawText(line, x4, y4, myPaint4);
                    y4 += myPaint4.descent() - myPaint4.ascent();
                }

                Paint myPaint5 = new Paint();
                String myString5 = education.getText().toString();
                int x5 = 10, y5 = y4+40;

                for (String line : myString5.split("\n")) {
                    myPage.getCanvas().drawText(line, x5, y5, myPaint5);
                    y5 += myPaint5.descent() - myPaint5.ascent();
                }

                Paint myPaint6 = new Paint();
                String myString6 = skill.getText().toString();
                int x6 = 10, y6 = y5+40;

                for (String line : myString6.split("\n")) {
                    myPage.getCanvas().drawText(line, x6, y6, myPaint6);
                    y6 += myPaint6.descent() - myPaint6.ascent();
                }


                Paint myPaint7 = new Paint();
                String myString7 = project.getText().toString();
                int x7 = 10, y7 = y6+40;

                for (String line : myString7.split("\n")) {
                    myPage.getCanvas().drawText(line, x7, y7, myPaint7);
                    y7 += myPaint7.descent() - myPaint7.ascent();
                }


                Paint myPaint8 = new Paint();
                String myString8 = profession.getText().toString();
                int x8 = 10, y8 = y7+40;

                for (String line : myString8.split("\n")) {
                    myPage.getCanvas().drawText(line, x8, y8, myPaint7);
                    y8+= myPaint8.descent() - myPaint8.ascent();
                }

                myPdfDocument.finishPage(myPage);

                String myFilePath = Environment.getExternalStorageDirectory().getPath() + '/'+myString+".pdf";
                File myFile = new File(myFilePath);
                try {
                    myPdfDocument.writeTo(new FileOutputStream(myFile));
                } catch (Exception e) {
                    e.printStackTrace();
                    name.setText("ERROR");
                    designation.setText("ERROR");
                }
                myPdfDocument.close();
            }
        });
    }
}