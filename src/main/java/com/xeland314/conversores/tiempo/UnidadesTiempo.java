package com.xeland314.conversores.tiempo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.function.Function;

public enum UnidadesTiempo {
    
    SEGUNDO(
        "Segundo", "s", Map.of(
            "Minuto", t -> t.divide(new BigDecimal("60"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Hora", t -> t.divide(new BigDecimal("3600"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Día", t -> t.divide(new BigDecimal("86400"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Semana", t -> t.divide(new BigDecimal("604800"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Mes", t -> t.divide(new BigDecimal("2628000"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Año", t -> t.divide(new BigDecimal("31536000"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP)
        )
    ),
    MINUTO(
        "Minuto", "min", Map.of(
            "Segundo", t -> t.multiply(new BigDecimal("60")),
            "Hora", t -> t.divide(new BigDecimal("60"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Día", t -> t.divide(new BigDecimal("1440"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Semana", t -> t.divide(new BigDecimal("10080"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Mes", t -> t.divide(new BigDecimal("43800"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Año", t -> t.divide(new BigDecimal("525600"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP)
        )
    ),
    HORA(
        "Hora", "h", Map.of(
            "Segundo", t -> t.multiply(new BigDecimal("3600")),
            "Minuto", t -> t.multiply(new BigDecimal("60")),
            "Día", t -> t.divide(new BigDecimal("24"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Semana", t -> t.divide(new BigDecimal("168"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Mes", t -> t.divide(new BigDecimal("730"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Año", t -> t.divide(new BigDecimal("8760"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP)
        )
    ),
    DIA(
        "Día", "d", Map.of(
            "Segundo", t -> t.multiply(new BigDecimal("86400")),
            "Minuto", t -> t.multiply(new BigDecimal("1440")),
            "Hora", t -> t.multiply(new BigDecimal("24")),
            "Semana", t -> t.divide(new BigDecimal("7"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Mes", t -> t.divide(new BigDecimal("30.417"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Año", t -> t.divide(new BigDecimal("365"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP)
        )
    ),
    SEMANA(
        "Semana", "sem", Map.of(
            "Segundo", t -> t.multiply(new BigDecimal("604800")),
            "Minuto", t -> t.multiply(new BigDecimal("10080")),
            "Hora", t -> t.multiply(new BigDecimal("168")),
            "Día", t -> t.multiply(new BigDecimal("7")),
            "Mes", t -> t.divide(new BigDecimal("4.345"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP),
            "Año", t -> t.divide(new BigDecimal("52.143"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP)
        )
    ),
    MES(
        "Mes", "mes", Map.of(
            "Segundo", t -> t.multiply(new BigDecimal("2628000")),
            "Minuto", t -> t.multiply(new BigDecimal("43800")),
            "Hora", t -> t.multiply(new BigDecimal("730")),
            "Día", t -> t.multiply(new BigDecimal("30.416666666667")),
            "Semana", t -> t.multiply(new BigDecimal("4.3452381")),
            "Año", t -> t.divide(new BigDecimal("12"), UnidadesTiempo.getPrecision(), RoundingMode.HALF_UP)
        )
    ),
    AÑO(
        "Año", "a", Map.of(
            "Segundo", t -> t.multiply(new BigDecimal("31536000")),
            "Minuto", t -> t.multiply(new BigDecimal("525600")),
            "Hora", t -> t.multiply(new BigDecimal("8760")),
            "Día", t -> t.multiply(new BigDecimal("365")),
            "Semana", t -> t.multiply(new BigDecimal("52.1428571")),
            "Mes", t -> t.multiply(new BigDecimal("12"))  
        )
    );

    private UnidadTiempo unidad;
    private static final int PRECISION = 8;

    private UnidadesTiempo(String nombre, String simbolo,  Map<String, Function<BigDecimal, BigDecimal>> formulas) {
        this.unidad = new UnidadTiempo(nombre, simbolo, formulas);
    }

    public static int getPrecision() {
        return PRECISION;
    }

    public UnidadTiempo get() {
        return this.unidad;
    }

}
