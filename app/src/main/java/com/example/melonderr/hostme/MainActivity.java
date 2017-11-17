package com.example.melonderr.hostme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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


public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener {

//    GoogleApiClient.OnConnectionFailedListener,
//    View.OnClickListener
    //----------------------login requirements--------------
    DatabaseHelper myDb;
    private EditText login_email = null;
    private EditText login_password = null;

    //------------------------------------------------------
    private GoogleApiClient mGoogleApiClient;
    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "SignInActivity";
    // private TextView mStatusTextView;
    public String googleEmail;
    Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //database for sign in ======================================
        myDb = new DatabaseHelper(this);
        login_email = (EditText) findViewById(R.id.email);
        login_password = (EditText) findViewById(R.id.password);
        btnSignIn=(Button) findViewById(R.id.signin_button);

        //============================================================
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        findViewById(R.id.sign_in_button).setOnClickListener(this);
        findViewById(R.id.sign_out_button).setOnClickListener(this);
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
//        Intent intent = new Intent(this, User_Main_Page.class);
//        startActivity(intent);
    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // [START_EXCLUDE]
                        updateUI(false);
                        // [END_EXCLUDE]
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }

    }

    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            // mStatusTextView.setText(getString(R.string.signed_in_fmt, acct.getDisplayName()));
            updateUI(true);
        } else {
            // Signed out, show unauthenticated UI.
            updateUI(false);
        }
//        Intent intent = new Intent(this, User_Main_Page.class);
//        startActivity(intent);

        Intent intent = new Intent(this, Messaging.class);
        startActivity(intent);

        // trying to get user information
        // GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        GoogleSignInAccount acct = result.getSignInAccount();
        if (acct != null) {
            googleEmail = acct.getEmail();
        }
        else {
            Toast.makeText(this, "acct was null", Toast.LENGTH_SHORT).show();
        }

//        Toast.makeText(getApplicationContext(),
//                googleEmail, Toast.LENGTH_SHORT).show();

        // TODO
        // if email doesn't exist in database, prompt user that account doesn't exist for app
        // and also return to main page
    }

    private void updateUI(boolean signedIn) {
        if (signedIn) {
            findViewById(R.id.sign_in_button).setVisibility(View.GONE);
            findViewById(R.id.sign_out_and_disconnect).setVisibility(View.VISIBLE);
            findViewById(R.id.email).setVisibility(View.GONE);
            findViewById(R.id.password).setVisibility(View.GONE);
        } else {
            // mStatusTextView.setText(R.string.signed_out);
            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
            findViewById(R.id.sign_out_and_disconnect).setVisibility(View.GONE);
            findViewById(R.id.email).setVisibility(View.VISIBLE);
            findViewById(R.id.password).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_in_button:
                Toast.makeText(getApplicationContext(),
                        "Sign In", Toast.LENGTH_SHORT).show();
                signIn();
                break;
            case R.id.sign_out_button:
                Toast.makeText(getApplicationContext(),
                        "Signing Out", Toast.LENGTH_SHORT).show();
                signOut();
                break;
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }


//    public void userPage(View view) {

        // Set On ClickListener
//        btnSignIn.setOnClickListener(new View.OnClickListener() {

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

                                 Intent i = new Intent(MainActivity.this, User_Main_Page.class);
                                 startActivity(i);
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
//         }
//        });
//             // fetch the Password form database for respective user name
//             String storedPassword=DatabaseHelper.getSinlgeEntry(userName);
//
//             // check if the Stored password matches with  Password entered by user
//             if(password.equals(storedPassword))
//             {
//                 Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
//                 dialog.dismiss();
//             }
//             else
//             {
//                 Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
//             }
//         }
//
//
//        {
//            Toast.makeText(getApplicationContext(),
//                    "Success!", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(this, User_Main_Page.class);
//            startActivity(intent);
//        }
//        else {
//            Toast.makeText(getApplicationContext(),
//                    "Failure!", Toast.LENGTH_SHORT).show();
//        }
//    }
    }

    // Called when user clicks register button
    public void registerPage(View view) {
        Toast.makeText(getApplicationContext(),
                "Register!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

//    //todo: erase after testing
//    public void DBTestPage(View view) {
//        Toast.makeText(getApplicationContext(),
//                "Registered!", Toast.LENGTH_SHORT).show();
//
//        Intent intent = new Intent(this, test_display_user_info.class);
//        startActivity(intent);
//    }


    public void toGoogleSignIn(View view) {
        Toast.makeText(getApplicationContext(),
                "To Google!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, GoogleSignIn.class);
        startActivity(intent);
    }
}

