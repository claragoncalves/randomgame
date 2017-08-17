package com.example.digitalhouse.memoria.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.digitalhouse.memoria.model.dao.DaoResultado.RESULTADO_DATE;
import static com.example.digitalhouse.memoria.model.dao.DaoResultado.RESULTADO_TABLE;
import static com.example.digitalhouse.memoria.model.dao.DaoResultado.RESULTADO_VAL;

/**
 * Created by digitalhouse on 17/08/17.
 */

public class ResultadoDB extends SQLiteOpenHelper{

    public static final String RESULTADO_DB= "resultadoDB";
    public static final Integer VERSION_DB= 1;


    public ResultadoDB(Context context) {
        super(context, RESULTADO_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + RESULTADO_TABLE + " ("
                + RESULTADO_DATE + " DATE PRIMARY KEY NOT NULL, "
                + RESULTADO_VAL + " BOOLEAN NOT NULL)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
