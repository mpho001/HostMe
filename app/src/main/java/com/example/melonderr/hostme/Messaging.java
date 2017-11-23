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

import java.util.Vector;

public class Messaging extends AppCompatActivity implements View.OnClickListener {
    private static int option = 0;
    public static Vector<String> messages = new Vector(0);
    // public static Vector<String> messages;

//    Restaurant_Search here = new Restaurant_Search();
//    CharSequence restName = here.name;

    EditText phNumTxt;
    EditText msgTxt;
//    private static final int PERMISSION_REQUEST_CODE = 1;
//    private static final int PERMISSION_REQUEST_CODE2 = 2;
    private static final int allPermissions = 1;

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

        // phNumTxt = (findViewById(R.id.phoneNumber));
        msgTxt = findViewById(R.id.body);
        findViewById(R.id.send).setOnClickListener(this);

        // Uncomment when this is linked to the restaurant page
        // When you message the restaurant, add that to the list of restaurants that have been messaged
        TextView displayRestName = findViewById(R.id.restaurantName);
        displayRestName.setText(Restaurant_Search.name);
        String MESSAGE = Restaurant_Search.name.toString();
        messages.add(MESSAGE);
        // displayRestName.setText(restName);

        // SMS still works on APIs >= 23

        // Permission granted == 0
        // Permission denied == -1

        String[] permissions = {android.Manifest.permission.SEND_SMS, android.Manifest.permission.READ_PHONE_STATE};
        ActivityCompat.requestPermissions(this, permissions, allPermissions);

        if (option == 1) {
            // display message
            // confirm this is the message that you want to send to the restaurant
            // then once the user has clicked send, send the user back to the restaurant main page
            TextView confirmMsg = findViewById(R.id.confirm);
            confirmMsg.setVisibility(View.VISIBLE);
            msgTxt.setText(Reserve.msg);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case allPermissions: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

//                    Toast.makeText(getApplicationContext(),
//                    " permissions worked", Toast.LENGTH_SHORT).show();

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    Toast.makeText(getApplicationContext(),
                            "failed to get permissions", Toast.LENGTH_SHORT).show();

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public void setOption(int op) {
        option = op;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send:
                // String phNum = phNumTxt.getText().toString();
                String phNum = "2092985414";
                String msg   = msgTxt.getText().toString();

//                String msg = "";
//                if (option == 1) {
//                    // then assign the message from reservation
//                     msg = Reserve.msg;
//                }
//                else {
//                    // get the message from user input
//                    msg = msgTxt.getText().toString();
//                }

                Toast.makeText(getApplicationContext(),
                        "Pressed Send", Toast.LENGTH_SHORT).show();
                if (phNum.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"need phone number", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (msg.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"need a message", Toast.LENGTH_SHORT).show();
                    break;
                }
                msgTxt.getText().clear();
                sendMsg(phNum, msg);

                // if from reservation, take user back to restaurant main page
                if (option == 1) {
                    Intent intent = new Intent(this, RestuarantMainPage.class);
                    startActivity(intent);
                    // remove the selected option
                    setOption(0);
                }

                break;
        }

    }

//    public void set() {
//
//    }

    protected void sendMsg(String num, String msg) {
        String SENT = "Message Sent";
        String DELIVERED = "Message Delivered";

        // displaying outgoing messages
        TextView outTxt = findViewById(R.id.outgoingMessage);
        String out = "Me: " + msg;
        outTxt.setText(out);

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
