package com.example.melonderr.hostme;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Messaging extends AppCompatActivity implements View.OnClickListener{

    EditText phNumTxt;
    EditText msgTxt;
    // Button   sendBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);

        phNumTxt = (findViewById(R.id.phoneNumber));
        msgTxt = findViewById(R.id.body);
        findViewById(R.id.send).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send:
                String phNum = phNumTxt.getText().toString();
                String msg   = msgTxt.getText().toString();
                Toast.makeText(getApplicationContext(),
                        "Pressed Send", Toast.LENGTH_SHORT).show();
                sendMsg(phNum, msg);
                break;
        }
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
}
