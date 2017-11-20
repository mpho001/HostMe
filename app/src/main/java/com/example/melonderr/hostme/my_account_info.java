package com.example.melonderr.hostme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class my_account_info extends AppCompatActivity {
    Button sgnOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button changePasswordButton = findViewById(R.id.changePassword);
        changePasswordButton.setOnClickListener(new View.OnClickListener(){
          @Override
            public void onClick(View v){
              Intent i = new Intent(my_account_info.this, changePassword.class);
              startActivity(i);


                }
            });

        sgnOut = findViewById(R.id.signOut);

        sgnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Google.loggedIn == 1) {
                    Toast.makeText(getApplicationContext(), "signed out from Google", Toast.LENGTH_SHORT).show();
                    Google google = new Google();
                    google.option(2);
                    Intent intent = new Intent(getApplicationContext(), Google.class);
                    startActivity(intent);
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        /*
        Button deleteAccount = findViewById(R.id.deleteAccount);
        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                // if click Yes
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                // if click No
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(findViewById().getContext());
                builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();


            }
        });*/

    }
}

