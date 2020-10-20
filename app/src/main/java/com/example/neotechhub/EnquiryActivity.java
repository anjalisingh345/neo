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
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EnquiryActivity extends AppCompatActivity {
    Button submit_btn;
    TextView camera;
    ImageView image;
    ImageView back_btn;
    int count=1;
    Spinner spinner;
    RequestQueue requestQueue;
    TextInputEditText dob;
    ProgressBar progressBar;
    TextInputEditText name,surname,email,address,contact,gettoknow,gwnder,college;


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

        progressBar=findViewById(R.id.progressbar);
//        toolbar = findViewById(R.id.toolbar_actionbar);
//        back_btn = findViewById(R.id.back);
//        back_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(EnquiryActivity.this,MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });




        name=findViewById(R.id.edtname);



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
                insertdata();
//                startActivity(new Intent(EnquiryActivity.this, Show_studentdata.class));
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


    private void insertdata() {

        progressBar.setVisibility(View.VISIBLE);
        StringRequest request=new StringRequest(Request.Method.POST, EndPoints.registration_api, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(EnquiryActivity.this, response, Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EnquiryActivity.this,error.getMessage().toString(), Toast.LENGTH_SHORT).show();


                progressBar.setVisibility(View.GONE);
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String,String>();
                params.put("name",name.getText().toString());
                params.put("surname","singh");
                params.put("email","ns7444");
                params.put("contact","3223");
                params.put("stream","2322");
                params.put("college","36363");
                params.put("gettoknow","dhhdhd");
                params.put("course","djdjd");
                params.put("image","jdejdj");
                return params;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);



    }






}

