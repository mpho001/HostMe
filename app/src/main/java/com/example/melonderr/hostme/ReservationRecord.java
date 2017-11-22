package com.example.melonderr.hostme;
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

public class ReservationRecord extends AppCompatActivity {
    DatabaseHelper myDb;
    TextView Place,firster, dater, timer;
    public static String Phone_ = Reserve.Phoner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_record);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//=======================================================
//        ListView lv = (ListView) findViewById(R.id.lv1);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item1,data);
        myDb = new DatabaseHelper(this);
        Cursor res = myDb.getAllData();
        while(res.moveToNext())
        {
//            if(res.getString(2).equals(Phone_)
//            {
//
//            }
        }

//        private EditText _hour = null;
//        private EditText login_password = null;
//===============================
//        Button currentReservationBtn = findViewById(R.id.currentReservation);
//        currentReservationBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(ReservationRecord.this, currentReservation.class);
//                startActivity(i);
//            }
//        });
//
//        Button pastReservationBtn = findViewById(R.id.pastReservation);
//        pastReservationBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(ReservationRecord.this, pastReservation.class);
//                startActivity(i);
//            }
//        });
    }

}
