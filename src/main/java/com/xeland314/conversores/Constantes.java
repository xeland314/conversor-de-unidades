package com.xeland314.conversores;

import java.math.BigDecimal;

public class Constantes {
    
    /*
     * CONSTANTES PARA CÁLCULOS CON TEMPERATURA:
     * - NUMERO_1_8: factor de conversión de grados Celsius a Fahrenheit (1.8) o (9/5)
     * - NUMERO_32: ajuste de temperatura para la escala Fahrenheit (32)
     * - NUMERO_273_15: ajuste de temperatura para la escala Celsius (273.15)
     * - NUMERO_459_67: ajuste de temperatura para la escala Rankine (459.67)
     * - NUMERO_5_D_9: factor de conversión de grados Fahrenheit a Celsius (0.5555555555555556) o (5/9)
     */

    public static final BigDecimal NUMERO_1_8 = new BigDecimal("1.8");
    public static final BigDecimal NUMERO_32 = new BigDecimal("32");
    public static final BigDecimal NUMERO_273_15 = new BigDecimal("273.15");
    public static final BigDecimal NUMERO_459_67 = new BigDecimal("459.67");
    public static final BigDecimal NUMERO_5_D_9 = new BigDecimal("0.5555555555555556");
    public static final BigDecimal MIN_CELSIUS = new BigDecimal("-273.15");
    public static final BigDecimal MIN_FAHRENHEIT = new BigDecimal("-459.67");

    /*
     * CONSTANTES PARA CÁLCULOS CON TIEMPO:
     * - NUMERO_60: factor de conversión de minutos a segundos (60)
     * - NUMERO_3600: factor de conversión de horas a segundos (3600)
     * TODO: Escribir más constantes...
     */

    public static final BigDecimal NUMERO_60 = new BigDecimal("60");
    public static final BigDecimal NUMERO_3600 = new BigDecimal("3600");
    public static final BigDecimal NUMERO_86400 = new BigDecimal("86400");
    public static final BigDecimal NUMERO_604800 = new BigDecimal("604800");
    public static final BigDecimal NUMERO_2592000 = new BigDecimal("2592000");
    public static final BigDecimal NUMERO_31536000 = new BigDecimal("31536000");
    public static final BigDecimal NUMERO_2628000 = new BigDecimal("2628000");

    /*
     * CONSTANTES PARA CÁLCULOS CON LONGITUD:
     */

    public static final BigDecimal CIEN = new BigDecimal("100");
    public static final BigDecimal MIL = new BigDecimal("1000");
    public static final BigDecimal DIEZ_MIL = new BigDecimal("10000");
    public static final BigDecimal CIEN_MIL = new BigDecimal("100000");
    public static final BigDecimal MILLON = new BigDecimal("1000000");

}

