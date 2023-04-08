package com.xeland314.conversores.temperatura;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

import com.xeland314.app.Alertas;
import com.xeland314.conversores.Constantes;

public class Temperatura {

    private BigDecimal valor;
    private UnidadTemperatura unidad;

    public Temperatura(String input, UnidadTemperatura unidad) throws TemperaturaInvalida {
        if(!esUnValorValido(input, unidad)) {
            Alertas.TEMPERATURA_INVALIDA.lanzarAlerta();
            throw new TemperaturaInvalida();
        }
        this.unidad = unidad;
    }

    public Temperatura(BigDecimal valor, UnidadTemperatura unidad) throws TemperaturaInvalida {
        if (!esUnValorValido(valor, unidad)) {
            Alertas.TEMPERATURA_INVALIDA.lanzarAlerta();
            throw new TemperaturaInvalida();
        }
        this.valor = valor.setScale(UnidadesTemperatura.getPrecision(), RoundingMode.HALF_UP);
        this.unidad = unidad;
    }

    private boolean esUnValorValido(BigDecimal valor, UnidadTemperatura unidad) {
        UnidadTemperatura celsius = UnidadesTemperatura.CELSIUS.get();
        if(unidad.equals(celsius)) {
            return valor.compareTo(Constantes.MIN_CELSIUS) >= 0;
        }

        UnidadTemperatura fahrenheit = UnidadesTemperatura.FAHRENHEIT.get();
        if(unidad.equals(fahrenheit)) {
            return valor.compareTo(Constantes.MIN_FAHRENHEIT) >= 0;
        }

        return valor.compareTo(BigDecimal.ZERO) >= 0;
    }

    private boolean esUnValorValido(String input, UnidadTemperatura unidad) {
        try {
            this.valor = new BigDecimal(input).setScale(UnidadesTemperatura.getPrecision(), RoundingMode.HALF_UP);
        } catch (Exception e) {
            Alertas.ENTRADA_INVALIDA.lanzarAlerta();
            e.printStackTrace();
        }
        return this.esUnValorValido(this.valor, unidad);
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public BigDecimal getValorFormateado() {
        return this.valor.stripTrailingZeros();
    }

    public UnidadTemperatura getUnidad() {
        return this.unidad;
    }

    public Function<BigDecimal, BigDecimal> getFormulaPara(UnidadTemperatura unidad2) {
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
        if (!(o instanceof Temperatura)) {
            return false;
        }
        Temperatura t = (Temperatura) o;
        return this.valor.equals(t.getValor()) && this.unidad.equals(t.getUnidad());
    }

}
