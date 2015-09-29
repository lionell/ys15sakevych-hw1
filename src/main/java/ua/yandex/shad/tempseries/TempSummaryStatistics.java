package ua.yandex.shad.tempseries;

public class TempSummaryStatistics {

    /**
     * Average temperature from array.
     */
    private final double avgTemp;

    /**
     * Deviation of temperatures from array.
     */
    private final double devTemp;

    /**
     * Minimal temperature from array.
     */
    private final double minTemp;

    /**
     * Maximal temperature from array.
     */
    private final double maxTemp;

    /**
     * Constructs object with fields based on data.
     */
    public TempSummaryStatistics(double avgTemp,
                                 double devTemp,
                                 double minTemp,
                                 double maxTemp) {
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    /**
     * Getter for 'avgTemp'
     */
    public double getAvgTemp() {
        return avgTemp;
    }

    /**
     * Getter for 'devTemp'
     */
    public double getDevTemp() {
        return devTemp;
    }

    /**
     * Getter for 'minTemp'
     */
    public double getMinTemp() {
        return minTemp;
    }

    /**
     * Getter for 'maxTemp'
     */
    public double getMaxTemp() {
        return maxTemp;
    }
}
