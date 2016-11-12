package com.mohanfoundation.mohanfoundation.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mohanfoundation.mohanfoundation.DBhelper;
import com.mohanfoundation.mohanfoundation.DataObjectEyeBank;
import com.mohanfoundation.mohanfoundation.models.EyeBank;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dell on 13-11-2016.
 */

public class EyeBackRepo {

    private DBhelper dbHelper;

    public EyeBackRepo(Context context) { dbHelper = new DBhelper(context);  }



    public int insert(Collection<EyeBank> eyeBanks) {

        long id=0;

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (EyeBank eyeBankObject : eyeBanks) {

            System.out.println(eyeBankObject.city);
            System.out.println(eyeBankObject.state);
            System.out.println(eyeBankObject.nameOfEyebank);
            System.out.println(eyeBankObject.phone);
            System.out.println(eyeBankObject.email);
            System.out.println(eyeBankObject.postalAddress);


            values.put(EyeBank.KEY_state, eyeBankObject.state);
            values.put(EyeBank.KEY_city, eyeBankObject.city);
            values.put(EyeBank.KEY_nameOfEyebank, eyeBankObject.nameOfEyebank);
            values.put(EyeBank.KEY_phone, eyeBankObject.phone);
            values.put(EyeBank.KEY_email, eyeBankObject.email);
            values.put(EyeBank.KEY_postalAddress, eyeBankObject.postalAddress);


            // Inserting Row
            id = db.insert(EyeBank.TABLE, null, values);

        }



        db.close(); // Closing database connection
        return (int) id;

    }

    public ArrayList<EyeBank> getDataSets()
    {
    //Open connection to read only
    SQLiteDatabase db = dbHelper.getReadableDatabase();
    String selectQuery = "SELECT  " +
            EyeBank.KEY_email+ "," +
            EyeBank.KEY_state + "," +
            EyeBank.KEY_city + "," +
            EyeBank.KEY_nameOfEyebank + "," +
            EyeBank.KEY_phone + "," +
            EyeBank.KEY_postalAddress +
            " FROM " + EyeBank.TABLE+
            "  ;";

    //Student student = new Student();
    ArrayList<EyeBank> eyeBankList = new ArrayList<>();

    Cursor cursor = db.rawQuery(selectQuery, null);
    // looping through all rows and adding to list

    if (cursor.moveToFirst()) {
        do {
            EyeBank eyeBank = new EyeBank();
            eyeBank.city= cursor.getString(cursor.getColumnIndex(EyeBank.KEY_city));
            eyeBank.state= cursor.getString(cursor.getColumnIndex(EyeBank.KEY_state));
            eyeBank.phone= cursor.getString(cursor.getColumnIndex(EyeBank.KEY_phone));
            eyeBank.postalAddress= cursor.getString(cursor.getColumnIndex(EyeBank.KEY_postalAddress));
            eyeBank.email= cursor.getString(cursor.getColumnIndex(EyeBank.KEY_email));
            eyeBank.nameOfEyebank= cursor.getString(cursor.getColumnIndex(EyeBank.KEY_nameOfEyebank));

            eyeBankList.add(eyeBank);

        } while (cursor.moveToNext());
    }

    cursor.close();
    db.close();
    return eyeBankList;

    }
    public ArrayList<EyeBank> getSearchResultDataSet(String searchQuery)
    {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                EyeBank.KEY_email+ "," +
                EyeBank.KEY_state + "," +
                EyeBank.KEY_city + "," +
                EyeBank.KEY_nameOfEyebank + "," +
                EyeBank.KEY_phone + "," +
                EyeBank.KEY_postalAddress +
                " FROM " + EyeBank.TABLE+
                " WHERE " +EyeBank.KEY_city+
                " = '"+searchQuery+"';";


        //Student student = new Student();
        ArrayList<EyeBank> eyeBankList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                EyeBank eyeBank = new EyeBank();
                eyeBank.city= cursor.getString(cursor.getColumnIndex(EyeBank.KEY_city));
                eyeBank.state= cursor.getString(cursor.getColumnIndex(EyeBank.KEY_state));
                eyeBank.phone= cursor.getString(cursor.getColumnIndex(EyeBank.KEY_phone));
                eyeBank.postalAddress= cursor.getString(cursor.getColumnIndex(EyeBank.KEY_postalAddress));
                eyeBank.email= cursor.getString(cursor.getColumnIndex(EyeBank.KEY_email));
                eyeBank.nameOfEyebank= cursor.getString(cursor.getColumnIndex(EyeBank.KEY_nameOfEyebank));

                eyeBankList.add(eyeBank);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return eyeBankList;

    }
}
