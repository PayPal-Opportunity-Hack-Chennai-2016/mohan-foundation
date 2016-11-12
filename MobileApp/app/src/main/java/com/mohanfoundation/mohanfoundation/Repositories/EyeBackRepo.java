package com.mohanfoundation.mohanfoundation.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.mohanfoundation.mohanfoundation.DBhelper;
import com.mohanfoundation.mohanfoundation.models.EyeBank;

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
}
