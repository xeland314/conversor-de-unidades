package conversores;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.xeland314.conversores.divisas.Dinero;
import com.xeland314.conversores.divisas.DivisaInvalida;
import com.xeland314.conversores.divisas.Monedas;

public class TestDivisa {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testConvertirEurosA() throws DivisaInvalida {

    }

    @Test(expected = DivisaInvalida.class)
    public void testDivisaInvalida() throws DivisaInvalida {
        Dinero d = new Dinero("abc", Monedas.DOLAR.get());
        System.out.println(d);
    }

    @Test(expected = DivisaInvalida.class)
    public void testDivisaInvalida2() throws DivisaInvalida {
        Dinero d = new Dinero("-1111", Monedas.DOLAR.get());
        System.out.println(d);
    }

    @Test
    public void testDivisaValida() throws DivisaInvalida {
        Dinero d = new Dinero("0", Monedas.DOLAR.get());
        System.out.println(d);
    }
}
