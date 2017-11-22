package com.example.melonderr.hostme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MessagingReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Testing", Toast.LENGTH_SHORT).show();

        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = null;
        String str = "";

        if (bundle != null) {
            // messages are stored in the object array
            // pdu = protocol description unit
            Object[] pdus = (Object[]) bundle.get("pdus");
            messages = new SmsMessage[pdus.length];

            // loop through messages
            for (int i = 0; i < messages.length; ++i) {
                // create from pdu is from message class
                messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                // str += "Message from " + messages[i].getOriginatingAddress();
                str += "Message from " + Restaurant_Search.name;
                str += ": ";
                str += messages[i].getMessageBody();
                str += "\n";
            }

            // display the message
            // Toast.makeText(context, str, Toast.LENGTH_SHORT).show();

            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction("SMS_RECEIVED_ACTION");
            broadcastIntent.putExtra("sms", str);
            context.sendBroadcast(broadcastIntent);
        }
    }


}
