package com.example.melonderr.hostme;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    GoogleApiClient.OnConnectionFailedListener,
//    View.OnClickListener
    //----------------------login requirements--------------
    DatabaseHelper myDb;
    private EditText login_email = null;
    private EditText login_password = null;
    public static String LoggedUser;
         //------------------------------------------------------
    private GoogleApiClient mGoogleApiClient;
    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "SignInActivity";
    // private TextView mStatusTextView;
    public String googleEmail;
    Button btnSignIn;
    // public static String loggedEmail;
    public static String firstName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Registration reg = new Registration(MainActivity.this);

        //database for sign in ======================================
        myDb = new DatabaseHelper(this);
        login_email = (EditText) findViewById(R.id.email);
        login_password = (EditText) findViewById(R.id.password);
        btnSignIn=(Button) findViewById(R.id.signin_button);

        findViewById(R.id.sign_in_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_in_button:
                Toast.makeText(getApplicationContext(),
                        "Sign In", Toast.LENGTH_SHORT).show();
                // signIn();
                Google google = new Google();
                google.option(1);
                google.setPage(1);
                Intent intent = new Intent(getApplicationContext(), Google.class);
                startActivity(intent);
                break;
        }
    }

     public void userPage(View v) {
         // get The User name and Password
         if((login_email.getText().toString().equals("")))
         {
             login_email.setError("Email is blank");
//                 Toast.makeText(MainActivity.this,"Email is blank",Toast.LENGTH_LONG).show();
         }
         if((login_password.getText().toString().equals("")))
         {
             login_password.setError("Password is blank");
//                 Toast.makeText(MainActivity.this,"Password is blank",Toast.LENGTH_LONG).show();
         }
         else
         {
             Cursor res = myDb.getAllData();
             if(res.getCount() == 0)
             {
                 Toast.makeText(getApplicationContext(),
                "Failure!", Toast.LENGTH_SHORT).show();
                 return;
             }
             else
             {
                 int flag = 0;
                 while (res.moveToNext())
                 {
                     //Toast.makeText(MainActivity.this,res.getString(4),Toast.LENGTH_SHORT).show();
                     if(res.getString(4).equals(login_email.getText().toString()))
                     {
                         if(res.getString(5).equals(login_password.getText().toString()))
                         {
                             LoggedUser = login_email.getText().toString();
                             firstName = res.getString(1);
                             // Toast.makeText(getApplicationContext(), firstName, Toast.LENGTH_SHORT).show();
                             Intent i = new Intent(MainActivity.this, User_Main_Page.class);
                             startActivity(i);
                             // loggedEmail = res.getString(4);
//                                 Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
                         }
                         else
                         {
                             login_password.setError("Password is incorrect");
//                                 Toast.makeText(MainActivity.this,"Password is incorrect",Toast.LENGTH_LONG).show();
                         }
                         flag =1;
                     }
                 }
                 if(flag != 1) {
                     login_email.setError("Email not found");
                 }
//                     Toast.makeText(MainActivity.this,"Email not found",Toast.LENGTH_LONG).show();
                 //Toast.makeText(MainActivity.this,login_email.getText().toString(),Toast.LENGTH_LONG).show();
             }
         }
    }

    // Called when user clicks register button
    public void registerPage(View view) {
        Toast.makeText(getApplicationContext(),
                "Register!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    public void toGoogleSignIn(View view) {
        Toast.makeText(getApplicationContext(),
                "To Google!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, GoogleSignIn.class);
        startActivity(intent);
    }
}

