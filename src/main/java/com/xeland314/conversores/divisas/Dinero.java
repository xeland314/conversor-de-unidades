package com.xeland314.conversores.divisas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

import com.xeland314.app.Alertas;

public class Dinero {

    private BigDecimal valor;
    private Divisa divisa;

    public Dinero(String input, Divisa divisa) throws DivisaInvalida {
        if(!esUnValorValido(input)) {
            Alertas.DIVISA_INVALIDA.lanzarAlerta();
            throw new DivisaInvalida();
        }
        this.divisa = divisa;
    }

    private boolean esUnValorValido(String input) {
        try {
            this.valor = new BigDecimal(input);
            return this.valor.compareTo(BigDecimal.ZERO) >= 0;
        } catch (Exception e) {
            Alertas.ENTRADA_INVALIDA.lanzarAlerta();
            e.printStackTrace();
        }
        return false;
    }

    public Dinero(BigDecimal valor, Divisa divisa) throws DivisaInvalida {
        if (!esUnValorValido(valor)) {
            Alertas.DIVISA_INVALIDA.lanzarAlerta();
            throw new DivisaInvalida();
        }
        this.valor = valor;
        this.divisa = divisa;
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

    public Divisa getDivisa() {
        return this.divisa;
    }

    public Function<BigDecimal, BigDecimal> getFormulaPara(Divisa unidad2) {
        return this.divisa.getFormulaPara(unidad2);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getValorFormateado().toString(), this.divisa.getSimbolo());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Dinero)) {
            return false;
        }
        Dinero t = (Dinero) o;
        return this.valor.equals(t.getValor()) && this.divisa.equals(t.getDivisa());
    }

}
