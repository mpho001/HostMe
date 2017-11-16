package com.example.melonderr.hostme;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class Restaurant_Search extends AppCompatActivity {

    int PLACE_PICKER_REQUEST = 1;
    public CharSequence name;
    public CharSequence phone;
    public CharSequence rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant__search);

        PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
        try {
            final Intent intent = intentBuilder.build(this);
            startActivityForResult(intentBuilder.build(this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLACE_PICKER_REQUEST && resultCode == RESULT_OK) {
            Place place = PlacePicker.getPlace(data, this);

            name = place.getName();
            phone = place.getPhoneNumber();
            float rating = place.getRating();

            String toastMsg = String.format("Place: %s", name);
            Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
        }
    }
}