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

        new TemperatureSeriesAnalysis(temps);
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

    @Test
    public void testMax_arrayWithOneTemp() {
        double[] temps = {56.0};
        double expectedResult = 56.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.max();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testMax_arrayWithEqualTemps() {
        double[] temps = {-4.0, -4.0, -4.0, -4e0};
        double expectedResult = -4.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.max();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testMax_result() {
        double[] temps = {2.0, -14.0, -2.0, 100.0};
        double expectedResult = 100.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.max();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZero_emptyArray() {
        double[] temps = {};

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        analysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZero_arrayWithOneTemp() {
        double[] temps = {56.0};
        double expectedResult = 56.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.findTempClosestToZero();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testFindTempClosestToZero_onlyPositiveTemps() {
        double[] temps = {2.0, 14.0, 2.0, 100.0};
        double expectedResult = 2.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.findTempClosestToZero();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testFindTempClosestToZero_arrayWithDifferentTemps() {
        double[] temps = {-20.0, 14.0, -2.0, 100.0};
        double expectedResult = -2.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.findTempClosestToZero();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testFindTempClosestToZero_twoTempsWithEqualDistFirstNegative() {
        double[] temps = {-2.0, 14.0, 2.0, 100.0};
        double expectedResult = 2.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.findTempClosestToZero();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testFindTempClosestToZero_twoTempsWithEqualDistFirstPositive() {
        double[] temps = {2.0, 14.0, -2.0, 100.0};
        double expectedResult = 2.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.findTempClosestToZero();

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValue_emptyArray() {
        double[] temps = {};
        double tempValue = 42;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        analysis.findTempClosestToValue(tempValue);
    }

    @Test
    public void testFindTempClosestToValue_arrayWithOneTemp() {
        double[] temps = {56.0};
        double tempValue = 45.78;
        double expectedResult = 56.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.findTempClosestToValue(tempValue);

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testFindTempClosestToValue_arrayWithGreaterTemps() {
        double[] temps = {40.0, 27.0, 35.0, 30.0};
        double tempValue = 25.0;
        double expectedResult = 27.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.findTempClosestToValue(tempValue);

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testFindTempClosestToValue_arrayWithLowerTemps() {
        double[] temps = {40.0, 27.0, 35.0, 30.0};
        double tempValue = 60.0;
        double expectedResult = 40.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.findTempClosestToValue(tempValue);

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testFindTempClosestToValue_arrayWithDifferentTemps() {
        double[] temps = {-40.0, 27.0, -35.0, 2.0, 30.0};
        double tempValue = 10.0;
        double expectedResult = 2.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.findTempClosestToValue(tempValue);

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testFindTempClosestToValue_twoTempsWithEqualDistFirstPositive() {
        double[] temps = {3.0, 14.0, -1.0, 100.0};
        double tempValue = 1.0;
        double expectedResult = 3.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.findTempClosestToValue(tempValue);

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    public void testFindTempClosestToValue_twoTempsWithEqualDistFirstNegative() {
        double[] temps = {-1.0, 14.0, 3.0, 100.0};
        double tempValue = 1.0;
        double expectedResult = 3.0;

        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(temps);
        double actualResult = analysis.findTempClosestToValue(tempValue);

        assertEquals(expectedResult, actualResult, EPS);
    }
}
