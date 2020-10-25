package com.example.neotechhub;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
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
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class EnquiryActivity extends AppCompatActivity {
    ProgressDialog prgDialog;
   Bitmap bitmap;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
   String encodingimage;
   private static int REQUEST_IMAGE_CAPTURE = 1;
    private static String TIME_STAMP="null";
    Button submit_btn;

    ImageView camera;
    CircleImageView profile;
    ImageView back_btn;
    int count=1;
    Spinner spinner;
    RequestQueue requestQueue;
    TextInputEditText dob;
    ProgressBar progressBar;
    TextInputEditText name,surname,email,address,contact,gettoknow,gender,college,stream;





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
        surname = findViewById(R.id.edtsurname);
        email=findViewById(R.id.edtEmail);
        address = findViewById(R.id.edtaddress);
        contact=findViewById(R.id.edtmobile);
        college = findViewById(R.id.edtcollege);
        gettoknow=findViewById(R.id.edtgettoknow);
        stream = findViewById(R.id.edtstream);
        gender = findViewById(R.id.edtgender);



//        camera = findViewById(R.id.img);
//        profile = findViewById(R.id.profile);
        dob = findViewById(R.id.edtdob);
        spinner = findViewById(R.id.spinner);

        String[] course = {"Course -", "Android", "Django", "Digital Marketing", "Web Development","Data Science"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(EnquiryActivity.this,
                android.R.layout.simple_spinner_item, course);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);



        dob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                            Calendar cal = Calendar.getInstance();
                            int year = cal.get(Calendar.YEAR);
                            int month = cal.get(Calendar.MONTH);
                            int day = cal.get(Calendar.DAY_OF_MONTH);

                            DatePickerDialog dialog = new DatePickerDialog(
                                    EnquiryActivity.this,
                                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                                    mDateSetListener,
                                    year,month,day);
                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                            dialog.show();
                        }




                }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = month + "/" + day + "/" + year;
                dob.setText(date);
            }
        };


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertdata();
//                startActivity(new Intent(EnquiryActivity.this, Show_studentdata.class));
            }
        });

//        camera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // Intent i3 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                //startActivityForResult(i3, count);
//
//                Dexter.withContext(getApplicationContext())
//                        .withPermission(Manifest.permission.CAMERA)
//                        .withListener(new PermissionListener() {
//                            @Override
//                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
//
//                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                                startActivityForResult(intent,111);
//                            }
//
//                            @Override
//                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
//
//                            }
//
//                            @Override
//                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
//
//                                permissionToken.continuePermissionRequest();
//                            }
//                        }).check();
//            }
//        });

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//       if (requestCode==111 && resultCode == RESULT_OK) {
//
//           bitmap = (Bitmap)data.getExtras().get("data");
//           profile.setImageBitmap(bitmap);
//           encodebitmap(bitmap);
//       }
//      //      Bundle b = data.getExtras();
//        //    Bitmap btp = (Bitmap) b.get("data");
//          //  image.setImageBitmap(btp);
//
//            //count++;
//
//
//
//
//       super.onActivityResult(requestCode, resultCode, data);
//    }

//    private void encodebitmap(Bitmap bitmap) {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
//
//        byte[] byteofimages = byteArrayOutputStream.toByteArray();
//        encodingimage = android.util.Base64.encodeToString(byteofimages, Base64.DEFAULT);
//    }



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
//                Toast.makeText(EnquiryActivity.this,error
//                        .getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();

                progressBar.setVisibility(View.GONE);
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String,String>();
                params.put("action","addItem");
                params.put("name",name.getText().toString());
                params.put("surname",surname.getText().toString());
                params.put("email",email.getText().toString());
                params.put("dob",dob.getText().toString());
                params.put("address",address.getText().toString());
                params.put("contact",contact.getText().toString());
                params.put("stream",stream.getText().toString());
                params.put("college",college.getText().toString());
                params.put("gettoknow",gettoknow.getText().toString());
                params.put("gender",gender.getText().toString());
                params.put("course",spinner.getSelectedItem().toString());
              params.put("image","null");
                return params;
            }
        };

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);



    }






}

