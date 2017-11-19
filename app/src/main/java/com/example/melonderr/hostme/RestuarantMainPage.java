package com.example.melonderr.hostme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RestuarantMainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restuarant_main_page);

        TextView displayRestaurantName = findViewById(R.id.restaurantName2);
        displayRestaurantName.setText(Restaurant_Search.name);

        //TextView displayRestaurantRating = findViewById(R.id.restaurantName2);
        //displayRestaurantName.setText(Restaurant_Search.rating);

        Button reviewButton = findViewById(R.id.reviews);
        reviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RestuarantMainPage.this, Review.class);
                startActivity(i);
            }
        });

        Button reserveButton = findViewById(R.id.reserve);
        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RestuarantMainPage.this, Reserve.class);
                startActivity(i);
            }
        });

        Button messagesButton = findViewById(R.id.message);
        messagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RestuarantMainPage.this, Messaging.class);
                startActivity(i);
            }
        });
    }
}
