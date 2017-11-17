package com.example.melonderr.hostme;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Bundle;


public class User_Main_Page extends Activity {

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
