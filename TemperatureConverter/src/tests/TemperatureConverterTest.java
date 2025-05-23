/*
 * This class tests the assertion test cases for the code for code coverage.
 * @author Rick Mercer and Muhammad Asifur Rahman
 */

package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.TemperatureConverter;

public class TemperatureConverterTest {

	@Test
	void testCelsiusToFahrenheit() {
		assertEquals(0, TemperatureConverter.FtoC(32));
		assertEquals(100, TemperatureConverter.FtoC(212));
		assertEquals(-17.7778, TemperatureConverter.FtoC(0), 0.0001);
		assertEquals(148.8889, TemperatureConverter.FtoC(300), 0.0001);
	}

	@Test
	void testFahrenheitToCelsius() {
		assertEquals(32, TemperatureConverter.CtoF(0));
		assertEquals(212, TemperatureConverter.CtoF(100));
		assertEquals(0, TemperatureConverter.CtoF(-17.7778), 0.0001);
		assertEquals(572, TemperatureConverter.CtoF(300), 0.0001);
	}
}
