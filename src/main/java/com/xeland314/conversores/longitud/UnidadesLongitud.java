package com.xeland314.conversores.longitud;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.function.Function;

import com.xeland314.conversores.Constantes;

public enum UnidadesLongitud {
     
    METRO(
        "Metro", "m", Map.of(
            "Milímetro", l -> l.multiply(Constantes.MIL),
            "Centímetro", l -> l.multiply(Constantes.CIEN),
            "Decímetro", l -> l.multiply(BigDecimal.TEN),
            "Metro", l -> l,
            "Decámetro", l -> l.divide(BigDecimal.TEN, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Hectómetro", l -> l.divide(Constantes.CIEN, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Kilómetro", l -> l.divide(Constantes.MIL, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP)
        )
    ),
    DECIMETRO(
        "Decímetro", "dm", Map.of(
            "Milímetro", l -> l.multiply(Constantes.CIEN),
            "Centímetro", l -> l.multiply(BigDecimal.TEN),
            "Decímetro", l -> l,
            "Metro", l -> l.divide(BigDecimal.TEN, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Decámetro", l -> l.divide(Constantes.CIEN, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Hectómetro", l -> l.divide(Constantes.MIL, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Kilómetro", l -> l.divide(Constantes.DIEZ_MIL, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP)
        )
    ),
    CENTIMETRO(
        "Centímetro", "cm", Map.of(
            "Milímetro", l -> l.multiply(BigDecimal.TEN),
            "Centímetro", l -> l,
            "Decímetro", l -> l.divide(BigDecimal.TEN, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Metro", l -> l.divide(Constantes.CIEN, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Decámetro", l -> l.divide(Constantes.MIL, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Hectómetro", l -> l.divide(Constantes.DIEZ_MIL, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Kilómetro", l -> l.divide(Constantes.CIEN_MIL, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP)
        )
    ),
    MILIMETRO(
        "Milímetro", "mm", Map.of(
            "Milímetro", l -> l,
            "Centímetro", l -> l.divide(BigDecimal.TEN, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Decímetro", l -> l.divide(Constantes.CIEN, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Metro", l -> l.divide(Constantes.MIL, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Decámetro", l -> l.divide(Constantes.DIEZ_MIL, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Hectómetro", l -> l.divide(Constantes.CIEN_MIL, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Kilómetro", l -> l.divide(Constantes.MILLON, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP)
        )
    ),
    DECAMETRO(
        "Decámetro", "dam", Map.of(
            "Milímetro", l -> l.multiply(Constantes.DIEZ_MIL),
            "Centímetro", l -> l.multiply(Constantes.MIL),
            "Decímetro", l -> l.multiply(Constantes.CIEN),
            "Metro", l -> l.multiply(BigDecimal.TEN),
            "Decámetro", l -> l,
            "Hectómetro", l -> l.divide(BigDecimal.TEN, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP),
            "Kilómetro", l -> l.divide(Constantes.CIEN, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP)
        )
    ),
    HECTOMETRO(
        "Hectómetro", "hm", Map.of(
            "Milímetro", l -> l.multiply(Constantes.CIEN_MIL),
            "Centímetro", l -> l.multiply(Constantes.DIEZ_MIL),
            "Decímetro", l -> l.multiply(Constantes.MIL),
            "Metro", l -> l.multiply(Constantes.CIEN),
            "Decámetro", l -> l.multiply(BigDecimal.TEN),
            "Hectómetro", l -> l,
            "Kilómetro", l -> l.divide(BigDecimal.TEN, UnidadesLongitud.getPrecision(), RoundingMode.HALF_UP)
        )
    ),
    KILOMETRO(
        "Kilómetro", "km", Map.of(
            "Milímetro", l -> l.multiply(Constantes.MILLON),
            "Centímetro", l -> l.multiply(Constantes.CIEN_MIL),
            "Decímetro", l -> l.multiply(Constantes.DIEZ_MIL),
            "Metro", l -> l.multiply(Constantes.MIL),
            "Decámetro", l -> l.multiply(Constantes.CIEN),
            "Hectómetro", l -> l.multiply(BigDecimal.TEN),
            "Kilómetro", l -> l
        )
    );

    private UnidadLongitud unidad;
	private final static int PRECISION = 10;

    private UnidadesLongitud(String nombre, String simbolo,  Map<String, Function<BigDecimal, BigDecimal>> formulas) {
        this.unidad = new UnidadLongitud(nombre, simbolo, formulas);
    }

    public UnidadLongitud get() {
        return this.unidad;
    }

    public static int getPrecision() {
        return PRECISION;
    }

}
