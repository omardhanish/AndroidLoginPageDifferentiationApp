package com.example.android.androidloginpagedifferentiationapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by omar on 24-01-2017.
 */
public class DatabaseHelperConnector extends SQLiteOpenHelper {

    private static final int Version =1;

    private static final String firstName="FIRST_NAME";
    private static final String lastName="LAST_NAME";
    private static final String email="EMAIL";
    private static final String userType="USER_TYPE";
    private static final String username="USERNAME";
    private static final String password="PASSWORD";
    private static final String databaseName="FORM";
    private static final String tableName="USER_RECORDS";
    private static final String id = "ID";


    public DatabaseHelperConnector(Context context) {
        super(context, databaseName, null, Version);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        String createTableSQL = "CREATE TABLE " + tableName + " (" + id +" INTEGER NOT NULL PRIMARY KEY, " + firstName +" TEXT, " + lastName
                + " TEXT, " +email + " TEXT, " + userType + " TEXT, " + username + " TEXT, " + password + " TEXT)";
        database.execSQL(createTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addRecord(String firstname, String lastname, String emailAddress, String utype, String uname, String pword ) {
        String insertSQL = "INSERT INTO " + tableName + " (" + firstName + ", " + lastName + " ," + email + " ," + userType + " ," + username + " ," + password + ") "
                + "VALUES" + " ('" + firstname + "', '" + lastname + "', '" + emailAddress + "', '" + utype + "', '" + uname + "', '" + pword + "')" ;
        SQLiteDatabase dataBase = this.getWritableDatabase();
        dataBase.execSQL(insertSQL);
        dataBase.close();
    }


    public List<String> getRecord(String uname, String pword) {
        List<String> recordList = new ArrayList<String>();
        SQLiteDatabase dataBase = this.getReadableDatabase();
        String getSQL = "SELECT * FROM " + tableName + " WHERE " + username + " = '" + uname + "' AND " + password + " = '" + pword + "'";
        Cursor cursor = dataBase.rawQuery(getSQL , null);
        cursor.moveToFirst();
        String fName = cursor.getString(1);
        String lName = cursor.getString(2);
        String eMail = cursor.getString(3);
        String userType = cursor.getString(4);
        recordList.add(fName);
        recordList.add(lName);
        recordList.add(eMail);
        recordList.add(userType);
        dataBase.close();
        return recordList;
    }

}
