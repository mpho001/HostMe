package com.example.melonderr.hostme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by japneetkaur on 11/5/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "user.db";
    public static final String TABLE_NAME = "user_info";
    public static final String Col_1 = "FIRST NAME";
    public static final String Col_2 = "LAST NAME";
    public static final String Col_3 = "PHONE NUMBER";
    public static final String Col_4 = "EMAIL";
    public static final String Col_5 = "# OF RESERVATIONS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1
        );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("")
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
