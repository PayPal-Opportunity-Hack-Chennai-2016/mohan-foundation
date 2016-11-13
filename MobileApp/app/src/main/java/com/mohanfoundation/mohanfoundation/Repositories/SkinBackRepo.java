package com.mohanfoundation.mohanfoundation.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mohanfoundation.mohanfoundation.DBhelper;
import com.mohanfoundation.mohanfoundation.models.EyeBank;
import com.mohanfoundation.mohanfoundation.models.SkinBank;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dell on 13-11-2016.
 */

public class SkinBackRepo {

    private DBhelper dbHelper;

    public SkinBackRepo(Context context) {
        dbHelper = new DBhelper(context);
    }


    public int insert(Collection<SkinBank> skinBanks) {

        long id = 0;

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (SkinBank skinBankObject : skinBanks) {

            values.put(SkinBank.KEY_state, skinBankObject.state);
            values.put(SkinBank.KEY_city, skinBankObject.city);
            values.put(SkinBank.KEY_nameOfSkinbank, skinBankObject.nameOfSkinbank);
            values.put(SkinBank.KEY_phone, skinBankObject.phone);
            values.put(SkinBank.KEY_postalAddress, skinBankObject.postalAddress);


            // Inserting Row
            id = db.insert(SkinBank.TABLE, null, values);

        }


        db.close(); // Closing database connection
        return (int) id;

    }

    public ArrayList<SkinBank> getDataSets() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                SkinBank.KEY_state + "," +
                SkinBank.KEY_city + "," +
                SkinBank.KEY_nameOfSkinbank + "," +
                SkinBank.KEY_phone + "," +
                SkinBank.KEY_postalAddress +
                " FROM " +  SkinBank.TABLE +
                "  ;";

        //Student student = new Student();
        ArrayList<SkinBank> skinBankList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                SkinBank skinBank = new SkinBank();
                skinBank.city = cursor.getString(cursor.getColumnIndex(SkinBank.KEY_city));
                skinBank.state = cursor.getString(cursor.getColumnIndex(SkinBank.KEY_state));
                skinBank.phone = cursor.getString(cursor.getColumnIndex(SkinBank.KEY_phone));
                skinBank.postalAddress = cursor.getString(cursor.getColumnIndex(SkinBank.KEY_postalAddress));
                skinBank.nameOfSkinbank = cursor.getString(cursor.getColumnIndex(SkinBank.KEY_nameOfSkinbank));

                skinBankList.add(skinBank);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return skinBankList;

    }

    public ArrayList<SkinBank> getSearchResultDataSet(String searchQuery) {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                SkinBank.KEY_state + "," +
                SkinBank.KEY_city + "," +
                SkinBank.KEY_nameOfSkinbank + "," +
                SkinBank.KEY_phone + "," +
                SkinBank.KEY_postalAddress +
                " FROM " + SkinBank.TABLE +
                " WHERE " + SkinBank.KEY_city +
                " LIKE '" + searchQuery + "%';";


        //Student student = new Student();
        ArrayList<SkinBank> skinBankList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                SkinBank skinBank = new SkinBank();
                skinBank.city = cursor.getString(cursor.getColumnIndex(EyeBank.KEY_city));
                skinBank.state = cursor.getString(cursor.getColumnIndex(EyeBank.KEY_state));
                skinBank.phone = cursor.getString(cursor.getColumnIndex(EyeBank.KEY_phone));
                skinBank.postalAddress = cursor.getString(cursor.getColumnIndex(EyeBank.KEY_postalAddress));
                skinBank.nameOfSkinbank = cursor.getString(cursor.getColumnIndex(EyeBank.KEY_nameOfEyebank));

                skinBankList.add(skinBank);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return  skinBankList ;

    }
}
