package com.xeland314.conversores.longitud;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

import com.xeland314.app.Alertas;

public class Longitud {

    private BigDecimal valor;
    private UnidadLongitud unidad;

    public Longitud(String input, UnidadLongitud unidad) throws LongitudInvalida {
        if(!esUnValorValido(input)) {
            Alertas.LONGITUD_INVALIDA.lanzarAlerta();
            throw new LongitudInvalida();
        }
        this.unidad = unidad;
    }

    private boolean esUnValorValido(String input) {
        try {
            this.valor = new BigDecimal(input).setScale(UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP);
            return this.valor.compareTo(BigDecimal.ZERO) >= 0;
        } catch (Exception e) {
            Alertas.ENTRADA_INVALIDA.lanzarAlerta();
            e.printStackTrace();
        }
        return false;
    }

    public Longitud(BigDecimal valor, UnidadLongitud unidad) throws LongitudInvalida {
        if (!esUnValorValido(valor)) {
            Alertas.LONGITUD_INVALIDA.lanzarAlerta();
            throw new LongitudInvalida();
        }
        this.valor = valor.setScale(UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP);
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

    public UnidadLongitud getUnidad() {
        return this.unidad;
    }

    public Function<BigDecimal, BigDecimal> getFormulaPara(UnidadLongitud unidad2) {
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
        if (!(o instanceof Longitud)) {
            return false;
        }
        Longitud longitud = (Longitud) o;
        return this.valor.equals(longitud.getValor()) && this.unidad.equals(longitud.getUnidad());
    }

}
