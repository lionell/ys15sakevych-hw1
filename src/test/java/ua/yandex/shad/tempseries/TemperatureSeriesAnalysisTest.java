package ua.yandex.shad.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

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

    /*@Test
    public void testAverage_SingleElementList() {
        double[] temperatureSeries = {1.0};
        double expResult = 1.0;
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverage_FailOnEmptyList() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double actualResult = seriesAnalysis.average();
    }*/
}
