package com.mohanfoundation.mohanfoundation.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mohanfoundation.mohanfoundation.DBhelper;
import com.mohanfoundation.mohanfoundation.models.NGOlist;
import com.mohanfoundation.mohanfoundation.models.TrasnplantHospital;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dell on 13-11-2016.
 */

public class TransplantRepo {
    private DBhelper dbHelper;

    public TransplantRepo(Context context) {
        dbHelper = new DBhelper(context);
    }


    public int insert(Collection<TrasnplantHospital> eyeBanks) {

        long id = 0;

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (TrasnplantHospital eyeBankObject : eyeBanks) {

            values.put(TrasnplantHospital.KEY_organCategory, eyeBankObject.organCategory);
            values.put(TrasnplantHospital.KEY_state, eyeBankObject.state);
            values.put(TrasnplantHospital.KEY_city, eyeBankObject.city);
            values.put(TrasnplantHospital.KEY_hospitalName, eyeBankObject.hospitalName);
            values.put(TrasnplantHospital.KEY_phone, eyeBankObject.phone);
            values.put(TrasnplantHospital.KEY_postalAddress, eyeBankObject.postalAddress);


            // Inserting Row
            id = db.insert(TrasnplantHospital.TABLE, null, values);

        }


        db.close(); // Closing database connection
        return (int) id;

    }

    public ArrayList<TrasnplantHospital> getDataSets() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                TrasnplantHospital.KEY_organCategory + "," +
                TrasnplantHospital.KEY_city + "," +
                TrasnplantHospital.KEY_hospitalName + "," +
                TrasnplantHospital.KEY_phone + "," +
                TrasnplantHospital.KEY_postalAddress +
                " FROM " + TrasnplantHospital.TABLE +
                "  ;";

        //Student student = new Student();
        ArrayList<TrasnplantHospital> eyeBankList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                TrasnplantHospital eyeBank = new TrasnplantHospital();
                eyeBank.city = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_city));
                eyeBank.organCategory = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_organCategory));
                eyeBank.phone = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_phone));
                eyeBank.postalAddress = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_postalAddress));
                eyeBank.hospitalName = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_hospitalName));

                eyeBankList.add(eyeBank);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return eyeBankList;

    }

    public ArrayList<TrasnplantHospital> getSearchResultDataSetCity(String searchQuery) {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                TrasnplantHospital.KEY_organCategory + "," +
                TrasnplantHospital.KEY_city + "," +
                TrasnplantHospital.KEY_hospitalName + "," +
                TrasnplantHospital.KEY_phone + "," +
                TrasnplantHospital.KEY_postalAddress +
                " FROM " + TrasnplantHospital.TABLE +
                " WHERE " + TrasnplantHospital.KEY_city +
                " LIKE '" + searchQuery + "%';";


        //Student student = new Student();
        ArrayList<TrasnplantHospital> eyeBankList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                TrasnplantHospital eyeBank = new TrasnplantHospital();
                eyeBank.city = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_city));
                eyeBank.organCategory = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_organCategory));
                eyeBank.phone = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_phone));
                eyeBank.postalAddress = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_postalAddress));
                eyeBank.hospitalName = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_hospitalName));

                eyeBankList.add(eyeBank);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return eyeBankList;

    }

    public ArrayList<TrasnplantHospital> getSearchResultDataSetOrgan(String searchQuery) {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                TrasnplantHospital.KEY_organCategory + "," +
                TrasnplantHospital.KEY_city + "," +
                TrasnplantHospital.KEY_hospitalName + "," +
                TrasnplantHospital.KEY_phone + "," +
                TrasnplantHospital.KEY_postalAddress +
                " FROM " + TrasnplantHospital.TABLE +
                " WHERE " + TrasnplantHospital.KEY_organCategory +
                " LIKE '" + searchQuery + "%';";


        //Student student = new Student();
        ArrayList<TrasnplantHospital> eyeBankList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                TrasnplantHospital eyeBank = new TrasnplantHospital();
                eyeBank.city = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_city));
                eyeBank.organCategory = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_organCategory));
                eyeBank.phone = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_phone));
                eyeBank.postalAddress = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_postalAddress));
                eyeBank.hospitalName = cursor.getString(cursor.getColumnIndex(TrasnplantHospital.KEY_hospitalName));

                eyeBankList.add(eyeBank);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return eyeBankList;

    }
}
