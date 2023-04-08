package com.xeland314.conversores.longitud;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;

import com.xeland314.conversores.UnidadBase;

public class UnidadLongitud extends UnidadBase {

    public UnidadLongitud(String nombre, String simbolo, Map<String, Function<BigDecimal, BigDecimal>> formulas) {
        super(nombre, simbolo, formulas);
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof UnidadLongitud)) {
            return false;
        }
        UnidadLongitud other = (UnidadLongitud) o;
        return this.nombre == other.getNombre() && this.simbolo == other.getSimbolo();
    }

}
