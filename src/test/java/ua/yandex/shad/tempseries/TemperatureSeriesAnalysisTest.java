package ua.yandex.shad.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.InputMismatchException;

/**
 * Test structure
 *
 * /@Test
 * public void test[UnitOfWork_StateUnderTest_ExpectedBehavior]() {
 *     // Arrange
 *     ...
 *     // Act
 *     ...
 *     // Assert
 * }
 */

public class TemperatureSeriesAnalysisTest {

    /**
     * Used in double comparison
     */
    public static final double EPS = 5e-5;

    @Test
    public void testDefaultConstructor_size() {
        int expectedSize = 0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis();
        int actualSize = analysis.getArray().length;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testTemperatureSeriesConstructor_size() {
        double[] temps = {1.0, -1.0, 2.0};
        int expectedSize = 3;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        int actualSize = analysis.getArray().length;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testTempsConstructor_array() {
        double[] temps = {1.0, -1.0, 2.0};
        double[] expectedArray = {1.0, -1.0, 2.0};

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double[] actualArray = analysis.getArray();

        assertArrayEquals(expectedArray, actualArray, EPS);
    }

    @Test
    public void testTempsConstructor_modifyTempsArrayAfter() {
        double[] temps = {1.0, -1.0, 2.0};
        int index = 2;
        double newValue = -1.1;
        double[] expectedArray = {1.0, -1.0, 2.0};

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        temps[index] = newValue;
        double[] actualArray = analysis.getArray();

        assertArrayEquals(expectedArray, actualArray, EPS);
    }

    @Test(expected = InputMismatchException.class)
    public void testTempsConstructor_tempOutOfUpperBound() {
        double[] temps = {1.0, -274.0, 2.0};

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
    }

    @Test
    public void testTempsConstructor_upperBoundTemp() {
        double[] temps = {-273.0, -1.0, 2.0};
        double[] expectedArray = {-273.0, -1.0, 2.0};

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double[] actualArray = analysis.getArray();

        assertArrayEquals(expectedArray, actualArray, EPS);
    }
}
