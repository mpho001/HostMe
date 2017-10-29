package com.example.melonderr.hostme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.submit_button);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                EditText e1 = findViewById(R.id.email);
                EditText e2 = findViewById(R.id.password);

                if(e1.getText().toString().equals("admin") &&
                        e2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Success!", Toast.LENGTH_SHORT).show();
                }
//                else{
//                    tx1.setVisibility(View.VISIBLE);
//                    tx1.setBackgroundColor(Color.RED);
//                    counter--;
//                    tx1.setText(Integer.toString(counter));
//
//                    if (counter == 0) {
//                        b1.setEnabled(false);
//                    }
//                }
            }
        });
    }
}
