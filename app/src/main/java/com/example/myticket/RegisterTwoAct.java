package com.example.myticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class RegisterTwoAct extends AppCompatActivity {

    LinearLayout btn_back;
    Button btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_two);

        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotosuccess = new Intent(RegisterTwoAct.this, SuccessRegisterAct.class);
                startActivity(gotosuccess);
            }
        });

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backtoprev = new Intent(RegisterTwoAct.this, RegisterOneAct.class);
                startActivity(backtoprev);
            }
        });
    }
}