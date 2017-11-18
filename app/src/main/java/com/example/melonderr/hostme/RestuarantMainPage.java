package com.example.melonderr.hostme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RestuarantMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restuarant_main_page);

        Button accountBtn = findViewById(R.id.reviews);
        accountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RestuarantMainPage.this, Review.class);
                startActivity(i);
            }
        });

        Button reservationButton = findViewById(R.id.reserve);
        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RestuarantMainPage.this, Reserve.class);
                startActivity(i);
            }
        });
    }
}
