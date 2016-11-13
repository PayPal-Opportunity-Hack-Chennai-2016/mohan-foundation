package com.mohanfoundation.mohanfoundation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mohanfoundation.mohanfoundation.models.BodyDonation;
import com.mohanfoundation.mohanfoundation.models.EyeBank;
import com.mohanfoundation.mohanfoundation.models.NGOlist;
import com.mohanfoundation.mohanfoundation.models.SkinBank;
import com.mohanfoundation.mohanfoundation.models.TrasnplantHospital;

/**
 * Created by dell on 12-11-2016.
 */

public class DBhelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Test1.db";

    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_TABLE_EYE_BANK = "CREATE TABLE " + EyeBank.TABLE + "("
                + EyeBank.KEY_state + " TEXT,"
                + EyeBank.KEY_city + " TEXT,"
                + EyeBank.KEY_nameOfEyebank + " TEXT,"
                + EyeBank.KEY_phone + " TEXT,"
                + EyeBank.KEY_postalAddress + " TEXT)";

        String CREATE_TABLE_SKIN_BANK = "CREATE TABLE " + SkinBank.TABLE + "("
                + SkinBank.KEY_state + " TEXT,"
                + SkinBank.KEY_city + " TEXT,"
                + SkinBank.KEY_nameOfSkinbank + " TEXT,"
                + SkinBank.KEY_phone + " TEXT,"
                + SkinBank.KEY_postalAddress + " TEXT)";

        String CREATE_TABLE_BODY_BANK = "CREATE TABLE " + BodyDonation.TABLE + "("
                + BodyDonation.KEY_state + " TEXT,"
                + BodyDonation.KEY_city + " TEXT,"
                + BodyDonation.KEY_nameOfBodydonation + " TEXT,"
                + BodyDonation.KEY_phone + " TEXT,"
                + BodyDonation.KEY_postalAddress + " TEXT)";

        String CREATE_TABLE_NGO = "CREATE TABLE " + NGOlist.TABLE + "("
                +NGOlist.KEY_state + " TEXT,"
                + NGOlist.KEY_city + " TEXT,"
                +NGOlist.KEY_ngoName + " TEXT,"
                + NGOlist.KEY_phone + " TEXT,"
                + NGOlist.KEY_postalAddress + " TEXT)";

        String CREATE_TABLE_TRANSPLANT = "CREATE TABLE " + TrasnplantHospital.TABLE + "("
                +TrasnplantHospital.KEY_state + " TEXT,"
                +TrasnplantHospital.KEY_organCategory + " TEXT,"
                + TrasnplantHospital.KEY_city + " TEXT,"
                +TrasnplantHospital.KEY_hospitalName + " TEXT,"
                + TrasnplantHospital.KEY_phone + " TEXT,"
                + TrasnplantHospital.KEY_postalAddress + " TEXT)";

        db.execSQL(CREATE_TABLE_EYE_BANK);
        db.execSQL(CREATE_TABLE_SKIN_BANK);
        db.execSQL(CREATE_TABLE_BODY_BANK);
        db.execSQL(CREATE_TABLE_NGO);
        db.execSQL(CREATE_TABLE_TRANSPLANT);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EyeBank.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SkinBank.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + BodyDonation.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + NGOlist.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TrasnplantHospital.TABLE);

        // Create tables again
        onCreate(db);

    }
}
