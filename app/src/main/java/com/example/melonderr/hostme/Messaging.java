package com.example.melonderr.hostme;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Messaging extends AppCompatActivity implements View.OnClickListener {
    EditText phNumTxt;
    EditText msgTxt;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final int PERMISSION_REQUEST_CODE2 = 2;

    IntentFilter intentFilter;

    private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            TextView inTxt = findViewById(R.id.displayMessage);
            inTxt.setText(intent.getExtras().getString("sms"));
        }
    };

    // Button   sendBtn;
    // getApplicationContext() instead of this
    // int permissionCheck  = ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS);
//    int permissionCheck2 = ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECEIVE_SMS);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);

        intentFilter = new IntentFilter();
        intentFilter.addAction("SMS_RECEIVED_ACTION");

        phNumTxt = (findViewById(R.id.phoneNumber));
        msgTxt = findViewById(R.id.body);
        findViewById(R.id.send).setOnClickListener(this);

//        int check = ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS);
//        Toast.makeText(this, String.valueOf(check), Toast.LENGTH_SHORT).show();

        // SMS still doesn't work on APIs newer than 23

        // Permission granted == 0
        // Permission denied == -1
        // check is giving me 0, which is saying that permission is granted for some reason
        // so just try requesting permission anyways
//        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
//            Toast.makeText(getApplicationContext(),
//                    "testing", Toast.LENGTH_SHORT).show();
//            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS}, 1);
//        }

//        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.SEND_SMS}, 1);
//        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.RECEIVE_SMS}, 2);
//        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_PHONE_STATE}, 3);

//        String[] permissions = {android.Manifest.permission.SEND_SMS};
//        ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQUEST_CODE);

        String[] permissions2 = {android.Manifest.permission.READ_PHONE_STATE};
        ActivityCompat.requestPermissions(this, permissions2, PERMISSION_REQUEST_CODE2);

        // ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_PHONE_STATE}, 1);


//        if (permissionCheck2 != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.RECEIVE_SMS}, 1);
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(getApplicationContext(),
                    "worked", Toast.LENGTH_SHORT).show();

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    Toast.makeText(getApplicationContext(),
                            "failed", Toast.LENGTH_SHORT).show();

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            case 2: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(getApplicationContext(),
                            "worked2", Toast.LENGTH_SHORT).show();

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    Toast.makeText(getApplicationContext(),
                            "failed2", Toast.LENGTH_SHORT).show();

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send:
                String phNum = phNumTxt.getText().toString();
                String msg   = msgTxt.getText().toString();
                msgTxt.getText().clear();
                Toast.makeText(getApplicationContext(),
                        "Pressed Send", Toast.LENGTH_SHORT).show();
                sendMsg(phNum, msg);
                break;
        }
    }

    public void set() {

    }

    protected void sendMsg(String num, String msg) {
        String SENT = "Message Sent";
        String DELIVERED = "Message Delivered";

        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, new Intent(SENT),0);
        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0, new Intent(DELIVERED),0);

        registerReceiver(new BroadcastReceiver() {
            // @Override
            public void onReceive(Context context, Intent intent) {
                switch(getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getApplicationContext(),
                                "SMS Sent", Toast.LENGTH_LONG).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText(getApplicationContext(),
                                "Generic Failure", Toast.LENGTH_LONG).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(getApplicationContext(),
                                "No Service", Toast.LENGTH_LONG).show();
                        break;

                }
            }
        }, new IntentFilter(SENT));

        registerReceiver(new BroadcastReceiver() {
            // @Override
            public void onReceive(Context context, Intent intent) {
                switch(getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(getApplicationContext(),
                                "SMS Delivered", Toast.LENGTH_LONG).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText(getApplicationContext(),
                                "SMS Not Delivered", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        }, new IntentFilter(DELIVERED));

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(num, null, msg, sentPI, deliveredPI);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(intentReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(intentReceiver);
    }

}
