package conversores;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.xeland314.conversores.ConversorUniversal;
import com.xeland314.conversores.longitud.Longitud;
import com.xeland314.conversores.longitud.LongitudInvalida;
import com.xeland314.conversores.longitud.UnidadesLongitud;

public class TestLongitud {

    private Longitud milimetro;
    private Longitud centimetro;
    private Longitud decimetro;
    private Longitud metro;
    private Longitud decametro;
    private Longitud hectometro;
    private Longitud kilometro;

    @Before
    public void setUp() throws Exception {
        milimetro = new Longitud("1", UnidadesLongitud.MILIMETRO.get());
        centimetro = new Longitud("1", UnidadesLongitud.CENTIMETRO.get());
        decimetro = new Longitud("1", UnidadesLongitud.DECIMETRO.get());
        metro = new Longitud("1", UnidadesLongitud.METRO.get());
        decametro = new Longitud("1", UnidadesLongitud.DECAMETRO.get());
        hectometro = new Longitud("1", UnidadesLongitud.HECTOMETRO.get());
        kilometro = new Longitud("1", UnidadesLongitud.KILOMETRO.get());
    }

    @Test
    public void testConvertirMilimetrosA() throws LongitudInvalida {
        Longitud esperado = new Longitud("1", UnidadesLongitud.MILIMETRO.get());
        Longitud resultado = ConversorUniversal.convertir(milimetro, UnidadesLongitud.MILIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.1", UnidadesLongitud.CENTIMETRO.get());
        resultado = ConversorUniversal.convertir(milimetro, UnidadesLongitud.CENTIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.01", UnidadesLongitud.DECIMETRO.get());
        resultado = ConversorUniversal.convertir(milimetro, UnidadesLongitud.DECIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.001", UnidadesLongitud.METRO.get());
        resultado = ConversorUniversal.convertir(milimetro, UnidadesLongitud.METRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.0001", UnidadesLongitud.DECAMETRO.get());
        resultado = ConversorUniversal.convertir(milimetro, UnidadesLongitud.DECAMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.00001", UnidadesLongitud.HECTOMETRO.get());
        resultado = ConversorUniversal.convertir(milimetro, UnidadesLongitud.HECTOMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.000001", UnidadesLongitud.KILOMETRO.get());
        resultado = ConversorUniversal.convertir(milimetro, UnidadesLongitud.KILOMETRO.get());
        assertEquals(esperado, resultado);
    }

    @Test
    public void testConvertirCentimetrosA() throws LongitudInvalida {
        Longitud esperado = new Longitud("10", UnidadesLongitud.MILIMETRO.get());
        Longitud resultado = ConversorUniversal.convertir(centimetro, UnidadesLongitud.MILIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("1", UnidadesLongitud.CENTIMETRO.get());
        resultado = ConversorUniversal.convertir(centimetro, UnidadesLongitud.CENTIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.1", UnidadesLongitud.DECIMETRO.get());
        resultado = ConversorUniversal.convertir(centimetro, UnidadesLongitud.DECIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.01", UnidadesLongitud.METRO.get());
        resultado = ConversorUniversal.convertir(centimetro, UnidadesLongitud.METRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.001", UnidadesLongitud.DECAMETRO.get());
        resultado = ConversorUniversal.convertir(centimetro, UnidadesLongitud.DECAMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.0001", UnidadesLongitud.HECTOMETRO.get());
        resultado = ConversorUniversal.convertir(centimetro, UnidadesLongitud.HECTOMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.00001", UnidadesLongitud.KILOMETRO.get());
        resultado = ConversorUniversal.convertir(centimetro, UnidadesLongitud.KILOMETRO.get());
        assertEquals(esperado, resultado);
    }

    @Test
    public void testConvertirDecimetrosA() throws LongitudInvalida {
        Longitud esperado = new Longitud("100", UnidadesLongitud.MILIMETRO.get());
        Longitud resultado = ConversorUniversal.convertir(decimetro, UnidadesLongitud.MILIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("10", UnidadesLongitud.CENTIMETRO.get());
        resultado = ConversorUniversal.convertir(decimetro, UnidadesLongitud.CENTIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("1", UnidadesLongitud.DECIMETRO.get());
        resultado = ConversorUniversal.convertir(decimetro, UnidadesLongitud.DECIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.1", UnidadesLongitud.METRO.get());
        resultado = ConversorUniversal.convertir(decimetro, UnidadesLongitud.METRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.01", UnidadesLongitud.DECAMETRO.get());
        resultado = ConversorUniversal.convertir(decimetro, UnidadesLongitud.DECAMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.001", UnidadesLongitud.HECTOMETRO.get());
        resultado = ConversorUniversal.convertir(decimetro, UnidadesLongitud.HECTOMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.0001", UnidadesLongitud.KILOMETRO.get());
        resultado = ConversorUniversal.convertir(decimetro, UnidadesLongitud.KILOMETRO.get());
        assertEquals(esperado, resultado);
    }

    @Test
    public void testConvertirMetrosA() throws LongitudInvalida {
        Longitud esperado = new Longitud("1000", UnidadesLongitud.MILIMETRO.get());
        Longitud resultado = ConversorUniversal.convertir(metro, UnidadesLongitud.MILIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("100", UnidadesLongitud.CENTIMETRO.get());
        resultado = ConversorUniversal.convertir(metro, UnidadesLongitud.CENTIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("10", UnidadesLongitud.DECIMETRO.get());
        resultado = ConversorUniversal.convertir(metro, UnidadesLongitud.DECIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("1", UnidadesLongitud.METRO.get());
        resultado = ConversorUniversal.convertir(metro, UnidadesLongitud.METRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.1", UnidadesLongitud.DECAMETRO.get());
        resultado = ConversorUniversal.convertir(metro, UnidadesLongitud.DECAMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.01", UnidadesLongitud.HECTOMETRO.get());
        resultado = ConversorUniversal.convertir(metro, UnidadesLongitud.HECTOMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.001", UnidadesLongitud.KILOMETRO.get());
        resultado = ConversorUniversal.convertir(metro, UnidadesLongitud.KILOMETRO.get());
        assertEquals(esperado, resultado);
    }

    @Test
    public void testConvertirDecametrosA() throws LongitudInvalida {
        Longitud esperado = new Longitud("10000", UnidadesLongitud.MILIMETRO.get());
        Longitud resultado = ConversorUniversal.convertir(decametro, UnidadesLongitud.MILIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("1000", UnidadesLongitud.CENTIMETRO.get());
        resultado = ConversorUniversal.convertir(decametro, UnidadesLongitud.CENTIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("100", UnidadesLongitud.DECIMETRO.get());
        resultado = ConversorUniversal.convertir(decametro, UnidadesLongitud.DECIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("10", UnidadesLongitud.METRO.get());
        resultado = ConversorUniversal.convertir(decametro, UnidadesLongitud.METRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("1", UnidadesLongitud.DECAMETRO.get());
        resultado = ConversorUniversal.convertir(decametro, UnidadesLongitud.DECAMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.1", UnidadesLongitud.HECTOMETRO.get());
        resultado = ConversorUniversal.convertir(decametro, UnidadesLongitud.HECTOMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.01", UnidadesLongitud.KILOMETRO.get());
        resultado = ConversorUniversal.convertir(decametro, UnidadesLongitud.KILOMETRO.get());
        assertEquals(esperado, resultado);
    }

    @Test
    public void testConvertirHectometrosA() throws LongitudInvalida {
        Longitud esperado = new Longitud("100000", UnidadesLongitud.MILIMETRO.get());
        Longitud resultado = ConversorUniversal.convertir(hectometro, UnidadesLongitud.MILIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("10000", UnidadesLongitud.CENTIMETRO.get());
        resultado = ConversorUniversal.convertir(hectometro, UnidadesLongitud.CENTIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("1000", UnidadesLongitud.DECIMETRO.get());
        resultado = ConversorUniversal.convertir(hectometro, UnidadesLongitud.DECIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("100", UnidadesLongitud.METRO.get());
        resultado = ConversorUniversal.convertir(hectometro, UnidadesLongitud.METRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("10", UnidadesLongitud.DECAMETRO.get());
        resultado = ConversorUniversal.convertir(hectometro, UnidadesLongitud.DECAMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("1", UnidadesLongitud.HECTOMETRO.get());
        resultado = ConversorUniversal.convertir(hectometro, UnidadesLongitud.HECTOMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("0.1", UnidadesLongitud.KILOMETRO.get());
        resultado = ConversorUniversal.convertir(hectometro, UnidadesLongitud.KILOMETRO.get());
        assertEquals(esperado, resultado);
    }

    @Test
    public void testConvertirKilometrosA() throws LongitudInvalida {
        Longitud esperado = new Longitud("1000000", UnidadesLongitud.MILIMETRO.get());
        Longitud resultado = ConversorUniversal.convertir(kilometro, UnidadesLongitud.MILIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("100000", UnidadesLongitud.CENTIMETRO.get());
        resultado = ConversorUniversal.convertir(kilometro, UnidadesLongitud.CENTIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("10000", UnidadesLongitud.DECIMETRO.get());
        resultado = ConversorUniversal.convertir(kilometro, UnidadesLongitud.DECIMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("1000", UnidadesLongitud.METRO.get());
        resultado = ConversorUniversal.convertir(kilometro, UnidadesLongitud.METRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("100", UnidadesLongitud.DECAMETRO.get());
        resultado = ConversorUniversal.convertir(kilometro, UnidadesLongitud.DECAMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("10", UnidadesLongitud.HECTOMETRO.get());
        resultado = ConversorUniversal.convertir(kilometro, UnidadesLongitud.HECTOMETRO.get());
        assertEquals(esperado, resultado);

        esperado = new Longitud("1", UnidadesLongitud.KILOMETRO.get());
        resultado = ConversorUniversal.convertir(kilometro, UnidadesLongitud.KILOMETRO.get());
        assertEquals(esperado, resultado);
    }

    @Test(expected = LongitudInvalida.class)
    public void testLongitudInvalida() throws LongitudInvalida {
        Longitud longitudInvalida = new Longitud("null", UnidadesLongitud.CENTIMETRO.get());
        System.out.println(longitudInvalida);
    }
    
    @Test(expected = LongitudInvalida.class)
    public void testLongitudInvalida2() throws LongitudInvalida {
        Longitud longitudInvalida = new Longitud("-1000", UnidadesLongitud.CENTIMETRO.get());
        System.out.println(longitudInvalida);
    }

    @Test(expected = LongitudInvalida.class)
    public void testLongitudInvalida3() throws LongitudInvalida {
        Longitud longitudInvalida = new Longitud(new BigDecimal("-1000"), UnidadesLongitud.CENTIMETRO.get());
        System.out.println(longitudInvalida);
    }
}
