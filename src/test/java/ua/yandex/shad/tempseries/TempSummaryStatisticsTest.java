package ua.yandex.shad.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

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
        double actualMinTemp = statistics.getAvgTemp();

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
        double actualMaxTemp = statistics.getAvgTemp();

        assertEquals(expectedMaxTemp, actualMaxTemp, EPS);
    }
}
