package conversores;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.xeland314.conversores.ConversorUniversal;
import com.xeland314.conversores.tiempo.Tiempo;
import com.xeland314.conversores.tiempo.TiempoInvalido;
import com.xeland314.conversores.tiempo.UnidadesTiempo;

public class TestTiempo {

    private Tiempo segundo;
    private Tiempo minuto;
    private Tiempo hora;
    private Tiempo dia;

    @Before
    public void setUp() throws Exception {
        segundo = new Tiempo("1", UnidadesTiempo.SEGUNDO.get());
        minuto = new Tiempo("1", UnidadesTiempo.MINUTO.get());
        hora = new Tiempo("1", UnidadesTiempo.HORA.get());
        dia = new Tiempo("1", UnidadesTiempo.DIA.get());
    }

    @Test
    public void testConvertirMinutosASegundos() throws TiempoInvalido {
        Tiempo esperado = new Tiempo("60", UnidadesTiempo.SEGUNDO.get());
        Tiempo resultado = ConversorUniversal.convertir(minuto, UnidadesTiempo.SEGUNDO.get());
        assertEquals(esperado, resultado);
    
        esperado = new Tiempo("180", UnidadesTiempo.SEGUNDO.get());
        resultado = ConversorUniversal.convertir(new Tiempo("3", UnidadesTiempo.MINUTO.get()), UnidadesTiempo.SEGUNDO.get());
        assertEquals(esperado, resultado);
    
        esperado = new Tiempo("120", UnidadesTiempo.SEGUNDO.get());
        resultado = ConversorUniversal.convertir(new Tiempo("2", UnidadesTiempo.MINUTO.get()), UnidadesTiempo.SEGUNDO.get());
        assertEquals(esperado, resultado);
    
        esperado = new Tiempo("0.5", UnidadesTiempo.MINUTO.get());
        resultado = ConversorUniversal.convertir(new Tiempo("30", UnidadesTiempo.SEGUNDO.get()), UnidadesTiempo.MINUTO.get());
        assertEquals(esperado, resultado);
    }    

    @Test
    public void testConvertirSegundosAMinutos() throws TiempoInvalido {
        Tiempo esperado = new Tiempo("0.0166666666666667", UnidadesTiempo.MINUTO.get());
        Tiempo resultado = ConversorUniversal.convertir(segundo, UnidadesTiempo.MINUTO.get());
        assertEquals(esperado, resultado);
    
        esperado = new Tiempo("0.0002777777777778", UnidadesTiempo.HORA.get());
        resultado = ConversorUniversal.convertir(segundo, UnidadesTiempo.HORA.get());
        assertEquals(esperado, resultado);
    
        esperado = new Tiempo("0.0000115740740741", UnidadesTiempo.DIA.get());
        resultado = ConversorUniversal.convertir(segundo, UnidadesTiempo.DIA.get());
        assertEquals(esperado, resultado);
    
        esperado = new Tiempo("0.0000016534391534", UnidadesTiempo.SEMANA.get());
        resultado = ConversorUniversal.convertir(segundo, UnidadesTiempo.SEMANA.get());
        assertEquals(esperado, resultado);
    }    

    @Test
    public void testConvertirHorasADias() throws TiempoInvalido {
        Tiempo esperado = new Tiempo("0.0416666666", UnidadesTiempo.DIA.get());
        Tiempo resultado = ConversorUniversal.convertir(hora, UnidadesTiempo.DIA.get());
        assertEquals(esperado, resultado);
    }

    @Test
    public void testConvertirDiasASemanas() throws TiempoInvalido {
        Tiempo esperado = new Tiempo("0.1428571428571429", UnidadesTiempo.SEMANA.get());
        Tiempo resultado = ConversorUniversal.convertir(dia, UnidadesTiempo.SEMANA.get());
        assertEquals(esperado, resultado);
    }

    @Test(expected = TiempoInvalido.class)
    public void testConvertirMesesAAños() throws TiempoInvalido {
        ConversorUniversal.convertir(new Tiempo("-12", UnidadesTiempo.MES.get()), UnidadesTiempo.AÑO.get());
    }
    
    @Test(expected = TiempoInvalido.class)
    public void testConvertirTextoATiempo() throws TiempoInvalido {
        ConversorUniversal.convertir(new Tiempo("abc", UnidadesTiempo.MES.get()), UnidadesTiempo.AÑO.get());
    }

    @Test(expected = TiempoInvalido.class)
    public void testConvertirTextoEnBlancoATiempo() throws TiempoInvalido {
        ConversorUniversal.convertir(new Tiempo("", UnidadesTiempo.MES.get()), UnidadesTiempo.AÑO.get());
    }
}
