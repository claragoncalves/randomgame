package com.example.digitalhouse.memoria.model.pojo;

import java.util.Date;

/**
 * Created by digitalhouse on 17/08/17.
 */

public class Resultado {
    private Date fecha;
    private Boolean resultado;

    public Resultado(Boolean resultado) {
        this.fecha = new Date();
        this.resultado = resultado;
    }

    public Boolean getResultado() {
        return resultado;
    }

    public Date getFecha() {
        return fecha;
    }
}
