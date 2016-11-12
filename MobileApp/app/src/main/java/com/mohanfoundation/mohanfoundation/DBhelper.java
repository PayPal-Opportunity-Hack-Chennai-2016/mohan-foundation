package com.mohanfoundation.mohanfoundation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mohanfoundation.mohanfoundation.models.EyeBank;

/**
 * Created by dell on 12-11-2016.
 */

public class DBhelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "Test.db";

    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_TABLE_EYE_BANK = "CREATE TABLE " + EyeBank.TABLE + "("
                + EyeBank.KEY_state + " TEXT,"
                + EyeBank.KEY_city + " TEXT,"
                + EyeBank.KEY_nameOfEyebank + " TEXT,"
                + EyeBank.KEY_email + " TEXT,"
                + EyeBank.KEY_phone + " TEXT,"
                + EyeBank.KEY_postalAddress + " TEXT)";

        db.execSQL(CREATE_TABLE_EYE_BANK);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EyeBank.TABLE);

        // Create tables again
        onCreate(db);

    }
}
