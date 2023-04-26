package com.xeland314.conversores;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public abstract class UnidadBase {

    protected String nombre;
    protected String simbolo;
    protected Map<String, Function<BigDecimal, BigDecimal>> formulas;

    public UnidadBase(String nombre, String simbolo, Map<String, Function<BigDecimal, BigDecimal>> formulas) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.formulas = new HashMap<String, Function<BigDecimal, BigDecimal>>(formulas);
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public Function<BigDecimal, BigDecimal> getFormulaPara(UnidadBase unidad) {
        return this.formulas.get(unidad.getNombre());
    }

    public Set<String> getListaDePosiblesConversiones() {
        return this.formulas.keySet();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.nombre == null ? 0 : this.nombre.hashCode());
        hash = 17 * hash + (this.simbolo == null ? 0 : this.simbolo.hashCode());
        return hash;    
    }
}