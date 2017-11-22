package com.example.melonderr.hostme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DisplayMessages extends AppCompatActivity {
    private ListView msgList;
    private TextView noMsgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_messages);

        if (Messaging.messages.size() != 0) {
            String[] listItems = new String[Messaging.messages.size()];
            msgList = findViewById(R.id.MessagedRestaurants);
            for (int i = 0; i < Messaging.messages.size(); ++i) {
                listItems[i] = Messaging.messages.get(i);
            }

            msgList.setVisibility(View.VISIBLE);
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
            msgList.setAdapter(adapter);
        }
        else {
            // no messages to display
            noMsgs = findViewById(R.id.noMessages);
            noMsgs.setVisibility(View.VISIBLE);
        }
    }
}
