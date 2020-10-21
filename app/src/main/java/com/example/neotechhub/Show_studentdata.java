package com.example.neotechhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Show_studentdata extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    String Url="https://anjaliandroid.000webhostapp.com/Neotech/showdata.php";

    RequestQueue requestQueue;

    final List<EnquiryModel> mydata=new ArrayList<>();
    RecyclerView rc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_studentdata);

        rc=findViewById(R.id.recycler);

        layoutManager=new LinearLayoutManager(Show_studentdata.this,LinearLayoutManager.VERTICAL,false);
        rc.setLayoutManager(layoutManager);


        //for getting place information
        requestQueue= Volley.newRequestQueue(Show_studentdata.this);
        JsonObjectRequest obj = new JsonObjectRequest(Request.Method.POST, Url,
                new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                JSONArray jsonArray = null;
                try {
                    jsonArray = response.getJSONArray("data");
                    for (int i =0; i<jsonArray.length();i++)
                    {
                        JSONObject obj =jsonArray.getJSONObject(i);
                        String name=obj.getString("name");
                        String surname=obj.getString("surname");
                        String email=obj.getString("email");
//                        String dob=obj.getString("dob");
//                        String gender=obj.getString("gender");
//                        String address=obj.getString("address");
                        String contact=obj.getString("contact");
                        String stream=obj.getString("stream");
                        String college=obj.getString("college");
                        String gettoknow=obj.getString("gettoknow");
                        String course=obj.getString("course");
                       // String img=obj.getString("image");

//                        Toast.makeText(Show_studentdata.this, name, Toast.LENGTH_SHORT).show();
                        EnquiryModel model = new EnquiryModel();
                        model.setName(name);
                        model.setSurname(surname);
                        model.setEmail(email);
//                        model.setDob(dob);
//                        model.setGender(gender);
//                        model.setAddress(address);
                        model.setContact(contact);
                        model.setStream(stream);
                        model.setCollege(college);
                        model.setGettoknow(gettoknow);
                       // model.setImage(img);
                        model.setCourse(course);



                        mydata.add(model);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Show_studentdata.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                Adapter adapter =new Adapter(Show_studentdata.this,mydata);
                rc.setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Show_studentdata.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("error",error.getMessage());


            }
        });
        requestQueue.add(obj);



    }

    public void Excel(View view) {
    }
}