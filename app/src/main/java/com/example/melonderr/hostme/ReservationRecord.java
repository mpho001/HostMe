package com.example.melonderr.hostme;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.database.Cursor;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import java.util.ArrayList;

public class ReservationRecord extends AppCompatActivity {
    DatabaseHelper myDb;
    TextView zero,one,two,three,four ,five;
    TextView Place, firster, dater, timer;
    public static String Phone_ = Reserve.Phoner;
    public static String[] myArray = {"FirstName: " + Reserve.customer_first, "Last Name: " + Reserve.customer_last, "Restaurant Name:" + Reserve._restaurant, "Date: " + Reserve._ditto, "Time: " + Reserve._time, "Number of people: " + Reserve.pplDensity};
    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS

    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_record);
        zero= (TextView) findViewById(R.id.randomTextView);

        one= (TextView) findViewById(R.id.randomTextView1);

        two= (TextView) findViewById(R.id.randomTextView2);

        three= (TextView) findViewById(R.id.randomTextView3);

        four= (TextView) findViewById(R.id.randomTextView4);

        five= (TextView) findViewById(R.id.randomTextView5);


        zero.setText(myArray[0]);
        one.setText(myArray[1]);
        two.setText(myArray[2]);
        three.setText(myArray[3]);
        four.setText(myArray[4]);
        five.setText(myArray[5]);



    }
}