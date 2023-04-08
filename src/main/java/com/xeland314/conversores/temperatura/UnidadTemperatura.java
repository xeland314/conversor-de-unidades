package com.xeland314.conversores.temperatura;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;

import com.xeland314.conversores.UnidadBase;

public class UnidadTemperatura extends UnidadBase {

    public UnidadTemperatura(String nombre, String simbolo, Map<String, Function<BigDecimal, BigDecimal>> formulas) {
        super(nombre, simbolo, formulas);
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof UnidadTemperatura)) {
            return false;
        }
        UnidadTemperatura other = (UnidadTemperatura) o;
        return this.nombre == other.getNombre() && this.simbolo == other.getSimbolo();
    }

}
