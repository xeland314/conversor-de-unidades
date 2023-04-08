package conversores;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.xeland314.conversores.ConversorUniversal;
import com.xeland314.conversores.temperatura.Temperatura;
import com.xeland314.conversores.temperatura.TemperaturaInvalida;
import com.xeland314.conversores.temperatura.UnidadesTemperatura;

/**
 * @author xeland314
 *
 */
public class TestTemperatura {

	@Test
	public void testCelsiusToFahrenheit() throws TemperaturaInvalida {
		Temperatura entrada = new Temperatura("20", UnidadesTemperatura.CELSIUS.get());
		Temperatura esperado = new Temperatura("68", UnidadesTemperatura.FAHRENHEIT.get());
		Temperatura resultado = ConversorUniversal.convertir(entrada, UnidadesTemperatura.FAHRENHEIT.get());
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testFahrenheitToCelsius() throws TemperaturaInvalida {
		Temperatura entrada = new Temperatura(new BigDecimal("68"), UnidadesTemperatura.FAHRENHEIT.get());
		Temperatura esperado = new Temperatura(new BigDecimal("20"), UnidadesTemperatura.CELSIUS.get());
		Temperatura resultado = ConversorUniversal.convertir(entrada, UnidadesTemperatura.CELSIUS.get());
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testKelvinToRankine() throws TemperaturaInvalida {
		Temperatura entrada = new Temperatura(new BigDecimal("273.15"), UnidadesTemperatura.KELVIN.get());
		Temperatura esperado = new Temperatura(new BigDecimal("491.67"), UnidadesTemperatura.RANKINE.get());
		Temperatura resultado = ConversorUniversal.convertir(entrada, UnidadesTemperatura.RANKINE.get());
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testRankineToKelvin() throws TemperaturaInvalida {
		Temperatura entrada = new Temperatura(new BigDecimal("491.67"), UnidadesTemperatura.RANKINE.get());
		Temperatura esperado =  new Temperatura(new BigDecimal("273.15"), UnidadesTemperatura.KELVIN.get());
		Temperatura resultado = ConversorUniversal.convertir(entrada, UnidadesTemperatura.KELVIN.get());
		assertEquals(esperado, resultado);
	}

	@Test(expected = TemperaturaInvalida.class)
	public void testTemperaturaInvalidaCelsius() throws TemperaturaInvalida {
		Temperatura celsius = new Temperatura("-300", UnidadesTemperatura.CELSIUS.get());
		System.out.println(celsius);
	}

	@Test(expected = TemperaturaInvalida.class)
	public void testTemperaturaInvalidaFahrenheit() throws TemperaturaInvalida {
		Temperatura fahrenheit = new Temperatura("-500", UnidadesTemperatura.FAHRENHEIT.get());
		System.out.println(fahrenheit);
	}

	@Test(expected = TemperaturaInvalida.class)
	public void testTemperaturaInvalidaKelvin() throws TemperaturaInvalida {
		Temperatura kelvin = new Temperatura("-1", UnidadesTemperatura.KELVIN.get());
		System.out.println(kelvin);
	}

	@Test(expected = TemperaturaInvalida.class)
	public void testTemperaturaInvalidaRankine() throws TemperaturaInvalida {
		Temperatura rankine = new Temperatura("-1", UnidadesTemperatura.RANKINE.get());
		System.out.println(rankine);
	}
}
