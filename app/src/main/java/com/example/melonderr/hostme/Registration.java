package com.example.melonderr.hostme;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

//import android.support.v7.app.ActionBarActivity;


public class Registration extends AppCompatActivity {
    // MainActivity forSignIn = new MainActivity();
    // Google google = new Google();

    DatabaseHelper myDb;
    EditText editName,editSurname,editPhone,editPassword,editComfirmPassword ,editTextId, editTextQuestion,editEmail,editAnswer;
    Button btnAddData;
    Button btnSignupGoogle;
    Button btnviewAll;
    Button btnDelete;
    Button btnviewUpdate;
    Button goBack;
    private Spinner SecurityQuestion;
    String LoggedInUer = MainActivity.LoggedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.FirstName);
        editSurname = (EditText)findViewById(R.id.LastName);
        editPhone = (EditText)findViewById(R.id.PhoneNumber);
        editEmail = (EditText) findViewById(R.id.email_address);
        editPassword = (EditText) findViewById(R.id.Password);
        editComfirmPassword = (EditText) findViewById(R.id.ConfirmPassword);
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
//        SecurityQuestion.setOnItemSelectedListener(new Listener_Spinner());

        if (Google.loggedIn == 1) {
            editName.setText(Google.firstName);
            editSurname.setText(Google.lastName);
            editEmail.setText(Google.googleEmail);
            findViewById(R.id.signUpWithGoogle).setVisibility(View.GONE);
            findViewById(R.id.Password).setVisibility(View.GONE);
            findViewById(R.id.ConfirmPassword).setVisibility(View.GONE);
            findViewById(R.id.Security_Answer).setVisibility(View.GONE);
            findViewById(R.id.Security_Questions).setVisibility(View.GONE);
        }

        else if (Google.loggedIn == 0) {
            editName.setText("");
            editSurname.setText("");
            editEmail.setText("");
            findViewById(R.id.signUpWithGoogle).setVisibility(View.VISIBLE);
            findViewById(R.id.Password).setVisibility(View.VISIBLE);
            findViewById(R.id.ConfirmPassword).setVisibility(View.VISIBLE);
            findViewById(R.id.Security_Answer).setVisibility(View.VISIBLE);
            findViewById(R.id.Security_Questions).setVisibility(View.VISIBLE);
        }

        btnSignupGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Google google = new Google();
                google.option(1);
                google.setPage(2);
                Intent intent = new Intent(getApplicationContext(), Google.class);
                startActivity(intent);
            }
        });

        btnAddData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                AddData();
            }
        });
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
//    public static class Listener_Spinner implements AdapterView.OnItemClickListener{
//
//    };
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
//        );
    }
//                }
    public  void AddData() {
        if(!validate())
        {
            onSignupFailed();
            return;
        }

//        btnAddData.setEnabled(false);
//        btnAddData.setOnClickListener(
//                new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
        boolean isInserted = false;
        if(Google.loggedIn == 1)
        {
            isInserted = myDb.insertData(editName.getText().toString(),
                    editSurname.getText().toString(),editPhone.getText().toString(), editEmail.getText().toString(), editPassword.getText().toString()
                    ,editPassword.getText().toString() ,"","", "",
                    /*editTextQuestion.getText().toString()*/ "" ,"");
        }
        else {
            isInserted = myDb.insertData(editName.getText().toString(),
                    editSurname.getText().toString(), editPhone.getText().toString(), editEmail.getText().toString(), editPassword.getText().toString()
                    , editPassword.getText().toString(), "", "", "",
                    /*editTextQuestion.getText().toString()*/ "", editAnswer.getText().toString());
        }
            if(isInserted == true) {
                Toast.makeText(Registration.this,"Registered",Toast.LENGTH_LONG).show();
                Intent i = new Intent(Registration.this, MainActivity.class);
                startActivity(i);
            }
            else
                Toast.makeText(Registration.this,"Recheck Your Input",Toast.LENGTH_LONG).show();
        }
//    }
//        );
//    }
    public void onSignupFailed()
    {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
       btnAddData.setEnabled(true);
    }
    public boolean validate(){
        boolean valid = true;
        String _First = editName.getText().toString();
        String _Last = editSurname.getText().toString();
        String _Phone = editPhone.getText().toString();
        String _Email = editEmail.getText().toString();
        String _Password = editPassword.getText().toString();
        String _ConfirmPassword = editComfirmPassword.getText().toString();
//        String _Question =
        String _Answer = editAnswer.getText().toString();
        if(_First.isEmpty() || _First.length() < 2){
            editName.setError("At least 2 characters");
            valid = false;
        }
        else editName.setError(null);

        if(_Last.isEmpty() || _Last.length() < 2){
            editSurname.setError("At least 2 characters");
            valid = false;
        }
        else editSurname.setError(null);

        if(_Phone.isEmpty() || _Phone.length() < 9){
            editPhone.setError("Enter a valid phone number");
            valid = false;
        }
        else editPhone.setError(null);

        if(_Email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(_Email).matches() ){
            editEmail.setError("Enter a valid email address");
            valid = false;
        }
        else editName.setError(null);

        if(Google.loggedIn != 1) {
            if (_Password.isEmpty() || _Password.length() < 4) {
                editPassword.setError("At least 4 characters");
                valid = false;
            } else editPassword.setError(null);


            if (_ConfirmPassword.isEmpty() || !_Password.equals(_ConfirmPassword)) {
                editComfirmPassword.setError("Passwords to not match");
                valid = false;
            } else editComfirmPassword.setError(null);

            if (_Answer.isEmpty() || _Answer.length() < 2) {
                editAnswer.setError("At least 2 characters");
                valid = false;
            } else editAnswer.setError(null);
        }






        return valid;
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
