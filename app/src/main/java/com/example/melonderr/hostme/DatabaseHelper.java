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

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "user.db";
    public static final String TABLE_NAME = "user_info";
    public static final String Col_ID = "id";
    public static final String Col_1 = "FIRST_NAME";
    public static final String Col_2 = "LAST_NAME";
    public static final String Col_3 = "PHONE_NUMBER";
    public static final String Col_4 = "EMAIL";
//    public static final String Col_5 = "RESERVATIONS";
    public static final String Col_5 = "PASSWORD";
    public static final String Col_6 = "OLD_PASSWORD";
    public static final String Col_7 = "REVIEWS";
    public static final String Col_8 = "MESSAGES";
    public static final String Col_9 = "RESERVATIONS";
    public static final String Col_10 = "SECURITY_QUESTION_1";
    public static final String Col_11 = "SECURITY_ANSWER_1";
    public static final String Col_12 = "SECURITY_QUESTION_2";
    public static final String Col_13 = "SECURITY_ANSWER_2";
    public static final String Col_14 = "SECURITY_QUESTION_3";
    public static final String Col_15 = "SECURITY_ANSWER_3";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1
        );
    }
    /*
    onCreate will assign variable type that will be passed in the database.
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table contacts " +
                        "(id integer primary key, FIRST_NAME text, LAST_NAME text, PHONE_NUMBER text, " +
                                "EMAIL text, PASSWORD text, OLD_PASSWORD text, REVIEWS text, MESSAGES  text,  RESERVATIONS  text, SECURITY_QUESTION_1  text, " +
                                " SECURITY_ANSWER_1  text, SECURITY_QUESTION_2 text, SECURITY_ANSWER_2 text, SECURITY_QUESTION_3 text, SECURITY_ANSWER_3 text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        /*
        This function is if we were to upgrade/update the app and changed anything for the database,
        then the function will check if the old version matches new version

         */
    }

    public boolean insertContact ( String FIRST_NAME, String LAST_NAME, String PHONE_NUMBER, String EMAIL, String PASSWORD, String OLD_PASSWORD, String REVIEWS, String MESSAGES
                                      , String RESERVATIONS, String SECURITY_QUESTION_1, String SECURITY_ANSWER_1, String SECURITY_QUESTION_2, String SECURITY_ANSWER_2
                                      , String SECURITY_QUESTION_3, String SECURITY_ANSWER_3){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("FIRST_NAME", FIRST_NAME);
        contentValues.put("LAST_NAME", LAST_NAME);
        contentValues.put("PHONE_NUMBER", PHONE_NUMBER);
        contentValues.put("EMAIL", EMAIL);
        contentValues.put("PASSWORD",PASSWORD );
        contentValues.put("OLD_PASSWORD",OLD_PASSWORD );
        contentValues.put("REVIEWS",  REVIEWS );
        contentValues.put("MESSAGES",MESSAGES );
        contentValues.put("RESERVATIONS",RESERVATIONS );
        contentValues.put("SECURITY_QUESTION_1",SECURITY_QUESTION_1 );
        contentValues.put("SECURITY_ANSWER_1", SECURITY_ANSWER_1);
        contentValues.put("SECURITY_QUESTION_2",SECURITY_QUESTION_2 );
        contentValues.put("SECURITY_ANSWER_2",SECURITY_ANSWER_2 );
        contentValues.put("SECURITY_QUESTION_3", SECURITY_QUESTION_3);
        contentValues.put("SECURITY_ANSWER_3",SECURITY_ANSWER_3 );

        sqLiteDatabase.insert("user_info", null,contentValues);
        return true;
    }
    /*
    This function will get an user information based on their id.
     */
    public Cursor getData(int id)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from contacts where id="+id+"", null);
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(sqLiteDatabase, TABLE_NAME);
        return numRows;
    }
    /*
   this functions updates the existing contact information
    Can be used for update account feature
     */
    public boolean updateContact ( Integer id, String FIRST_NAME, String LAST_NAME, String PHONE_NUMBER, String EMAIL, String PASSWORD, String OLD_PASSWORD, String REVIEWS, String MESSAGES
            , String RESERVATIONS, String SECURITY_QUESTION_1, String SECURITY_ANSWER_1, String SECURITY_QUESTION_2, String SECURITY_ANSWER_2
            , String SECURITY_QUESTION_3, String SECURITY_ANSWER_3){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("FIRST_NAME", FIRST_NAME);
        contentValues.put("LAST_NAME", LAST_NAME);
        contentValues.put("PHONE_NUMBER", PHONE_NUMBER);
        contentValues.put("EMAIL", EMAIL);
        contentValues.put("PASSWORD",PASSWORD );
        contentValues.put("OLD_PASSWORD",OLD_PASSWORD );
        contentValues.put("REVIEWS",  REVIEWS );
        contentValues.put("MESSAGES",MESSAGES );
        contentValues.put("RESERVATIONS",RESERVATIONS );
        contentValues.put("SECURITY_QUESTION_1",SECURITY_QUESTION_1 );
        contentValues.put("SECURITY_ANSWER_1", SECURITY_ANSWER_1);
        contentValues.put("SECURITY_QUESTION_2",SECURITY_QUESTION_2 );
        contentValues.put("SECURITY_ANSWER_2",SECURITY_ANSWER_2 );
        contentValues.put("SECURITY_QUESTION_3", SECURITY_QUESTION_3);
        contentValues.put("SECURITY_ANSWER_3",SECURITY_ANSWER_3 );

//        sqLiteDatabase.insert("user_info", null,contentValues);
        sqLiteDatabase.update("user_info",  contentValues, "id=?", new String[] {Integer.toString(id)});
        return true;
    }


    /*
    deleteContact deletes existing contacts.
    Can be used as delete feature
     */
    public Integer deleteContact (Integer id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete("contacts",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllUserInfo() {
        ArrayList<String> array_list = new ArrayList<String>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor res =  sqLiteDatabase.rawQuery( "select * from user_info", null );
        res.moveToFirst();

        while(!res.isAfterLast()){
            array_list.add(res.getString(res.getColumnIndex(Col_1)));
            res.moveToNext();
        }
        return array_list;
    }


}
