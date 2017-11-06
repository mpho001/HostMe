package com.example.melonderr.hostme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

//    GoogleApiClient.OnConnectionFailedListener,
//    View.OnClickListener

    // private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button b1 = findViewById(R.id.submit_button);

//        Button b = findViewById(R.id.google_sign_in);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),
//                        "launching signin!", Toast.LENGTH_SHORT).show();
//            }
//        });


//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditText e1 = findViewById(R.id.email);
//                EditText e2 = findViewById(R.id.password);
//                if (e1.getText().toString().equals("admin") &&
//                          e2.getText().toString().equals("admin"))
//                {
//                      Toast.makeText(getApplicationContext(),
//                              "Success!", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(getApplicationContext(),
//                              "Failure!", Toast.LENGTH_SHORT).show();
//                }
//    //                else{
//    //                    tx1.setVisibility(View.VISIBLE);
//    //                    tx1.setBackgroundColor(Color.RED);
//    //                    counter--;
//    //                    tx1.setText(Integer.toString(counter));
//    //
//    //                    if (counter == 0) {
//    //                        b1.setEnabled(false);
//    //                    }
//    //                }
//              }
//          });

    }


    public void userPage(View view) {
        EditText e1 = findViewById(R.id.email);
        EditText e2 = findViewById(R.id.password);
        if (e1.getText().toString().equals("admin") &&
                e2.getText().toString().equals("admin"))
        {
            Toast.makeText(getApplicationContext(),
                    "Success!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, User_Main_Page.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),
                    "Failure!", Toast.LENGTH_SHORT).show();
        }
    }

    // Called when user clicks register button
    public void registerPage(View view) {
        Toast.makeText(getApplicationContext(),
                "Register!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    public void searchPage(View view) {
        Toast.makeText(getApplicationContext(),
                "Search!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Restaurant_Search.class);
        startActivity(intent);
    }


    public void toGoogleSignIn(View view) {
        Toast.makeText(getApplicationContext(),
                "To Google!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, GoogleSignIn.class);
        startActivity(intent);
    }
}


//    class GoogleSignIn extends AppCompatActivity implements
//            GoogleApiClient.OnConnectionFailedListener, View.OnClickListener{
//        private GoogleApiClient mGoogleApiClient;
//        private TextView mStatusTextView;
//        private static final String TAG = "GoogleSignIn";
//        private static final int RC_SIGN_IN = 9001;
//
//
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState){
//            super.onCreate(savedInstanceState);
//            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                    .requestEmail()
//                    .build();
//
//
//            mGoogleApiClient = new GoogleApiClient.Builder(this)
//                    .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
//                    .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
//                    .build();
//
//            findViewById(R.id.sign_in_button).setOnClickListener(this);
//
//
//        }
//
//        // Button b1 = findViewById(R.id.submit_button);
//        // Button googleSignIn = findViewById(R.id.sign_in_button).setOnClickListener(this);
//
//
//        @Override
//        public void onActivityResult(int requestCode, int resultCode, Intent data) {
//            super.onActivityResult(requestCode, resultCode, data);
//
//            // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
//            if (requestCode == RC_SIGN_IN) {
//                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
//                handleSignInResult(result);
//            }
//        }
//
//        private void handleSignInResult(GoogleSignInResult result) {
//            Log.d(TAG, "handleSignInResult:" + result.isSuccess());
//            if (result.isSuccess()) {
//                // Signed in successfully, show authenticated UI.
//                GoogleSignInAccount acct = result.getSignInAccount();
//                // mStatusTextView.setText(getString(R.string.signed_in_fmt, acct.getDisplayName()));
//                updateUI(true);
//            } else {
//                // Signed out, show unauthenticated UI.
//                updateUI(false);
//            }
//        }
//
//        private void signIn() {
//            Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
//            startActivityForResult(signInIntent, RC_SIGN_IN);
//        }
//
//        private void updateUI(boolean signedIn) {
//            if (signedIn) {
//                findViewById(R.id.sign_in_button).setVisibility(View.GONE);
//                // findViewById(R.id.sign_out_and_disconnect).setVisibility(View.VISIBLE);
//            } else {
//                // mStatusTextView.setText(R.string.signed_out);
//
//                findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
//                // findViewById(R.id.sign_out_and_disconnect).setVisibility(View.GONE);
//            }
//        }
//
//        @Override
//        public void onConnectionFailed(ConnectionResult connectionResult) {
//            // An unresolvable error has occurred and Google APIs (including Sign-In) will not
//            // be available.
//            Log.d(TAG, "onConnectionFailed:" + connectionResult);
//        }
//
//        @Override
//        public void onClick(View v) {
//            Toast.makeText(getApplicationContext(),
//                    "Enters here!", Toast.LENGTH_SHORT).show();
//            switch (v.getId()) {
//                case R.id.sign_in_button:
//                    Toast.makeText(getApplicationContext(),
//                            "Google!", Toast.LENGTH_SHORT).show();
//                    signIn();
//                    break;
////                case R.id.sign_out_button:
////                    signOut();
////                    break;
////                case R.id.disconnect_button:
////                    revokeAccess();
////                    break;
//            }
//        }
//    }
