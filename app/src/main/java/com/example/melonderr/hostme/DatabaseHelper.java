package com.example.melonderr.hostme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "users.db";
    public static final String TABLE_NAME = "GENERAL_TABLE";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FIRST_NAME";
    public static final String COL_3 = "LAST_NAME";
    public static final String COL_4 = "PHONE_NUMBER";
    public static final String COL_5 = "EMAIL";
    public static final String COL_6 = "PASSWORD";
    public static final String COL_7 = "OLD_PASSWORD";
    public static final String COL_8 = "REVIEWS";
    public static final String COL_9 = "MESSAGES";
    public static final String COL_10 = "RESERVATIONS";
    public static final String COL_11 = "SECURITY_QUESTION1";
//    public static final String COL_12 = "SECURITY_QUESTION2";
//    public static final String COL_13 = "SECURITY_QUESTION3";
    public static final String COL_14 = "SECURITY_ANSWER1";
//    public static final String COL_15 = "SECURITY_ANSWER2";
//    public static final String COL_16 = "SECURITY_ANSWER3";

//    public static final String TABLE_NAME_2 = "RESERVATION_TABLE";
//    public static final String RCOL_1 = "ID";
//    public static final String RCOL_2 = "FIRST_NAME";
//    public static final String RCOL_3 = "LAST_NAME";
//    public static final String RCOL_4 = "PHONE_NUMBER";
//    public static final String RCOL_5 = "RESTAURANT_NAME";
//    public static final String RCOL_6 = "MDY";
//    public static final String RCOL_7 = "TIME_HR";
//    public static final String RCOL_8 = "MINUTE";
//    public static final String RCOL_9 = "AMPM";
//    public static final String RCOL_10 = "PEOPLE";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_USER());
//        db.execSQL(CREATE_RESERVE());
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT,LAST_NAME TEXT,PHONE_NUMBER TEXT, EMAIL TEXT, PASSWORD TEXT," +
                "OLD_PASSWORD TEXT, REVIEWS TEXT, MESSAGES TEXT, RESERVATIONS TEXT, SECURITY_QUESTION1 TEXT,SECURITY_ANSWER1 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_2);
        onCreate(db);
    }

    public boolean insertData(String FIRST_NAME,String LAST_NAME,String PHONE_NUMBER, String EMAIL, String PASSWORD, String OLDPASSWORD,
                              String REVIEWS, String MESSAGES, String RESERVATION, String SECURITY_QUESTION1,// String SECURITY_QUESTION2, String SECURITY_QUESTION3,
                              String SECURITY_ANSWER1) { //, String SECURITY_ANSWER2, String SECURITY_ANSWER3
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,FIRST_NAME);
        contentValues.put(COL_3,LAST_NAME);
        contentValues.put(COL_4,PHONE_NUMBER);
        contentValues.put(COL_5,EMAIL);
        contentValues.put(COL_6,PASSWORD);
        contentValues.put(COL_7,OLDPASSWORD);
        contentValues.put(COL_8,REVIEWS);
        contentValues.put(COL_9,MESSAGES);
        contentValues.put(COL_10,RESERVATION);
        contentValues.put(COL_11,SECURITY_QUESTION1);
//        contentValues.put(COL_12,SECURITY_QUESTION2);
//        contentValues.put(COL_13,SECURITY_QUESTION3);
        contentValues.put(COL_14,SECURITY_ANSWER1);
//        contentValues.put(COL_15,SECURITY_ANSWER2);
//        contentValues.put(COL_16,SECURITY_ANSWER3);

        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }


    public boolean updateData(String id,String FIRST_NAME,String LAST_NAME,String PHONE_NUMBER,
                              String EMAIL, String PASSWORD, String OLDPASSWORD,
                              String REVIEWS, String MESSAGES, String RESERVATION, String SECURITY_QUESTION1, String SECURITY_ANSWER1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        if(!(FIRST_NAME.equals(""))){
            contentValues.put(COL_2,FIRST_NAME);}
        if(!(LAST_NAME.equals(""))){
            contentValues.put(COL_3,LAST_NAME);}
        if(!(PHONE_NUMBER.equals(""))){
            contentValues.put(COL_4,PHONE_NUMBER);}
        if(!(EMAIL.equals(""))){
            contentValues.put(COL_5,EMAIL);}
        if(!(PASSWORD.equals(""))){
            contentValues.put(COL_6,PASSWORD);}
        if(!(OLDPASSWORD.equals(""))){
            contentValues.put(COL_7,OLDPASSWORD);}
        if(!(REVIEWS.equals(""))){
            contentValues.put(COL_8,REVIEWS);}
        if(!(MESSAGES.equals(""))){
            contentValues.put(COL_9,MESSAGES);}
        if(!(RESERVATION.equals(""))){
            contentValues.put(COL_10,RESERVATION);}
        if(!(SECURITY_QUESTION1.equals(""))){
            contentValues.put(COL_11,SECURITY_QUESTION1);}
//        if(!(SECURITY_QUESTION2.equals(""))){
//            contentValues.put(COL_12,SECURITY_QUESTION2);}
//        if(!(SECURITY_QUESTION3.equals(""))){
//            contentValues.put(COL_13, SECURITY_QUESTION3);}
        if(!(SECURITY_ANSWER1.equals(""))){
            contentValues.put(COL_14, SECURITY_ANSWER1);}
//        if(!(SECURITY_ANSWER2.equals(""))) {
//            contentValues.put(COL_15, SECURITY_ANSWER2);}
//        if(!(SECURITY_ANSWER3.equals(""))){
//            contentValues.put(COL_16, SECURITY_ANSWER3);}
        db.update(TABLE_NAME, contentValues, "EMAIL = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "EMAIL = ?",new String[] {id});
    }

    }


