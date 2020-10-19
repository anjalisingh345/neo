package com.example.neotechhub;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Date;

public class EnquiryActivity extends AppCompatActivity {
    Button submit_btn;
    TextView camera;
    ImageView image;
    ImageView back_btn;
    int count=1;
    Spinner spinner;

    TextInputEditText dob;
    TextInputEditText name,surname,email,address,contact,gettoknow,gwnder,college;
Toolbar toolbar;

    DatePickerDialog.OnDateSetListener dt = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int Date) {

            dob.setText(String.format("" + year + ":" + (month + 1) + ":" + Date));

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        submit_btn = findViewById(R.id.submitbutton);

        toolbar = findViewById(R.id.toolbar_actionbar);
        back_btn = findViewById(R.id.back);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnquiryActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        camera = findViewById(R.id.photo);
        image = findViewById(R.id.img);
        dob = findViewById(R.id.edtdob);
        spinner = findViewById(R.id.spinner);

        String[] course = {"Course -", "Android", "Django", "Digital Marketing", "Web Development","Data Science"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(EnquiryActivity.this,
                android.R.layout.simple_spinner_item, course);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);




        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                new DatePickerDialog(
                        EnquiryActivity.this, dt, calendar.get(Calendar.DATE),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.YEAR)).show();
            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EnquiryActivity.this, Show_studentdata.class));
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(i3, count);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==1) {
            Bundle b = data.getExtras();
            Bitmap btp = (Bitmap) b.get("data");
            image.setImageBitmap(btp);

            count++;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    }

