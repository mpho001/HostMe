package com.example.melonderr.hostme;


import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.CalendarView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.widget.DatePicker;
//import android.widg

//import
public class Reserve extends AppCompatActivity {

    DatabaseHelper myDb;
    ReserveHelper rDb;
    EditText   _hr,_min,_date;
    String  _restaurant,customer_first, customer_last , _phone,_light;
    TextView _ppl;
    Button btnPplSubmit, btnPplMinus, btnPplPlus;
    int pplDensity=1;
    Calendar c = Calendar.getInstance();
    int dateFlag = 0;
     RadioGroup _radioGroup;
    public static String Phoner;

     RadioButton radio_light;
     String CurrentUser = MainActivity.LoggedUser;


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

//        radio_light = (RadioButton) findViewById(R.id.)

//        System.out.println("Current time => " + c.getTime());
//        SimpleDateFormat df = new SimpleDateFormat("");
//        String formattedDate = df.format(c.getTime());
//        Toast.makeText(getApplicationContext(),
//                formattedDate, Toast.LENGTH_SHORT).show();
//        customer_first

        //=====================this is for date input========
//        _date = (EditText) findViewById(R.id.enterDate);
//
//            if((_date.getText().toString().equals("")))
//            {
//                _date.setError("Date is blank");
//            }
//            //=====================this is for time input========
//            _time = (EditText) findViewById(R.id.enterTime);
//
//            if((_time.getText().toString().equals("")))
//            {
//                _time.setError("Time is blank");
//            }
//            else
//            {
//                for(int i = 0; i <_date.length(); ++i )
//                {
//                    char temp = _time.getText().toString().charAt(i);
//                    int tempInt = Character.getNumericValue(temp);
//                    if( i == 0  || i == 6)
//                    {
//                        Toast.makeText(getApplicationContext(),
//                                tempInt, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(getApplicationContext(),
//                                temp, Toast.LENGTH_SHORT).show();
//                        if(tempInt == 0 || tempInt == 1)
//                        {}
//                        else
//                        {
//
//                            break;}
//                    }
//                    if(i == 1 || i == 7)
//                    {
//                        if(tempInt <= 0 && tempInt >= 9)
//                        {}
//                        else
//                        {Toast.makeText(getApplicationContext(),
//                                "Fail", Toast.LENGTH_SHORT).show();
//                            break;}
//                    }
//                    if(i == 2 || i == 5)
//                    {
//                        if(temp == '/')
//                        {}
//                        else
//                        {
//                            Toast.makeText(getApplicationContext(),
//                                    "Fail", Toast.LENGTH_SHORT).show();
//                            break;}
//                    }
//                    if(i == 3)
//                    {
//                        if(tempInt >= 0 && tempInt <= 3)
//                        {
//                            if(tempInt == 3)
//                            {
//                                dateFlag = 1;
//                            }
//                        }
//                        else
//                        {
//                            Toast.makeText(getApplicationContext(),
//                                    "Fail", Toast.LENGTH_SHORT).show();
//                            break;}
//                    }
//                    if(i == 4)
//                    {
//                        if(tempInt >= 0 && tempInt <= 9)
//                        {
//                            if(dateFlag == 1 && tempInt >= 0 && tempInt <= 2)
//                            {}
//                            else
//                            {
//                                Toast.makeText(getApplicationContext(),
//                                        "Fail", Toast.LENGTH_SHORT).show();
//                                break;}
//                        }
//                        else
//                        {
//                            Toast.makeText(getApplicationContext(),
//                                    "Fail", Toast.LENGTH_SHORT).show();
//                            break;}
//                    }
//                }
//            }


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
        //create something to send a message to restaurant when reserving

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
//                            Toast.makeText(getApplicationContext(), Integer.toString(tempInt), Toast.LENGTH_SHORT).show();
//                            Toast.makeText(getApplicationContext(),
//                                    tempInt, Toast.LENGTH_SHORT).show();
//                            Toast.makeText(getApplicationContext(),
//                                    temp, Toast.LENGTH_SHORT).show();

