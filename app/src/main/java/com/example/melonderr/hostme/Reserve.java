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
    EditText customer_first, customer_last , _phone, _restaurant, _hr,_min,_light,_date;
    TextView _ppl;
    Button btnPplSubmit, btnPplMinus, btnPplPlus;
    int pplDensity=0;
    Calendar c = Calendar.getInstance();
    int dateFlag = 0;
    private RadioGroup _radioGroup;
    private RadioButton radio_light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);
        myDb = new DatabaseHelper(this);
        _date = (EditText) findViewById(R.id.enterDate);
        _hr = (EditText) findViewById(R.id.enterTime);
        _min = (EditText) findViewById(R.id.enterMin);
        _light = (EditText) findViewById(R.id.enterMin);
        _radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        radio_light = (RadioButton) findViewById(R.id.)


        //===========================SET DATABASE TABLE UP HERE======================================


        //============================================================================================
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
                                               if ( pplDensity > 0) {
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

                            _date.setError("pl Please put valid date");
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
                                Toast.makeText(getApplicationContext(),
                                        " 1st Fail", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(getApplicationContext(),
                                    "2nd Fail", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(getApplicationContext(),
                                        "3rd Fail", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(getApplicationContext(),
                                        "4th Fail", Toast.LENGTH_SHORT).show();
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
                                    Toast.makeText(getApplicationContext(),
                                            "5th Fail", Toast.LENGTH_SHORT).show();
                                    flag = 1;
//                                    break;
                                }
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),
                                        "6th Fail", Toast.LENGTH_SHORT).show();
                                flag = 1;
//                                break;
                            }
                        }
                        if(flag ==1)
                        {
//                            _date.setError("Date is blank");
                            _date.setError("Please put valid date");
                            flag =0;
                            break;
//                            i =0;
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
                    }
                    else
                    {
                        _hr.setError("Incorrect Hour");
                    }
                    minute = Integer.parseInt(_min.getText().toString());
                    if(minute <=59 && minute >=0)
                    {
//                        Toast.makeText(getApplicationContext(),
//                                _min.getText(), Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        _min.setError("Incorrect Minute");
                    }
//                    int errorFlag = 0;
//                    for(int i = 0; i <_time.length(); ++i )
//                    {
//                        int flag = 0;
//                        int flag2 = 0;
//                        char temp = _time.getText().toString().charAt(i);int tempInt = Character.getNumericValue(temp);
//                        if(i == 0 && (temp >= '0' || temp <= '1'))
//                        {
//                            if(temp == '1')
//                            {
//                                flag = 1;
//                            }
//                        }
//                        else
//                        {
//                            errorFlag = 1;
//                            break;
//                        }
//                        if(i == 1 && (temp >= '0' || temp <= '9'))
//                        {
//                            if(flag == 1 &&  (temp >= '0' || temp <= '1'))
//                            {}
//                            else
//                            {
//                                Toast.makeText(getApplicationContext(),
//                                        "1st Fail", Toast.LENGTH_SHORT).show();
//                                errorFlag = 1;
//                                break;
//                            }
//                        }
//                        else
//                        {
//                            errorFlag = 1;
//                            break;
//                        }
//                        if(i == 2 && temp == ':')
//                        {}
//                        else
//                        {   errorFlag = 1;
//                            Toast.makeText(getApplicationContext(),
//                                    "2nd Fail", Toast.LENGTH_SHORT).show();
//                            break;
//                        }
//                        if(i == 3 && (temp >= '0' || temp <= '6'))
//                        {
//                            if(temp == '6')
//                            {
//                                flag2 = 1;
//                            }
//                        }
//                        else
//                        {
//                            errorFlag = 1;
//                            Toast.makeText(getApplicationContext(),
//                                    "3rd Fail", Toast.LENGTH_SHORT).show();
//                            break;
//                        }
//                        if(i == 4 && (temp >= '0' || temp <= '9'))
//                        {
//                            if(flag2 == 1 && temp == '0')
//                            {}
//                            else
//                            {
//                                errorFlag = 1;
//                                Toast.makeText(getApplicationContext(),
//                                        "4th Fail", Toast.LENGTH_SHORT).show();
//                                break;
//                            }
//                        }
//                        else
//                        {
//                            errorFlag = 1;
//                            break;
//                        }
//                        if(i == 5 && temp == ' ')
//                        {}
//                        else
//                        {
//                            Toast.makeText(getApplicationContext(),
//                                    "5th Fail", Toast.LENGTH_SHORT).show();
//                            errorFlag = 1;
//                            break;
//                        }
//                        if(i == 6 && (temp == 'a' || temp == 'p'))
//                        {}
//                        else
//                        {
//                            errorFlag = 1;
//                            break;
//                        }
//                        if(i == 7 && temp == 'm')
//                        {}
//                        else
//                        {
//                            errorFlag = 1;
//                            Toast.makeText(getApplicationContext(),
//                                    "6th Fail", Toast.LENGTH_SHORT).show();
//                            break;
//                        }
//                        if (errorFlag == 1
//                                ) {
//                            _time.setError("Please put valid time");
//                            errorFlag =0;
//                            break;
//                        }
//                    }
////                    if(errorFlag == 1)
////                    {
//////                            _date.setError("Date is blank");
////                        _time.setError("Please put valid date");
////                        errorFlag =0;
////
////                        break;
////                    }
                }
//
//
//
////                Intent i = new Intent(.this, Reserve.class);
////                startActivity(i);
            }
        });
    }

}