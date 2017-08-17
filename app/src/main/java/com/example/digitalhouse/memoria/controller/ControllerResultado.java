package com.example.digitalhouse.memoria.controller;

import android.content.Context;

import com.example.digitalhouse.memoria.model.dao.DaoResultado;
import com.example.digitalhouse.memoria.model.pojo.Resultado;

/**
 * Created by digitalhouse on 17/08/17.
 */

public class ControllerResultado {
    public void agregarResultadoDB(Resultado resultado, Context context){
        DaoResultado daoResultado = new DaoResultado(context);
        daoResultado.agregarResultado(resultado);
    }

    public Integer verResultados(Context context){
        DaoResultado daoResultado = new DaoResultado(context);
        Integer resTrue = daoResultado.traerResultadosTrue();
        Integer resFalse = daoResultado.traerResultadosFalse();
        return resTrue*100/(resTrue+resFalse);
    }

}
