package ua.yandex.shad.tempseries;

import static org.junit.Assert.*;

import com.sun.javafx.util.TempState;
import org.junit.Test;
import org.omg.CORBA.portable.UnknownException;

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

public class TempSummaryStatisticsTest {

    public static final double EPS = 5e-5;

    @Test
    public void testGetAvgTemp() {
        double avgTemp = 5.0;
        double devTemp = 1.1;
        double minTemp = 2.2;
        double maxTemp = 3.3;
        double expectedAvgTemp = 5.0;

        TempSummaryStatistics statistics =
                new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
        double actualAvgTemp = statistics.getAvgTemp();

        assertEquals(expectedAvgTemp, actualAvgTemp, EPS);
    }

    @Test
    public void testGetDevTemp() {
        double avgTemp = 5.0;
        double devTemp = 1.1;
        double minTemp = 2.2;
        double maxTemp = 3.3;
        double expectedDevTemp = 1.1;

        TempSummaryStatistics statistics =
                new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
        double actualDevTemp = statistics.getDevTemp();

        assertEquals(expectedDevTemp, actualDevTemp, EPS);
    }

    @Test
    public void testGetMinTemp() {
        double avgTemp = 5.0;
        double devTemp = 1.1;
        double minTemp = 2.2;
        double maxTemp = 3.3;
        double expectedMinTemp = 2.2;

        TempSummaryStatistics statistics =
                new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
        double actualMinTemp = statistics.getMinTemp();

        assertEquals(expectedMinTemp, actualMinTemp, EPS);
    }

    @Test
    public void testGetMaxTemp() {
        double avgTemp = 5.0;
        double devTemp = 1.1;
        double minTemp = 2.2;
        double maxTemp = 3.3;
        double expectedMaxTemp = 3.3;

        TempSummaryStatistics statistics =
                new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
        double actualMaxTemp = statistics.getMaxTemp();

        assertEquals(expectedMaxTemp, actualMaxTemp, EPS);
    }

    @Test
    public void testEquals_nullReference_false() {
        double avgTemp = 1.1;
        double devTemp = 2.2;
        double minTemp = 3.3;
        double maxTemp = 4.4;
        Object other = null;

        TempSummaryStatistics statistics =
                new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
        boolean result = statistics.equals(other);

        assertFalse(result);
    }

    @Test
    public void testEquals_typeMismatch_false() {
        double avgTemp = 1.1;
        double devTemp = 2.2;
        double minTemp = 3.3;
        double maxTemp = 4.4;
        Object other = new Double(1);

        TempSummaryStatistics statistics =
                new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
        boolean result = statistics.equals(other);

        assertFalse(result);
    }

    @Test
    public void testEquals_unequalAvgTemp_false() {
        double avgTemp = 1.1;
        double devTemp = 2.2;
        double minTemp = 3.3;
        double maxTemp = 4.4;
        TempSummaryStatistics other = new TempSummaryStatistics(0.1, 2.2, 3.3, 4.4);

        TempSummaryStatistics statistics =
                new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
        boolean result = statistics.equals(other);

        assertFalse(result);
    }

    @Test
    public void testEquals_unequalDevTemp_false() {
        double avgTemp = 1.1;
        double devTemp = 2.2;
        double minTemp = 3.3;
        double maxTemp = 4.4;
        TempSummaryStatistics other = new TempSummaryStatistics(1.1, 0.2, 3.3, 4.4);

        TempSummaryStatistics statistics =
                new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
        boolean result = statistics.equals(other);

        assertFalse(result);
    }

    @Test
    public void testEquals_unequalMinTemp_false() {
        double avgTemp = 1.1;
        double devTemp = 2.2;
        double minTemp = 3.3;
        double maxTemp = 4.4;
        TempSummaryStatistics other = new TempSummaryStatistics(1.1, 2.2, 0.3, 4.4);

        TempSummaryStatistics statistics =
                new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
        boolean result = statistics.equals(other);

        assertFalse(result);
    }

    @Test
    public void testEquals_unequalMaxTemp_false() {
        double avgTemp = 1.1;
        double devTemp = 2.2;
        double minTemp = 3.3;
        double maxTemp = 4.4;
        TempSummaryStatistics other = new TempSummaryStatistics(1.1, 2.2, 3.3, 0.4);

        TempSummaryStatistics statistics =
                new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
        boolean result = statistics.equals(other);

        assertFalse(result);
    }

    @Test
    public void testEquals_unequalObject_false() {
        double avgTemp = 1.1;
        double devTemp = 2.2;
        double minTemp = 3.3;
        double maxTemp = 4.4;
        TempSummaryStatistics other = new TempSummaryStatistics(0.1, 2.2, 0.3, -4.4);

        TempSummaryStatistics statistics =
                new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
        boolean result = statistics.equals(other);

        assertFalse(result);
    }

    @Test
    public void testEquals_equalObject_true() {
        double avgTemp = 1.1;
        double devTemp = 2.2;
        double minTemp = 3.3;
        double maxTemp = 4.4;
        TempSummaryStatistics other = new TempSummaryStatistics(1.1, 2.2, 3.3, 4.4);

        TempSummaryStatistics statistics =
                new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
        boolean result = statistics.equals(other);

        assertTrue(result);
    }
}
