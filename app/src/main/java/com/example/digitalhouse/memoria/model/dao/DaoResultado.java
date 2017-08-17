package com.example.digitalhouse.memoria.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.digitalhouse.memoria.model.pojo.Resultado;
import com.example.digitalhouse.memoria.util.ResultadoDB;

import java.util.List;

/**
 * Created by digitalhouse on 17/08/17.
 */

public class DaoResultado extends ResultadoDB {

    public static final String RESULTADO_TABLE = "resultadoTabla";
    public static final String RESULTADO_DATE = "resultadoDate";
    public static final String RESULTADO_VAL = "resultadoVal";

    private Context context;


    public DaoResultado(Context context) {
        super(context);
        this.context = context;
    }

    public void agregarResultado(Resultado resultado){
        SQLiteDatabase resultadoDB = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RESULTADO_DATE,resultado.getFecha().toString());
        contentValues.put(RESULTADO_VAL, resultado.getResultado());
        resultadoDB.insert(RESULTADO_TABLE, null,contentValues);
    }

    public Integer traerResultadosTrue(){
        String query = "SELECT * FROM " + RESULTADO_TABLE
                + " WHERE " + RESULTADO_VAL + " = " + 1;
        SQLiteDatabase resultadoDB = getReadableDatabase();
        Cursor cursor = resultadoDB.rawQuery(query, null);

        return cursor.getCount();
    }

    public Integer traerResultadosFalse(){
        String query = "SELECT * FROM " + RESULTADO_TABLE
                + " WHERE " + RESULTADO_VAL + " = " + 0;
        SQLiteDatabase resultadoDB = getReadableDatabase();
        Cursor cursor = resultadoDB.rawQuery(query, null);
        return cursor.getCount();
    }

}
