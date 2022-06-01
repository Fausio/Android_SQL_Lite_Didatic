package com.ustm.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class connection extends SQLiteOpenHelper {

    private static final  String dbName = "household.db";
    private static final int version = 1;

    public connection(@Nullable Context context) {
        super(context, dbName, null, version);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDB) {
        sqLiteDB.execSQL("Create table household(" +
                         "id integer primary key autoincrement," +
                         "name varchar(50)," +
                         "address varchar(255)," +
                         "cell integer ) ");

        sqLiteDB.execSQL("Create table member(" +
                         "id integer primary key autoincrement," +
                         "name varchar(50)," +
                         "gender varchar(50)," +
                         "Birthdate varchar(50))");

        sqLiteDB.execSQL("ALTER TABLE member ADD COLUMN household_id INTEGER REFERENCES household(id);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                          int i,
                          int i1) {

    }
}
