package com.example.melonderr.hostme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Restaurant_Search extends AppCompatActivity {
    //protected GeoDataClient mGeoDataClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant__search);

        EditText search_entry = findViewById(R.id.search);


        /*
        // Construct a GeoDataClient.
        mGeoDataClient = Places.getGeoDataClient(this, null);

        // Construct a PlaceDetectionClient.
        mPlaceDetectionClient = Places.getPlaceDetectionClient(this, null);

        // TODO: Start using the Places API.
        */
    }
}