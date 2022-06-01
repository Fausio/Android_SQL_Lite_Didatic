package com.ustm.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ustm.domains.household;

import java.util.ArrayList;
import java.util.List;

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

    public List<household> read(){

          List<household> households = new ArrayList<>();
           Cursor cursor = db.query("household", new String[]{"id","name","address","cell"},null,null,null,null,null);

           while (cursor.moveToNext()){

               household data = new household();
               data.setId(cursor.getInt(0));
               data.setName(cursor.getString(1));
               data.setAddress(cursor.getString(2));
               data.setCell(cursor.getInt(3));

               households.add(data);
           }

        return households;
    }
}
