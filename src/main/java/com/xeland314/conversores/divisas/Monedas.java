package com.xeland314.conversores.divisas;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;

public enum Monedas {

    EURO(
        "Euro", "€", 2, Map.of(
            "Euro", d -> d,
            "Dólar", d -> d.multiply(new BigDecimal("1.10")),
            "Won sul-coreano", d -> d.multiply(new BigDecimal("1469.31")),
            "Yén japonés", d -> d.multiply(new BigDecimal("146.82")),
            "Libra esterlina", d -> d.multiply(new BigDecimal("0.88")),
            "Peso colombiano", d -> d.multiply(new BigDecimal("4948.00"))
        )
    ),
    DOLAR(
        "Dólar", "USD$", 2, Map.of(
            "Euro", d -> d.multiply(new BigDecimal("0.91")),
            "Dólar", d -> d,
            "Won sul-coreano", d -> d.multiply(new BigDecimal("1338.66")),
            "Yén japonés", d -> d.multiply(new BigDecimal("133.77")),
            "Libra esterlina", d -> d.multiply(new BigDecimal("0.81")),
            "Peso colombiano", d -> d.multiply(new BigDecimal("4507.88"))
        )
    ),
    WON(
        "Won sul-coreano", "₩", 2, Map.of(
            "Euro", d -> d.multiply(new BigDecimal("0.00068")),
            "Dólar", d -> d.multiply(new BigDecimal("0.00075")),
            "Won sul-coreano", d -> d,
            "Yén japonés", d -> d.multiply(new BigDecimal("0.10")),
            "Libra esterlina", d -> d.multiply(new BigDecimal("0.00060")),
            "Peso colombiano", d -> d.multiply(new BigDecimal("3.37"))
        )
    ),
    YEN(
        "Yén japonés", "¥", 0, Map.of(
            "Euro", d -> d.multiply(new BigDecimal("33.70")),
            "Dólar", d -> d.multiply(new BigDecimal("0.0075")),
            "Won sul-coreano", d -> d.multiply(new BigDecimal("10.00")),
            "Yén japonés", d -> d,
            "Libra esterlina", d -> d.multiply(new BigDecimal("0.0060")),
            "Peso colombiano", d -> d.multiply(new BigDecimal("33.71"))
        )
    ),
    LIBRA_ESTERLINA(
        "Libra esterlina", "£", 2, Map.of(
            "Euro", d -> d.multiply(new BigDecimal("1.13")),
            "Dólar", d -> d.multiply(new BigDecimal("1.24")),
            "Won sul-coreano", d -> d.multiply(new BigDecimal("1662.08")),
            "Yén japonés", d -> d.multiply(new BigDecimal("165.96")),
            "Libra esterlina", d -> d,
            "Peso colombiano", d -> d.multiply(new BigDecimal("5597.00"))
        )
    ),
    PESO_COLOMBIANO(
        "Peso colombiano", "COP$", 2, Map.of(
            "Euro", d -> d.multiply(new BigDecimal("0.00020")),
            "Dólar", d -> d.multiply(new BigDecimal("0.00022")),
            "Won sul-coreano", d -> d.multiply(new BigDecimal("0.30")),
            "Yén japonés", d -> d.multiply(new BigDecimal("0.030")),
            "Libra esterlina", d -> d.multiply(new BigDecimal("0.00018")),
            "Peso colombiano", d -> d
        )
    );

    private Divisa unidad;

    private Monedas(String nombre, String simbolo, int precision, Map<String, Function<BigDecimal, BigDecimal>> formulas) {
        this.unidad = new Divisa(nombre, simbolo, precision, formulas);
    }

    public Divisa get() {
        return this.unidad;
    }

}
