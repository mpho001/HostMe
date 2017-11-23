package com.example.melonderr.hostme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;


public class User_Main_Page extends Activity {

    DatabaseHelper myDb;

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user__main__page);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
            GridView grid;
            String[] web = {
                    "My account"
//            "Github",
//            "Instagram",
//            "Facebook",
//            "Flickr",
//            "Pinterest"

    } ;
            int[] imageId = {
                    R.drawable.btn_profile
        //            R.drawable.image2,
        //            R.drawable.image3,
        //            R.drawable.image4,
        //            R.drawable.image5,
        //            R.drawable.image6


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__main__page);
        /*
        CustomGrid adapter = new CustomGrid(User_Main_Page.this, web, imageId);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(User_Main_Page.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
        */

        // 1 FOR FIRST NAME FROM DATABASE
        // first, obtain email
        // then use email to get the user's first name
//        int flag = 0;
//        Cursor res = myDb.getAllData();
//        if(res.getCount() == 0)
//        {
//            Toast.makeText(getApplicationContext(),
//                    "Failure!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        else {
//            while (res.moveToNext()) {
//                if(res.getString(4).equals(googleEmail)) {
//                    Intent intent = new Intent(this, User_Main_Page.class);
//                    startActivity(intent);
//                    flag = 1;
//                }
//            }
//            if (flag != 1) {
//                Toast.makeText(getApplicationContext(),
//                        "Account does not exist!", Toast.LENGTH_SHORT).show();
//            }
//        }

        Button accountBtn = findViewById(R.id.userAccount);
        accountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(User_Main_Page.this, my_account_info.class);
                startActivity(i);
            }
        });

        Button reservationButton = findViewById(R.id.reservation);
        reservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(User_Main_Page.this, ReservationRecord.class);
                startActivity(i);
            }
        });

        Button messagesButton = findViewById(R.id.message);
        messagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DisplayMessages.class);
                startActivity(i);
            }
        });

        TextView greeting = findViewById(R.id.greeting);
        if (Google.loggedIn == 1) {
            greeting.append(Google.firstName);
        }
        else {
            greeting.append(MainActivity.firstName);
        }
    }

//    GridView grid;
//    String[] web = {
 //           "Search"
//    } ;

//    int[] imageId = {
  //          R.drawable.places_ic_search
  //  };
    // @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user__main__page);
//
//        CustomGrid adapter = new CustomGrid(User_Main_Page.this, web, imageId);
//        grid = (GridView) findViewById(R.id.grid);
//        grid.setAdapter(adapter);
//        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
 //                                   int position, long id) {
 //               Toast.makeText(User_Main_Page.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();

   //         }
   //     });
 //   }

    public void searchPage(View view) {
        Intent intent = new Intent(this, Restaurant_Search.class);
        startActivity(intent);
    }

}
