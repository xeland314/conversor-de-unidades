package com.xeland314.conversores.temperatura;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.function.Function;

import com.xeland314.conversores.Constantes;

public enum UnidadesTemperatura {

	CELSIUS(
		"Celsius", "°C", Map.of(
	    	"Fahrenheit", t -> t.multiply(Constantes.NUMERO_1_8).add(Constantes.NUMERO_32),
	    	"Kelvin", t -> t.add(Constantes.NUMERO_273_15),
	    	"Rankine", t -> t.add(Constantes.NUMERO_273_15).multiply(Constantes.NUMERO_1_8)
	)),
	FAHRENHEIT(
		"Fahrenheit", "°F", Map.of(
    		"Celsius", t -> t.subtract(Constantes.NUMERO_32).divide(Constantes.NUMERO_1_8, UnidadesTemperatura.getPrecision(), RoundingMode.HALF_UP),
    		"Kelvin", t -> t.add(Constantes.NUMERO_459_67).multiply(Constantes.NUMERO_5_D_9),
    		"Rankine", t -> t.add(Constantes.NUMERO_459_67)
    )),
	KELVIN(
		"Kelvin", "K", Map.of(
    		"Celsius", t -> t.subtract(Constantes.NUMERO_273_15),
    		"Fahrenheit", t -> t.multiply(Constantes.NUMERO_1_8).subtract(Constantes.NUMERO_459_67),
    		"Rankine", t -> t.multiply(Constantes.NUMERO_1_8)
    )),
	RANKINE(
		"Rankine", "°R", Map.of(
    		"Celsius", t -> t.divide(Constantes.NUMERO_1_8, UnidadesTemperatura.getPrecision(), RoundingMode.HALF_UP).subtract(Constantes.NUMERO_273_15),
    		"Fahrenheit", t -> t.subtract(Constantes.NUMERO_459_67),
    		"Kelvin", t -> t.divide(Constantes.NUMERO_1_8, UnidadesTemperatura.getPrecision(), RoundingMode.HALF_UP)
    ));

    private UnidadTemperatura unidad;
	private final static int PRECISION = 4;

    private UnidadesTemperatura(String nombre, String simbolo,  Map<String, Function<BigDecimal, BigDecimal>> formulas) {
        this.unidad = new UnidadTemperatura(nombre, simbolo, formulas);
    }

    public UnidadTemperatura get() {
        return this.unidad;
    }

    public static int getPrecision() {
        return PRECISION;
    }
}