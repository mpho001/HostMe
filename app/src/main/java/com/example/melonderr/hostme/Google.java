package com.example.melonderr.hostme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/**
 * Created by Melonderr on 11/17/17.
 */

public class Google extends AppCompatActivity implements
        GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener {

    private GoogleApiClient mGoogleApiClient;
    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "SignInActivity";
    // private TextView mStatusTextView;

    public static String googleEmail;
    public static String firstName;
    public static String lastName;
    public static int loggedIn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        findViewById(R.id.sign_in_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sign_in_button:
                Toast.makeText(getApplicationContext(),
                        "Sign In", Toast.LENGTH_SHORT).show();
                signIn();
                break;
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }

    public void signIn() {
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
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);

//        Intent intent = new Intent(this, Messaging.class);
//        startActivity(intent);

        // trying to get user information
        // GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        GoogleSignInAccount acct = result.getSignInAccount();
        if (acct != null) {
            googleEmail = acct.getEmail();
            firstName = acct.getGivenName();
            lastName = acct.getFamilyName();
            loggedIn = 1;
            Toast.makeText(this, googleEmail, Toast.LENGTH_SHORT).show();
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
//            findViewById(R.id.sign_in_button).setVisibility(View.GONE);
//            findViewById(R.id.sign_out_and_disconnect).setVisibility(View.VISIBLE);
//            findViewById(R.id.email).setVisibility(View.GONE);
//            findViewById(R.id.password).setVisibility(View.GONE);
        } else {
            // mStatusTextView.setText(R.string.signed_out);

        }
    }
}