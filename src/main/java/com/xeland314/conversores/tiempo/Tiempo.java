package com.xeland314.conversores.tiempo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

import com.xeland314.app.Alertas;

public class Tiempo {

    private BigDecimal valor;
    private UnidadTiempo unidad;

    public Tiempo(String input, UnidadTiempo unidad) throws TiempoInvalido {
        if(!esUnValorValido(input)) {
            Alertas.TIEMPO_INVALIDO.lanzarAlerta();
            throw new TiempoInvalido();
        }
        this.unidad = unidad;
    }

    private boolean esUnValorValido(String input) {
        try {
            this.valor = new BigDecimal(input).setScale(UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP);
            return this.valor.compareTo(BigDecimal.ZERO) >= 0;
        } catch (Exception e) {
            Alertas.ENTRADA_INVALIDA.lanzarAlerta();
            e.printStackTrace();
        }
        return false;
    }

    public Tiempo(BigDecimal valor, UnidadTiempo unidad) throws TiempoInvalido {
        if (!esUnValorValido(valor)) {
            Alertas.TIEMPO_INVALIDO.lanzarAlerta();
            throw new TiempoInvalido();
        }
        this.valor = valor.setScale(UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP);
        this.unidad = unidad;
    }

    private boolean esUnValorValido(BigDecimal valor) {
        return valor.compareTo(BigDecimal.ZERO) >= 0;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public BigDecimal getValorFormateado() {
        return this.valor.stripTrailingZeros();
    }

    public UnidadTiempo getUnidad() {
        return this.unidad;
    }

    public Function<BigDecimal, BigDecimal> getFormulaPara(UnidadTiempo unidad2) {
        return this.unidad.getFormulaPara(unidad2);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getValorFormateado().toString(), this.unidad.getSimbolo());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Tiempo)) {
            return false;
        }
        Tiempo t = (Tiempo) o;
        return this.valor.equals(t.getValor()) && this.unidad.equals(t.getUnidad());
    }

}