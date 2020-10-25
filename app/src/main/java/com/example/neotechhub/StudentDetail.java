package com.example.neotechhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StudentDetail extends AppCompatActivity {
TextView sdname,name,email,dob,gender,addresss,contact,stream,clg,gettokn,course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        sdname=findViewById(R.id.sdname);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        dob=findViewById(R.id.dob);
        addresss=findViewById(R.id.address);
        gender=findViewById(R.id.gender);
        contact=findViewById(R.id.contact);
        stream=findViewById(R.id.stream);
        gettokn=findViewById(R.id.gettoknow);
        clg=findViewById(R.id.college);
        course=findViewById(R.id.course);



        final String namest = getIntent().getExtras().getString("name","");
        final String surnamest = getIntent().getExtras().getString("surname","");
        final String emailst = getIntent().getExtras().getString("email","");
        final String genderst = getIntent().getExtras().getString("gender","");
        final String addressst = getIntent().getExtras().getString("address","");
        final String contactst = getIntent().getExtras().getString("contact","");
        final String streamst = getIntent().getExtras().getString("stream","");
        final String collegest = getIntent().getExtras().getString("college","");
        final String gettoknowst = getIntent().getExtras().getString("gettoknow","");
        final String coursest = getIntent().getExtras().getString("course","");
        final String imagest = getIntent().getExtras().getString("image","");
        final String dobst = getIntent().getExtras().getString("dob","");


        sdname.setText(namest+" "+surnamest);
        name.setText(namest+" "+surnamest);
        email.setText(emailst);
        dob.setText(dobst);
        gender.setText(genderst);
        addresss.setText(addressst);
        contact.setText(contactst);
        stream.setText(streamst);
        clg.setText(collegest);
        course.setText(coursest);
        gettokn.setText(gettoknowst);






    }
}