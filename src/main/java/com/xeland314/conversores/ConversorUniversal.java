package com.xeland314.conversores;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;

import com.xeland314.conversores.divisas.Dinero;
import com.xeland314.conversores.divisas.Divisa;
import com.xeland314.conversores.divisas.DivisaInvalida;
import com.xeland314.conversores.divisas.Monedas;
import com.xeland314.conversores.longitud.Longitud;
import com.xeland314.conversores.longitud.LongitudInvalida;
import com.xeland314.conversores.longitud.UnidadLongitud;
import com.xeland314.conversores.longitud.UnidadesLongitud;
import com.xeland314.conversores.temperatura.Temperatura;
import com.xeland314.conversores.temperatura.TemperaturaInvalida;
import com.xeland314.conversores.temperatura.UnidadTemperatura;
import com.xeland314.conversores.temperatura.UnidadesTemperatura;
import com.xeland314.conversores.tiempo.Tiempo;
import com.xeland314.conversores.tiempo.TiempoInvalido;
import com.xeland314.conversores.tiempo.UnidadTiempo;
import com.xeland314.conversores.tiempo.UnidadesTiempo;

public class ConversorUniversal {

    private static Map<String, Map<String, UnidadBase>> conversiones = Map.of(
        "Longitud", Map.of(
            "Milímetro", UnidadesLongitud.MILIMETRO.get(),
            "Centímetro",UnidadesLongitud.CENTIMETRO.get(),
            "Decímetro", UnidadesLongitud.DECIMETRO.get(),
            "Metro", UnidadesLongitud.METRO.get(),
            "Decámetro", UnidadesLongitud.DECAMETRO.get(),
            "Hectómetro",UnidadesLongitud.HECTOMETRO.get(),
            "Kilómetro",UnidadesLongitud.KILOMETRO.get()
        ),
        "Tiempo", Map.of(
            "Segundo", UnidadesTiempo.SEGUNDO.get(),
            "Minuto", UnidadesTiempo.MINUTO.get(),
            "Hora", UnidadesTiempo.HORA.get(),
            "Día", UnidadesTiempo.DIA.get(),
            "Semana", UnidadesTiempo.SEMANA.get(),
            "Mes", UnidadesTiempo.MES.get(),
            "Año", UnidadesTiempo.AÑO.get()
        ),
        "Temperatura", Map.of(
            "Celsius", UnidadesTemperatura.CELSIUS.get(),
            "Fahrenheit", UnidadesTemperatura.FAHRENHEIT.get(),
            "Kelvin", UnidadesTemperatura.KELVIN.get(),
            "Rankine",UnidadesTemperatura.RANKINE.get()
        ),
        "Divisa", Map.of(
            "Dólar", Monedas.DOLAR.get(),
            "Euro", Monedas.EURO.get(),
            "Libra esterlina", Monedas.LIBRA_ESTERLINA.get(),
            "Peso colombiano", Monedas.PESO_COLOMBIANO.get(),
            "Yén japonés", Monedas.YEN.get(),
            "Won sul-coreano", Monedas.WON.get()
        )
    );

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

    public static Dinero convertir(Dinero dinero, Divisa divisa) throws DivisaInvalida {
        Function<BigDecimal, BigDecimal> formula = dinero.getFormulaPara(divisa);
        BigDecimal nuevoValor = formula.apply(dinero.getValor());
        return new Dinero(nuevoValor, divisa);
    }

    public static UnidadBase getUnidad(String unidad, String sistema) {
        return conversiones.get(sistema).get(unidad);
    }

}

