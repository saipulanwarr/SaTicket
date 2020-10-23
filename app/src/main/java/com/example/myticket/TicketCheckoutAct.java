package com.example.myticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TicketCheckoutAct extends AppCompatActivity {

    Button btn_buy_ticket, btnmines, btnplus;
    TextView textjumlahtiket, texttotalharga, textmybalance;
    Integer valueJumlahTiket = 1;
    Integer mybalance = 200;
    Integer valuetotalharga = 0;
    Integer valuehargatiket = 75;
    ImageView notice_uang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_checkout);

        btnmines = findViewById(R.id.btnmines);
        btnplus = findViewById(R.id.btnplus);
        textjumlahtiket = findViewById(R.id.textjumlahtiket);
        texttotalharga = findViewById(R.id.texttotalharga);
        textmybalance = findViewById(R.id.textmybalance);
        notice_uang = findViewById(R.id.notice_uang);

        textjumlahtiket.setText(valueJumlahTiket.toString());
        textmybalance.setText("US$ " + mybalance+"");

        valuetotalharga = valuehargatiket * valueJumlahTiket;
        texttotalharga.setText("US$ "+valuetotalharga+"");

        btnmines.animate().alpha(0).setDuration(300).start();
        btnmines.setEnabled(false);
        notice_uang.setVisibility(View.GONE);

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueJumlahTiket += 1;
                textjumlahtiket.setText(valueJumlahTiket.toString());

                if(valueJumlahTiket > 1){
                    btnmines.animate().alpha(1).setDuration(300).start();
                    btnmines.setEnabled(true);
                }

                valuetotalharga = valuehargatiket * valueJumlahTiket;
                texttotalharga.setText("US$ "+valuetotalharga+"");

                if(valuetotalharga > mybalance){
                    btn_buy_ticket.animate().translationY(250).alpha(0).setDuration(300).start();
                    btn_buy_ticket.setEnabled(false);
                    textmybalance.setTextColor(Color.parseColor("#D1206B"));
                    notice_uang.setVisibility(View.VISIBLE);
                }
            }
        });

        btnmines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueJumlahTiket -= 1;
                textjumlahtiket.setText(valueJumlahTiket.toString());

                if(valueJumlahTiket < 2){
                    btnmines.animate().alpha(0).setDuration(300).start();
                    btnmines.setEnabled(false);
                }

                valuetotalharga = valuehargatiket * valueJumlahTiket;
                texttotalharga.setText("US$ "+valuetotalharga+"");

                if(valuetotalharga < mybalance){
                    btn_buy_ticket.animate().translationY(0).alpha(1).setDuration(300).start();
                    btn_buy_ticket.setEnabled(true);
                    textmybalance.setTextColor(Color.parseColor("#203DD1"));
                    notice_uang.setVisibility(View.GONE);
                }
            }
        });

        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);
        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotosuccessticket = new Intent(TicketCheckoutAct.this, SuccessBuyTicketAct.class);
                startActivity(gotosuccessticket);
            }
        });
    }
}