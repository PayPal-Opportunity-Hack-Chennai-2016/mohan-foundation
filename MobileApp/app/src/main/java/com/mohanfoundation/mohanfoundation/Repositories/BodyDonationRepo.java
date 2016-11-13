package com.mohanfoundation.mohanfoundation.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mohanfoundation.mohanfoundation.DBhelper;
import com.mohanfoundation.mohanfoundation.models.BodyDonation;
import com.mohanfoundation.mohanfoundation.models.EyeBank;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dell on 13-11-2016.
 */

public class BodyDonationRepo {

    private DBhelper dbHelper;

    public BodyDonationRepo(Context context) {
        dbHelper = new DBhelper(context);
    }


    public int insert(Collection<BodyDonation> bodyDonations) {

        long id = 0;

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (BodyDonation bodyDonationObject : bodyDonations) {

            values.put(BodyDonation.KEY_state, bodyDonationObject.state);
            values.put(BodyDonation.KEY_city, bodyDonationObject.city);
            values.put(BodyDonation.KEY_nameOfBodydonation, bodyDonationObject.nameOfBodydonation);
            values.put(BodyDonation.KEY_phone, bodyDonationObject.phone);
            values.put(BodyDonation.KEY_postalAddress, bodyDonationObject.postalAddress);


            // Inserting Row
            id = db.insert(BodyDonation.TABLE, null, values);

        }


        db.close(); // Closing database connection
        return (int) id;

    }

    public ArrayList<BodyDonation> getDataSets() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                BodyDonation.KEY_state + "," +
                BodyDonation.KEY_city + "," +
                BodyDonation.KEY_nameOfBodydonation + "," +
                BodyDonation.KEY_phone + "," +
                BodyDonation.KEY_postalAddress +
                " FROM " + BodyDonation.TABLE +
                "  ;";

        //Student student = new Student();
        ArrayList<BodyDonation> eyeBankList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                BodyDonation eyeBank = new BodyDonation();
                eyeBank.city = cursor.getString(cursor.getColumnIndex(BodyDonation.KEY_city));
                eyeBank.state = cursor.getString(cursor.getColumnIndex(BodyDonation.KEY_state));
                eyeBank.phone = cursor.getString(cursor.getColumnIndex(BodyDonation.KEY_phone));
                eyeBank.postalAddress = cursor.getString(cursor.getColumnIndex(BodyDonation.KEY_postalAddress));
                eyeBank.nameOfBodydonation = cursor.getString(cursor.getColumnIndex(BodyDonation.KEY_nameOfBodydonation));

                eyeBankList.add(eyeBank);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return eyeBankList;

    }

    public ArrayList<BodyDonation> getSearchResultDataSet(String searchQuery) {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                BodyDonation.KEY_state + "," +
                BodyDonation.KEY_city + "," +
                BodyDonation.KEY_nameOfBodydonation + "," +
                BodyDonation.KEY_phone + "," +
                BodyDonation.KEY_postalAddress +
                " FROM " + BodyDonation.TABLE +
                " WHERE " + BodyDonation.KEY_city +
                " LIKE '" + searchQuery + "%';";


        //Student student = new Student();
        ArrayList<BodyDonation> eyeBankList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                BodyDonation eyeBank = new BodyDonation();
                eyeBank.city = cursor.getString(cursor.getColumnIndex(BodyDonation.KEY_city));
                eyeBank.state = cursor.getString(cursor.getColumnIndex(BodyDonation.KEY_state));
                eyeBank.phone = cursor.getString(cursor.getColumnIndex(BodyDonation.KEY_phone));
                eyeBank.postalAddress = cursor.getString(cursor.getColumnIndex(BodyDonation.KEY_postalAddress));
                eyeBank.nameOfBodydonation = cursor.getString(cursor.getColumnIndex(BodyDonation.KEY_nameOfBodydonation));

                eyeBankList.add(eyeBank);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return eyeBankList;

    }
}
