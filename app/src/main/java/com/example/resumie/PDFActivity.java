package com.example.resumie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.resumie.SharedPrefManager.SharedPrefManager;

import java.io.File;
import java.io.FileOutputStream;

import static com.google.android.material.internal.ContextUtils.getActivity;
import static java.util.jar.Pack200.Packer.ERROR;

public class PDFActivity extends AppCompatActivity {

    private TextView name, designation, job, education, skill, project, profession;
    private EditText social , address;

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
        designation.setText(sharedPrefManager.getHomeData().getDesignation());
        job.setText(sharedPrefManager.getHomeData().getSelf());
        education.setText(sharedPrefManager.getHomeData().getEdu());
        skill.setText(sharedPrefManager.getHomeData().getSkill());
        
        
        
        
        ActivityCompat.requestPermissions(PDFActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE
                , Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                createMyPDF(view);
                Toast.makeText(getActivity(PDFActivity.this),"Created",Toast.LENGTH_SHORT).show();
            }

        });
    }



    public void createMyPDF (View view){

        String myString = sharedPrefManager.getHomeData().getName();


        PdfDocument myPdfDocument = new PdfDocument();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(500, 850, 1).create();
        PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);

        Paint paint = new Paint();
        Canvas canvas = myPage.getCanvas();


        //Setting UserName
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        paint.setTextSize(50f);
        paint.setColor(Color.CYAN);
        canvas.drawText(sharedPrefManager.getHomeData().getName().toUpperCase(),myPageInfo.getPageWidth()>>1,80,paint);


        //Setting Address
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        paint.setTextSize(30f);
        paint.setColor(Color.BLACK);
        canvas.drawText("Address",40,150,paint);


        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        paint.setTextSize(20f);
        paint.setColor(Color.BLACK);
        canvas.drawText(address.getText().toString(),40,190,paint);


        //Setting Social Handles
        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        paint.setTextSize(30f);
        paint.setColor(Color.BLACK);
        canvas.drawText("Social Handles",myPageInfo.getPageWidth() - 40,150,paint);


        paint.setTextAlign(Paint.Align.RIGHT);
        paint.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        paint.setTextSize(20f);
        paint.setColor(Color.BLACK);
        canvas.drawText(social.getText().toString(),myPageInfo.getPageWidth() - 40,190,paint);


        int y = 240 ;
        //Setting Job description
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        paint.setTextSize(30f);
        paint.setColor(Color.BLACK);
        canvas.drawText("Job descrption",40,y,paint);
        y+=30;


        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        paint.setTextSize(20f);
        paint.setColor(Color.BLACK);
        canvas.drawText(job.getText().toString(),40,y,paint);
        y+=60;



        //Setting Education
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        paint.setTextSize(30f);
        paint.setColor(Color.BLACK);
        canvas.drawText("Education",40,y,paint);
        y+=30;


        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        paint.setTextSize(20f);
        paint.setColor(Color.BLACK);
        canvas.drawText(address.getText().toString(),40,y,paint);
        y+=60;



        //Setting skills
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        paint.setTextSize(30f);
        paint.setColor(Color.BLACK);
        canvas.drawText("Skill",40,y,paint);
        y+=30;


        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        paint.setTextSize(20f);
        paint.setColor(Color.BLACK);
        canvas.drawText(skill.getText().toString(),40,y,paint);
        y+=60;


        //Setting Professional Experience
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        paint.setTextSize(30f);
        paint.setColor(Color.BLACK);
        canvas.drawText("Professional Experience",40,y,paint);
        y+=30;


        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        paint.setTextSize(20f);
        paint.setColor(Color.BLACK);
        canvas.drawText(profession.getText().toString(),40,y,paint);
        y+=60;


        //Setting projects
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT,Typeface.BOLD));
        paint.setTextSize(30f);
        paint.setColor(Color.BLACK);
        canvas.drawText("Projects",40,y,paint);
        y+=30;


        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        paint.setTextSize(20f);
        paint.setColor(Color.BLACK);
        canvas.drawText(project.getText().toString(),40,y,paint);
        y+=60;










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
}