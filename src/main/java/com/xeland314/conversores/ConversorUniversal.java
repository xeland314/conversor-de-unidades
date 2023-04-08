package com.xeland314.conversores;

import java.math.BigDecimal;
import java.util.function.Function;

import com.xeland314.conversores.longitud.Longitud;
import com.xeland314.conversores.longitud.LongitudInvalida;
import com.xeland314.conversores.longitud.UnidadLongitud;
import com.xeland314.conversores.temperatura.Temperatura;
import com.xeland314.conversores.temperatura.TemperaturaInvalida;
import com.xeland314.conversores.temperatura.UnidadTemperatura;
import com.xeland314.conversores.tiempo.Tiempo;
import com.xeland314.conversores.tiempo.TiempoInvalido;
import com.xeland314.conversores.tiempo.UnidadTiempo;

public class ConversorUniversal {

    public static Tiempo convertir(Tiempo tiempo, UnidadTiempo unidad) throws TiempoInvalido {
        Function<BigDecimal, BigDecimal> formula = tiempo.getFormulaPara(unidad);
        BigDecimal nuevoValor = formula.apply(tiempo.getValor());
        return new Tiempo(nuevoValor, unidad);
    }

    public static Temperatura convertir(Temperatura tiempo, UnidadTemperatura unidad) throws TemperaturaInvalida {
        Function<BigDecimal, BigDecimal> formula = tiempo.getFormulaPara(unidad);
        BigDecimal nuevoValor = formula.apply(tiempo.getValor());
        return new Temperatura(nuevoValor, unidad);
    }

    public static Longitud convertir(Longitud tiempo, UnidadLongitud unidad) throws LongitudInvalida {
        Function<BigDecimal, BigDecimal> formula = tiempo.getFormulaPara(unidad);
        BigDecimal nuevoValor = formula.apply(tiempo.getValor());
        return new Longitud(nuevoValor, unidad);
    }

}

