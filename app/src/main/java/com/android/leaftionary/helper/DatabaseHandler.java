package com.android.leaftionary.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.leaftionary.configuration.Config;

/**
 * Created by Kevin on 12/13/2014.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, Config.DB_NAME, null, Config.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + Config.DB_TBL_PLANTS + " " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Config.DBFIELD_LABEL_NAME + " TEXT, " +
                Config.DBFIELD_SCI_NAME + " TEXT, " +
                Config.DBFIELD_COMMON_NAME + " TEXT, " +
                Config.DBFIELD_VERN_NAME + " TEXT, " +
                Config.DBFIELD_DESC + " TEXT, " +
                Config.DBFIELD_DISTRIBUTION + " TEXT, " +
                Config.DBFIELD_CONSTITUENTS + " TEXT, " +
                Config.DBFIELD_PROPERTIES + " TEXT, " +
                Config.DBFIELD_PARTS_USED + " TEXT) ");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + Config.DB_TBL_IMAGES + " " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Config.DBFIELD_FILENAME + " TEXT, " +
                Config.DBFIELD_PLANT_ID_FK + " INTEGER) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Config.DB_TBL_PLANTS);
        db.execSQL("DROP TABLE IF EXISTS " + Config.DB_TBL_IMAGES);

        onCreate(db);
    }
}
