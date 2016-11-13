package com.mohanfoundation.mohanfoundation.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mohanfoundation.mohanfoundation.DBhelper;
import com.mohanfoundation.mohanfoundation.models.EyeBank;
import com.mohanfoundation.mohanfoundation.models.NGOlist;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dell on 13-11-2016.
 */

public class NgoListRepo {

    private DBhelper dbHelper;

    public NgoListRepo(Context context) {
        dbHelper = new DBhelper(context);
    }


    public int insert(Collection<NGOlist> eyeBanks) {

        long id = 0;

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (NGOlist eyeBankObject : eyeBanks) {

            values.put(NGOlist.KEY_state, eyeBankObject.state);
            values.put(NGOlist.KEY_city, eyeBankObject.city);
            values.put(NGOlist.KEY_ngoName, eyeBankObject.nameOfNgo);
            values.put(NGOlist.KEY_phone, eyeBankObject.phone);
            values.put(NGOlist.KEY_postalAddress, eyeBankObject.postalAddress);


            // Inserting Row
            id = db.insert(NGOlist.TABLE, null, values);

        }


        db.close(); // Closing database connection
        return (int) id;

    }

    public ArrayList<NGOlist> getDataSets() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                NGOlist.KEY_state + "," +
                NGOlist.KEY_city + "," +
                NGOlist.KEY_ngoName + "," +
                NGOlist.KEY_phone + "," +
                NGOlist.KEY_postalAddress +
                " FROM " + NGOlist.TABLE +
                "  ;";

        //Student student = new Student();
        ArrayList<NGOlist> eyeBankList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                NGOlist eyeBank = new NGOlist();
                eyeBank.city = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_city));
                eyeBank.state = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_state));
                eyeBank.phone = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_phone));
                eyeBank.postalAddress = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_postalAddress));
                eyeBank.nameOfNgo = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_ngoName));

                eyeBankList.add(eyeBank);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return eyeBankList;

    }

    public ArrayList<NGOlist> getSearchResultDataSetCity(String searchQuery) {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                NGOlist.KEY_state + "," +
                NGOlist.KEY_city + "," +
                NGOlist.KEY_ngoName + "," +
                NGOlist.KEY_phone + "," +
                NGOlist.KEY_postalAddress +
                " FROM " + NGOlist.TABLE +
                " WHERE " + NGOlist.KEY_city +
                " LIKE '" + searchQuery + "%';";


        //Student student = new Student();
        ArrayList<NGOlist> eyeBankList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                NGOlist eyeBank = new NGOlist();
                eyeBank.city = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_city));
                eyeBank.state = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_state));
                eyeBank.phone = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_phone));
                eyeBank.postalAddress = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_postalAddress));
                eyeBank.nameOfNgo = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_ngoName));

                eyeBankList.add(eyeBank);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return eyeBankList;

    }

    public ArrayList<NGOlist> getSearchResultDataSetOrgan(String searchQuery) {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                NGOlist.KEY_state + "," +
                NGOlist.KEY_city + "," +
                NGOlist.KEY_ngoName + "," +
                NGOlist.KEY_phone + "," +
                NGOlist.KEY_postalAddress +
                " FROM " + NGOlist.TABLE +
                " WHERE " + NGOlist.KEY_city +
                " LIKE '" + searchQuery + "%';";


        //Student student = new Student();
        ArrayList<NGOlist> eyeBankList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                NGOlist eyeBank = new NGOlist();
                eyeBank.city = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_city));
                eyeBank.state = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_state));
                eyeBank.phone = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_phone));
                eyeBank.postalAddress = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_postalAddress));
                eyeBank.nameOfNgo = cursor.getString(cursor.getColumnIndex(NGOlist.KEY_ngoName));

                eyeBankList.add(eyeBank);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return eyeBankList;

    }
}
