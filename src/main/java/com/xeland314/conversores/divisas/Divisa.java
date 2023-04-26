package com.xeland314.conversores.divisas;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;

import com.xeland314.conversores.UnidadBase;

public class Divisa extends UnidadBase {

    private int precision;

    public Divisa(String nombre, String simbolo, int precision, Map<String, Function<BigDecimal, BigDecimal>> formulas) {
        super(nombre, simbolo, formulas);
        this.precision = precision;
    }

    public int getPrecision() {
        return this.precision;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof Divisa)) {
            return false;
        }
        Divisa other = (Divisa) o;
        return this.nombre == other.getNombre() && this.simbolo == other.getSimbolo();
    }

}