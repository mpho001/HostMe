package com.example.melonderr.hostme;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;

/**
 * Created by japneetkaur on 11/5/17.
 * Edit by Judy on 11/9/17
 */

//public class DatabaseHelper extends SQLiteOpenHelper {
//    public static final String DATABASE_NAME = "user.db";
//    public static final String TABLE_NAME = "user_info";
//    public static final String Col_ID = "id";
//    public static final String Col_1 = "FIRST_NAME";
//    public static final String Col_2 = "LAST_NAME";
//    public static final String Col_3 = "PHONE_NUMBER";
//    public static final String Col_4 = "EMAIL";
////    public static final String Col_5 = "RESERVATIONS";
//    public static final String Col_5 = "PASSWORD";
//    public static final String Col_6 = "OLD_PASSWORD";
//    public static final String Col_7 = "REVIEWS";
//    public static final String Col_8 = "MESSAGES";
//    public static final String Col_9 = "RESERVATIONS";
//    public static final String Col_10 = "SECURITY_QUESTION_1";
//    public static final String Col_11 = "SECURITY_ANSWER_1";
//    public static final String Col_12 = "SECURITY_QUESTION_2";
//    public static final String Col_13 = "SECURITY_ANSWER_2";
//    public static final String Col_14 = "SECURITY_QUESTION_3";
//    public static final String Col_15 = "SECURITY_ANSWER_3";
//
//    public DatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, 1
//        );
//    }
//    /*
//    onCreate will assign variable type that will be passed in the database.
//     */
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL(
//                "create table contacts " +
//                        "(id integer primary key, FIRST_NAME text, LAST_NAME text, PHONE_NUMBER text, " +
//                                "EMAIL text, PASSWORD text, OLD_PASSWORD text, REVIEWS text, MESSAGES  text,  RESERVATIONS  text, SECURITY_QUESTION_1  text, " +
//                                " SECURITY_ANSWER_1  text, SECURITY_QUESTION_2 text, SECURITY_ANSWER_2 text, SECURITY_QUESTION_3 text, SECURITY_ANSWER_3 text)");
//
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        /*
//        This function is if we were to upgrade/update the app and changed anything for the database,
//        then the function will check if the old version matches new version
//
//         */
//    }
//
//    public boolean insertContact ( String FIRST_NAME, String LAST_NAME, String PHONE_NUMBER, String EMAIL, String PASSWORD, String OLD_PASSWORD, String REVIEWS, String MESSAGES
//                                      , String RESERVATIONS, String SECURITY_QUESTION_1, String SECURITY_ANSWER_1, String SECURITY_QUESTION_2, String SECURITY_ANSWER_2
//                                      , String SECURITY_QUESTION_3, String SECURITY_ANSWER_3){
//
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("FIRST_NAME", FIRST_NAME);
//        contentValues.put("LAST_NAME", LAST_NAME);
//        contentValues.put("PHONE_NUMBER", PHONE_NUMBER);
//        contentValues.put("EMAIL", EMAIL);
//        contentValues.put("PASSWORD",PASSWORD );
//        contentValues.put("OLD_PASSWORD",OLD_PASSWORD );
//        contentValues.put("REVIEWS",  REVIEWS );
//        contentValues.put("MESSAGES",MESSAGES );
//        contentValues.put("RESERVATIONS",RESERVATIONS );
//        contentValues.put("SECURITY_QUESTION_1",SECURITY_QUESTION_1 );
//        contentValues.put("SECURITY_ANSWER_1", SECURITY_ANSWER_1);
//        contentValues.put("SECURITY_QUESTION_2",SECURITY_QUESTION_2 );
//        contentValues.put("SECURITY_ANSWER_2",SECURITY_ANSWER_2 );
//        contentValues.put("SECURITY_QUESTION_3", SECURITY_QUESTION_3);
//        contentValues.put("SECURITY_ANSWER_3",SECURITY_ANSWER_3 );
//
//        sqLiteDatabase.insert("user_info", null,contentValues);
//        return true;
//    }
//    /*
//    This function will get an user information based on their id.
//     */
//    public Cursor getData(int id)
//    {
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//        Cursor res = sqLiteDatabase.rawQuery("select * from contacts where id="+id+"", null);
//        return res;
//    }
//
//    public int numberOfRows(){
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//        int numRows = (int) DatabaseUtils.queryNumEntries(sqLiteDatabase, TABLE_NAME);
//        return numRows;
//    }
//    /*
//   this functions updates the existing contact information
//    Can be used for update account feature
//     */
//    public boolean updateContact ( Integer id, String FIRST_NAME, String LAST_NAME, String PHONE_NUMBER, String EMAIL, String PASSWORD, String OLD_PASSWORD, String REVIEWS, String MESSAGES
//            , String RESERVATIONS, String SECURITY_QUESTION_1, String SECURITY_ANSWER_1, String SECURITY_QUESTION_2, String SECURITY_ANSWER_2
//            , String SECURITY_QUESTION_3, String SECURITY_ANSWER_3){
//
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("FIRST_NAME", FIRST_NAME);
//        contentValues.put("LAST_NAME", LAST_NAME);
//        contentValues.put("PHONE_NUMBER", PHONE_NUMBER);
//        contentValues.put("EMAIL", EMAIL);
//        contentValues.put("PASSWORD",PASSWORD );
//        contentValues.put("OLD_PASSWORD",OLD_PASSWORD );
//        contentValues.put("REVIEWS",  REVIEWS );
//        contentValues.put("MESSAGES",MESSAGES );
//        contentValues.put("RESERVATIONS",RESERVATIONS );
//        contentValues.put("SECURITY_QUESTION_1",SECURITY_QUESTION_1 );
//        contentValues.put("SECURITY_ANSWER_1", SECURITY_ANSWER_1);
//        contentValues.put("SECURITY_QUESTION_2",SECURITY_QUESTION_2 );
//        contentValues.put("SECURITY_ANSWER_2",SECURITY_ANSWER_2 );
//        contentValues.put("SECURITY_QUESTION_3", SECURITY_QUESTION_3);
//        contentValues.put("SECURITY_ANSWER_3",SECURITY_ANSWER_3 );
//
////        sqLiteDatabase.insert("user_info", null,contentValues);
//        sqLiteDatabase.update("user_info",  contentValues, "id=?", new String[] {Integer.toString(id)});
//        return true;
//    }
//
//
//    /*
//    deleteContact deletes existing contacts.
//    Can be used as delete feature
//     */
//    public Integer deleteContact (Integer id) {
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        return sqLiteDatabase.delete("contacts",
//                "id = ? ",
//                new String[] { Integer.toString(id) });
//    }
//
//    public ArrayList<String> getAllUserInfo() {
//        ArrayList<String> array_list = new ArrayList<String>();
//
//        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
//        Cursor res =  sqLiteDatabase.rawQuery( "select * from user_info", null );
//        res.moveToFirst();
//
//        while(!res.isAfterLast()){
//            array_list.add(res.getString(res.getColumnIndex(Col_1)));
//            res.moveToNext();
//        }
//        return array_list;
//    }

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
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
    public static final String COL_12 = "SECURITY_QUESTION2";
    public static final String COL_13 = "SECURITY_QUESTION3";
    public static final String COL_14 = "SECURITY_ANSWER1";
    public static final String COL_15 = "SECURITY_ANSWER2";
    public static final String COL_16 = "SECURITY_ANSWER3";

    public static final String TABLE_NAME_2 = "RESERVATION_TABLE";
    public static final String RCOL_1 = "ID";
    public static final String RCOL_2 = "FIRST_NAME";
    public static final String RCOL_3 = "LAST_NAME";
    public static final String RCOL_4 = "PHONE_NUMBER";
    public static final String RCOL_5 = "RESTAURANT_NAME";
    public static final String RCOL_6 = "TIME_OF_RESERVATION";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT,LAST_NAME TEXT,PHONE_NUMBER TEXT, EMAIL TEXT, PASSWORD TEXT," +
                "OLD_PASSWORD TEXT, REVIEWS TEXT, MESSAGES TEXT, RESERVATIONS TEXT, SECURITY_QUESTION1 TEXT,SECURITY_QUESTION2 TEXT, SECURITY_QUESTION3 TEXT," +
                "SECURITY_ANSWER1 TEXT, SECURITY_ANSWER2 TEXT, SECURITY_ANSWER3 TEXT)");

        db.execSQL("create table " + TABLE_NAME_2 +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT,LAST_NAME TEXT,PHONE_NUMBER TEXT, RESTAURANT_NAME TEXT," +
                "TIME_OF_RESERVATION TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_2);
        onCreate(db);
    }

    public boolean insertData(String FIRST_NAME,String LAST_NAME,String PHONE_NUMBER, String EMAIL, String PASSWORD, String OLDPASSWORD,
                              String REVIEWS, String MESSAGES, String RESERVATION, String SECURITY_QUESTION1, String SECURITY_QUESTION2, String SECURITY_QUESTION3,
                              String SECURITY_ANSWER1, String SECURITY_ANSWER2, String SECURITY_ANSWER3) {
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
        contentValues.put(COL_12,SECURITY_QUESTION2);
        contentValues.put(COL_13,SECURITY_QUESTION3);
        contentValues.put(COL_14,SECURITY_ANSWER1);
        contentValues.put(COL_15,SECURITY_ANSWER2);
        contentValues.put(COL_16,SECURITY_ANSWER3);

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


    public boolean updateData(String id,String FIRST_NAME,String LAST_NAME,String PHONE_NUMBER, String EMAIL, String PASSWORD, String OLDPASSWORD,
                              String REVIEWS, String MESSAGES, String RESERVATION, String SECURITY_QUESTION1, String SECURITY_QUESTION2,
                              String SECURITY_QUESTION3, String SECURITY_ANSWER1, String SECURITY_ANSWER2, String SECURITY_ANSWER3) {
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
        if(!(SECURITY_QUESTION2.equals(""))){
            contentValues.put(COL_12,SECURITY_QUESTION2);}
        if(!(SECURITY_QUESTION3.equals(""))){
            contentValues.put(COL_13, SECURITY_QUESTION3);}
        if(!(SECURITY_ANSWER1.equals(""))){
            contentValues.put(COL_14, SECURITY_ANSWER1);}
        if(!(SECURITY_ANSWER2.equals(""))) {
            contentValues.put(COL_15, SECURITY_ANSWER2);}
        if(!(SECURITY_ANSWER3.equals(""))){
            contentValues.put(COL_16, SECURITY_ANSWER3);}
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }

    public boolean insertDataReservation(String FIRST_NAME,String LAST_NAME,String PHONE_NUMBER,String RESTAURANT_NAME,String TIME_OF_RESERVATION ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RCOL_2,FIRST_NAME);
        contentValues.put(RCOL_3,LAST_NAME);
        contentValues.put(RCOL_4,PHONE_NUMBER);
        contentValues.put(RCOL_5,RESTAURANT_NAME);
        contentValues.put(RCOL_6,TIME_OF_RESERVATION);

        long result = db.insert(TABLE_NAME_2,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllDataReservation() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME_2,null);
        return res;
    }

    public Cursor getUsersReservation(String PHONE_NUMBER){
        SQLiteDatabase db = this.getWritableDatabase();
        //if (PHONE_NUMBER.length() != 0) {
        String[] args = new String[1];
        args[0] = "%"+PHONE_NUMBER+"%";
        //}
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME_2 + " WHERE " + RCOL_4 + " LIKE " + args, null);
        return res;

    }

    public boolean updateDataReservation(String id,String FIRST_NAME,String LAST_NAME,String PHONE_NUMBER,String RESTAURANT_NAME,String TIME_OF_RESERVATION)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RCOL_1,id);
        if(!(FIRST_NAME.equals(""))){
            contentValues.put(RCOL_2,FIRST_NAME);}
        if(!(LAST_NAME.equals(""))){
            contentValues.put(RCOL_3,LAST_NAME);}
        if(!(PHONE_NUMBER.equals(""))){
            contentValues.put(RCOL_4,PHONE_NUMBER);}
        if(!(RESTAURANT_NAME.equals(""))){
            contentValues.put(RCOL_5,RESTAURANT_NAME);}
        if(!(TIME_OF_RESERVATION.equals(""))){
            contentValues.put(RCOL_6,TIME_OF_RESERVATION);}

        db.update(TABLE_NAME_2, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteDataReservation (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_2, "ID = ?",new String[] {id});
    }

}


