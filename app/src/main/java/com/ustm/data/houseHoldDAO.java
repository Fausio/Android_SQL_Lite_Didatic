package com.ustm.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ustm.domains.household;

public class houseHoldDAO {

    private connection  ctn;
    private SQLiteDatabase db;

    public houseHoldDAO(Context ctx ){

        ctn = new connection(ctx);
        db = ctn.getWritableDatabase();
    }

    public  long add(household model){

        ContentValues v = new ContentValues();
        v.put("name",model.getName());
        v.put("address",model.getAddress());
        v.put("cell",model.getCell().toString());

        return db.insert("household", null,v);
    }
}
