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
    public void testTempsConstructor_tempOutOfLowerBound() {
        double[] temps = {1.0, -274.0, 2.0};

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
    }

    @Test
    public void testTempsConstructor_exactLowerBoundTemp() {
        double[] temps = {-273.0, -1.0, 2.0};
        double[] expectedArray = {-273.0, -1.0, 2.0};

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double[] actualArray = analysis.getArray();

        assertArrayEquals(expectedArray, actualArray, EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverage_emptyArray() {
        double[] temps = {};

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        analysis.average();
    }

    @Test
    public void testAverage_arrayWithOneTemp() {
        double[] temps = {1.0};
        double expectedResult = 1.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.average();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testAverage_arrayWithEqualTemps() {
        double[] temps = {-7.0, -7.0, -7.0, -7e0};
        double expectedResult = -7.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.average();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testAverage_result() {
        double[] temps = {1.0, -2.0, 3.0, 0.0};
        double expectedResult = 0.5;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.average();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviation_emptyArray() {
        double[] temps = {};

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        analysis.deviation();
    }

    @Test
    public void testDeviation_arrayWithOneTemp() {
        double[] temps = {-7.0};
        double expectedResult = 0.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.deviation();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testDeviation_arrayWithEqualTemps() {
        double[] temps = {-4.0, -4.0, -4.0, -4e0};
        double expectedResult = 0.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.deviation();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testDeviation_result() {
        double[] temps = {2.0, -2.0, -2.0, 2.0};
        double expectedResult = 2.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.deviation();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMin_emptyArray() {
        double[] temps = {};

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        analysis.min();
    }

    @Test
    public void testMin_arrayWithOneTemp() {
        double[] temps = {-7.0};
        double expectedResult = -7.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.min();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testMin_arrayWithEqualTemps() {
        double[] temps = {-4.0, -4.0, -4.0, -4e0};
        double expectedResult = -4.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.min();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testMin_result() {
        double[] temps = {2.0, -14.0, -2.0, 100.0};
        double expectedResult = -14.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.min();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMax_emptyArray() {
        double[] temps = {};

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        analysis.max();
    }
}
