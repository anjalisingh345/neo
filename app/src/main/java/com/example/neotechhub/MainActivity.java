package com.example.neotechhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button data_btn,Eq_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data_btn = findViewById(R.id.databtn);
        Eq_btn = findViewById(R.id.enqiry);

        Eq_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,EnquiryActivity.class));

            }
        });
    }


    public void LoginWithEmail(View view) {
    }
}