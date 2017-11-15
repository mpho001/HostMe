package com.example.melonderr.hostme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.widget.Spinner;

import android.content.Intent;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.app.AlertDialog;
import android.database.Cursor;
//import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class Registration extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editSurname,editPhone ,editTextId, editTextQuestion,editEmail,editAnswer;
    Button btnAddData;
    Button btnSignupGoogle;
    Button btnviewAll;
    Button btnDelete;
    Button btnviewUpdate;
    Button goBack;
    private Spinner SecurityQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.FirstName);
        editSurname = (EditText)findViewById(R.id.LastName);
        editPhone = (EditText)findViewById(R.id.PhoneNumber);
        editEmail = (EditText) findViewById(R.id.email_address);
//        editTextId = (EditText)findViewById(R.id.editText_id);
//        editTextQuestion = (EditText)findViewById(R.id.Security_Questions);
        editAnswer = (EditText) findViewById(R.id.Security_Answer);
        btnAddData = (Button)findViewById(R.id.submit_button);
        btnSignupGoogle = (Button)findViewById(R.id.signUpWithGoogle);
//        btnviewAll = (Button)findViewById(R.id.button_viewAll);
//        btnviewUpdate= (Button)findViewById(R.id.button_update);
//        btnDelete= (Button)findViewById(R.id.button_delete);
//        goBack = (Button)findViewById(R.id.MainBtn);
//        addItemsOnSpinner();
        SecurityQuestion = (Spinner)findViewById(R.id.Security_Questions);
        String[] items = new String[]{"What was the name of your elementary / primary school?", "In what city or town does your nearest sibling live?", "What was your childhood nickname?"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        SecurityQuestion.setAdapter(adapter);
//        SecurityQuestion.setOnItemSelectedListener(this);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();

//        goBack.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent i = new Intent(Registration.this, MainActivity.class);
//                startActivity(i);
//            }
//        });
    }
//    public void addItemsOnSpinner2() {
//
//        SecurityQuestion = (Spinner) findViewById(R.id.Security_Questions);
//        List<String> list = new ArrayList<String>();
//        list.add("list 1");
//        list.add("list 2");
//        list.add("list 3");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        SecurityQuestion.setAdapter(dataAdapter);
//    }
    public void DeleteData() {
//        btnDelete.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
//                        if(deletedRows > 0)
//                            Toast.makeText(Registration.this,"Data Deleted",Toast.LENGTH_LONG).show();
//                        else
//                            Toast.makeText(Registration.this,"Data not Deleted",Toast.LENGTH_LONG).show();
//                    }
//                }
//        );
    }
    public void UpdateData() {
//        btnviewUpdate.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
//                                editName.getText().toString(),
//                                editSurname.getText().toString(),editPhone.getText().toString(), "","" ,"" ,"","","",
//                                editTextQuestion.getText().toString() ,"" ,"", "" ,"", "" );
//                        if(isUpdate == true)
//                            Toast.makeText(Registration.this,"Data Update",Toast.LENGTH_LONG).show();
//                        else
//                            Toast.makeText(Registration.this,"Data not Updated",Toast.LENGTH_LONG).show();
//                    }
//                }
//        );
    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editSurname.getText().toString(),editPhone.getText().toString(), "", "" ,"" ,"","", "",
                                /*editTextQuestion.getText().toString()*/ "" ,"", "" ,"" ,"","");
                        if(isInserted == true) {
                            Toast.makeText(Registration.this,"Registered",Toast.LENGTH_LONG).show();
                            Intent i = new Intent(Registration.this, MainActivity.class);
                            startActivity(i);
                        }
                        else
                            Toast.makeText(Registration.this,"Recheck Your Input",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
//        btnviewAll.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Cursor res = myDb.getAllData();
//                        if(res.getCount() == 0) {
//                            // show message
//                            showMessage("Error","Nothing found");
//                            return;
//                        }
//
//                        StringBuffer buffer = new StringBuffer();
//                        while (res.moveToNext()) {
//                            buffer.append("Id :"+ res.getString(0)+"\n");
//                            buffer.append("First Name:"+ res.getString(1)+"\n");
//                            buffer.append("Last Name:"+ res.getString(2)+"\n");
//                            buffer.append("Phone Number:"+ res.getString(3)+"\n");
//                            buffer.append("Email:"+ res.getString(4)+"\n");
//                            buffer.append("Security Question 1:"+ res.getString(10)+"\n");
//                            buffer.append("Security Question 2:"+ res.getString(12)+"\n\n");
//                        }
//
//                        showMessage("Data",buffer.toString());
//                    }
//                }
//        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_registration);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        Button next = (Button) findViewById(R.id.submit_button);
//        next.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent myIntent = new Intent(view.getContext(), test_display_user_info.class);
//                startActivityForResult(myIntent, 0);
//            }
//
//        });
//    }

}
