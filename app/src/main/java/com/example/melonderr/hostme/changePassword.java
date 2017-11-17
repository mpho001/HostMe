package com.example.melonderr.hostme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class changePassword extends AppCompatActivity {

    private EditText oldPass = null;
    private EditText newPass = null;
    private EditText verifyPass = null;
    DatabaseHelper myDb;
    private Button _change = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        myDb = new DatabaseHelper(this);
        oldPass = (EditText) findViewById(R.id.currentPassword);
        newPass = (EditText) findViewById(R.id.newPassword);
        verifyPass = (EditText) findViewById(R.id.verifyNewPassword);

        _change = (Button) findViewById(R.id.change);

        _change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((oldPass.getText().toString().equals("")))
                {
                    oldPass.setError("Blank Entry");
                }
                if((newPass.getText().toString().equals("")| newPass.length() < 4))
                {
                    newPass.setError("At least 4 characters");
                }
                else {
                    Cursor res = myDb.getAllData();
                    while (res.moveToNext()) {

//                    if old != oldDB error: Enter current password
                        if (res.getString(5).equals(oldPass.getText().toString())) {

//                            if new == old error: New and Current password is same
                            if (newPass.getText().toString().equals(oldPass.getText().toString())) {
                                newPass.setError("Enter New Password");
                            } else {
//                            if new != verify : Passwords don't match
                                if (!newPass.getText().toString().equals(verifyPass.getText().toString())) {
                                    verifyPass.setError("Passwords don't match");
                                } else {
                                    if (myDb.updateData("", "", "", "",
                                            "", newPass.getText().toString(), oldPass.getText().toString(), "",
                                            "", "", "", "")) {
                                        Toast.makeText(getApplicationContext(),
                                                "Password Updated", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(changePassword.this, User_Main_Page.class);
                                        startActivity(intent);
                                    }
                                }
                            }
                        }
                        else {
                            oldPass.setError("Enter current password");
                        }
                    }
                }
            }
        });
    }
}