                            if(tempInt == 0 || tempInt == 1)
                            {}
                            else if (tempInt ==2){}
                            else
                            {
//                                Toast.makeText(getApplicationContext(),
//                                        " 1st Fail", Toast.LENGTH_SHORT).show();
                                goodtoGo = false;
                                flag = 1;

//                                break;
                            }
                        }
                        if((i == 1 || i == 7)  )
                        {
//                            Toast.makeText(getApplicationContext(), Integer.toString(tempInt), Toast.LENGTH_SHORT).show();
                            if(tempInt >= 0 && tempInt <= 9)
                            {}
                            else
                            {
//                                Toast.makeText(getApplicationContext(),
//                                    "2nd Fail", Toast.LENGTH_SHORT).show();
                                goodtoGo = false;
                                flag = 1;
//                                break;
                            }
                        }
                        if((i == 2 || i == 5) )
                        {
//                            Toast.makeText(getApplicationContext(), Integer.toString(tempInt), Toast.LENGTH_SHORT).show();
                            if(temp == '/')
                            {}
                            else
                            {
//                                Toast.makeText(getApplicationContext(),
//                                        "3rd Fail", Toast.LENGTH_SHORT).show();
                                goodtoGo = false;
                                flag = 1;
//                                break;
                            }
                        }
                        if(i == 3  )
                        {
//                            Toast.makeText(getApplicationContext(), Integer.toString(tempInt), Toast.LENGTH_SHORT).show();
                            if(tempInt >= 0 && tempInt <= 3)
                            {
                                if(tempInt == 3)
                                {
                                    dateFlag = 1;
                                }
                            }
                            else
                            {
//                                Toast.makeText(getApplicationContext(),
//                                        "4th Fail", Toast.LENGTH_SHORT).show();
                                goodtoGo = false;
                                flag = 1;
//                                break;
                            }
                        }
                        if(i == 4  )
                        {
//                            Toast.makeText(getApplicationContext(), Integer.toString(tempInt), Toast.LENGTH_SHORT).show();
                            if(tempInt >= 0 && tempInt <= 9)
                            {
                                if(dateFlag == 1 && tempInt >= 0 && tempInt <= 2)
                                {}
                                else if(dateFlag == 1 && (tempInt <0 || tempInt >2))
                                {
//                                    Toast.makeText(getApplicationContext(),
//                                            "5th Fail", Toast.LENGTH_SHORT).show();
                                    goodtoGo = false;
                                    flag = 1;
//                                    break;
                                }
                            }
                            else
                            {
//                                Toast.makeText(getApplicationContext(),
//                                        "6th Fail", Toast.LENGTH_SHORT).show();
                                goodtoGo = false;
                                flag = 1;
//                                break;
                            }
                        }
                        if(flag ==1)
                        {
//                            _date.setError("Date is blank");
                            _date.setError("Please put valid date");
                            goodtoGo = false;
                            flag =0;
                            break;
//                            i =0;
                        }
                        else
                        {
                            goodtoGo = true;
                        }
//                        Toast.makeText(getApplicationContext(),
//                                _date.getText(), Toast.LENGTH_SHORT).show();

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
//                    Toast.makeText(getApplicationContext(),
//                            radio_light.getText(), Toast.LENGTH_SHORT).show();
                    int hour, minute = 0;
                    hour = Integer.parseInt(_hr.getText().toString());
                    if(hour <=12 && hour >=1)
                    {
//                        Toast.makeText(getApplicationContext(),
//                                _hr.getText(), Toast.LENGTH_SHORT).show();
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
//                        Toast.makeText(getApplicationContext(),
//                                _min.getText(), Toast.LENGTH_SHORT).show();
//                        goodtoGo = true;
                    }
                    else
                    {
                        _min.setError("Incorrect Minute");
                        goodtoGo = false;
                    }
                    AddReserve();

                }
//
//
//
////                Intent i = new Intent(.this, Reserve.class);
////                startActivity(i);

            }


        });
    }
    public void AddReserve(){
        callInfo();
        boolean isInserted = false;
        Phoner = _phone;
        rDb = new ReserveHelper(this);
        isInserted = rDb.insertDataReservation("",customer_first,customer_last,_phone,_restaurant,_hr.getText().toString(),_min.getText().toString(),_date.getText().toString(),_light,String.valueOf(pplDensity));
//        isInserted = rDb.insertDataReservation("","","","","","","","","","");

//        Toast.makeText(getApplicationContext(),
//                _light, Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(),
//                _hr.getText().toString(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(getApplicationContext(),
//                _min.getText().toString(), Toast.LENGTH_SHORT).show();

        if(isInserted ==true)
        {
            Toast.makeText(getApplicationContext(),
                                "Success", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),
                    "Failedfjnsdk", Toast.LENGTH_SHORT).show();
        }

    }
    protected void callInfo(){
        Cursor res = myDb.getAllData();
        while(res.moveToNext())
        {
            if(res.getString(4).equals(CurrentUser) )
            {
                _phone = ( res.getString(3));
//                Toast.makeText(getApplicationContext(),
//                        _phone, Toast.LENGTH_SHORT).show();
                customer_first=(res.getString(1));
//                Toast.makeText(getApplicationContext(),
//                        customer_first, Toast.LENGTH_SHORT).show();
                customer_last=(res.getString(2));
//                Toast.makeText(getApplicationContext(),
//                        customer_last, Toast.LENGTH_SHORT).show();
//                TextView displayRestaurantName = findViewById(R.id.restaurantName2);
                _light = radio_light.getText().toString();
//                Toast.makeText(getApplicationContext(),
//                        _light, Toast.LENGTH_SHORT).show();
                _restaurant= (String)(Restaurant_Search.name);
//                Toast.makeText(getApplicationContext(),
//                        _restaurant, Toast.LENGTH_SHORT).show();

//                Toast.makeText(getApplicationContext(),
//                        "Success", Toast.LENGTH_SHORT).show();
            }
        }
    }
}