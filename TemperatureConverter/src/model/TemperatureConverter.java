/*
 * TemperatureConverter class for temperature conversion.
 * Implements static methods to convert temperatures between Celsius and Fahrenheit.
 * @author Rick Mercer and Muhammad Asifur Rahman
 */

package model;

public class TemperatureConverter {

	public static double FtoC(double f) {
		return (f - 32) * 5 / 9;
	}

	public static double CtoF(double c) {
		return (c * 9 / 5) + 32;
	}
}