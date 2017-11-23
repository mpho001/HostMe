package com.example.melonderr.hostme;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.Calendar;

public class Reserve extends AppCompatActivity {

    DatabaseHelper myDb;
    ReserveHelper rDb;

    public static EditText   _hr,_min,_date;
    public static String  _restaurant,customer_first, customer_last , _phone,_light,_time ,_ditto= "";

    TextView _ppl;
    Button btnPplSubmit, btnPplMinus, btnPplPlus;

    public static int pplDensity=1;
    Calendar c = Calendar.getInstance();
    int dateFlag = 0;
    String _id;
     RadioGroup _radioGroup;
    public static String Phoner;

     RadioButton radio_light;
     String CurrentUser = MainActivity.LoggedUser;

    // Compile into a message
    // consists of date + time + number of people
     public static String msg;
    // msg = _date + _hr + _min + pplDensity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);
        myDb = new DatabaseHelper(this);

        _date = (EditText) findViewById(R.id.enterDate);
        _hr = (EditText) findViewById(R.id.enterTime);
        _min = (EditText) findViewById(R.id.enterMin);
//        _light = (RadioButton) findViewById(R.id.);
        _radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        _ppl = (TextView) findViewById(R.id.textPeople);
        _ppl.setText(""+ pplDensity);
        btnPplMinus = (Button)findViewById(R.id.minus10);
        btnPplPlus = (Button)findViewById(R.id.plus10);
        btnPplSubmit = (Button)findViewById(R.id.ok);

        btnPplPlus.setOnClickListener(new View.OnClickListener(){
                                          //            @Override
                                          public void onClick(View v) {
                                              if(pplDensity < 30) {
                                                  pplDensity++;
                                              }
                                              _ppl.setText(""+ pplDensity);
                                          }
                                      }
        );

        btnPplMinus.setOnClickListener(new View.OnClickListener() {
//            @Override

                                           public void onClick(View v) {
                                               if ( pplDensity > 1) {
                                                   pplDensity--;
                                               }
                                               _ppl.setText(""+ pplDensity);
                                           }
                                       }
        );

        //this is setting the database when reserving for a restaurant.

        btnPplSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //=====================this is for date input========
                Cursor res = myDb.getAllData();
                boolean goodtoGo = true;
                if((_date.getText().toString().equals("")))
                {
                    _date.setError("Date is blank");
                }
                else
                {


                    for(int i = 0; i <_date.length(); ++i )
                    {
                        int flag = 0;
//                        Toast.makeText(getApplicationContext(), (_date).getText(), Toast.LENGTH_SHORT).show();
                        if(_date.length() < 10 || _date.length() >10)
                        {
                            goodtoGo = false;

                            _date.setError("Please put valid date");
                            break;
                        }
                        char temp = _date.getText().toString().charAt(i);
                        int tempInt = Character.getNumericValue(temp);

//                        Toast.makeText(getApplicationContext(),
//                                temp, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(getApplicationContext(),
//                                tempInt, Toast.LENGTH_SHORT).show();
                        if((i == 0  || i == 6))// && flag ==0)
                        {

                            if(tempInt == 0 || tempInt == 1)
                            {}
                            else if (tempInt ==2){}
                            else
                            {
                                goodtoGo = false;
                                flag = 1;

//                                break;
                            }
                        }
                        if((i == 1 || i == 7|| i == 8 || i == 9)  )
                        {
                            if(tempInt >0 &&i == 7)
                            {
                                _date.setError("Too Far From Now");
                                flag = 1;
                            }
                            else if(tempInt > 1 && i == 8 )
                            {
                                _date.setError("Too Far From Now");
                                flag = 1;
                            }
                            else
                        {
                            if(tempInt >= 0 && tempInt <= 9)
                            {}
                            else
                            {
                                goodtoGo = false;
                                flag = 1;
                            }
                        }
                        }
                        if((i == 2 || i == 5) )
                        {
                            if(temp == '/')
                            {}
                            else
                            {
                                goodtoGo = false;
                                flag = 1;
                            }
                        }
                        if(i == 3  )
                        {
                            if(tempInt >= 0 && tempInt <= 3)
                            {
                                if(tempInt == 3)
                                {
                                    dateFlag = 1;
                                }
                            }
                            else
                            {
                                goodtoGo = false;
                                flag = 1;
                            }
                        }
                        if(i == 4  )
                        {
                            if(tempInt >= 0 && tempInt <= 9)
                            {
                                if(dateFlag == 1 && tempInt >= 0 && tempInt <= 2)
                                {}
                                else if(dateFlag == 1 && (tempInt <0 || tempInt >2))
                                {
                                    goodtoGo = false;
                                    flag = 1;
                                }
                            }
                            else
                            {
                                goodtoGo = false;
                                flag = 1;
                            }
                        }
                        if(flag ==1)
                        {
                            _date.setError("Please put valid date");
                            goodtoGo = false;
                            flag =0;
                            break;
                        }
                        else
                        {
                            goodtoGo = true;
                        }
                    }
                }
                //=====================this is for time input========


                if((_hr.getText().toString().equals("")) || (_min.getText().toString().equals("")))
                {
                    if((_min.getText().toString().equals("")))
                    {
                        _min.setError("Minute is blank");
                    }
                    if((_hr.getText().toString().equals(""))) {
                        _hr.setError("Hour is blank");
                    }
                }
                else
                {
                    int selectedID = _radioGroup.getCheckedRadioButtonId();
                    radio_light = (RadioButton) findViewById(selectedID);
                    int hour, minute = 0;
                    hour = Integer.parseInt(_hr.getText().toString());
                    if(hour <=12 && hour >=1)
                    {
//                        goodtoGo = true;
                    }
                    else
                    {
                        _hr.setError("Incorrect Hour");
                        goodtoGo = false;
                    }
                    minute = Integer.parseInt(_min.getText().toString());
                    if(minute <=59 && minute >=0)
                    {
//                        goodtoGo = true;
                    }
                    else
                    {
                        _min.setError("Incorrect Minute");
                        goodtoGo = false;
                    }
                    AddReserve();

                }

                if (goodtoGo) {
                    // if good to go, then can safely compile the message and send to message activity

                    msg = "Date: " + _date.getText().toString() + "\n" + "Name: " + customer_first + " "+ customer_last+"\n";
                    msg += "Time: " + _hr.getText().toString() + ":" + _min.getText().toString() +" "+ radio_light.getText().toString() +"\n";
                    msg += "# of People: " + pplDensity + "\n";
                    Messaging messaging = new Messaging();
                    messaging.setOption(1);
                    Intent intent = new Intent(getApplicationContext(), Messaging.class);
                    startActivity(intent);
                }

            }


        });
    }
    public void AddReserve(){
        callInfo();

    }
    public void callInfo(){
        Cursor res = myDb.getAllData();
        while(res.moveToNext())
        {
            if(res.getString(4).equals(CurrentUser) )
            {
                _id = (res.getString(0));
                _phone = ( res.getString(3));
                customer_first=(res.getString(1));
                customer_last=(res.getString(2));
                _light = radio_light.getText().toString();
                _restaurant= (String)(Restaurant_Search.name);
                boolean isInserted = true;
                Phoner = _phone;
                rDb = new ReserveHelper(this);
                _time = _hr.getText().toString() + ":" + _min.getText().toString() + " " + _light;
                _ditto = _date.getText().toString();
            }
        }
    }
}