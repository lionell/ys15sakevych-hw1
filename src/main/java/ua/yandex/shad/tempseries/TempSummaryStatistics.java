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

    /**
     * Overriding Object's equals implementation.
     * Checks two TempSummaryStatistics on equality.
     *
     * @param example instance of TempSummaryStatistics to compare
     * @return true, if objects are equal
     *         false, otherwise
     */
    public boolean equals(TempSummaryStatistics example) {
        return (example.getAvgTemp() == getAvgTemp()
                && example.getDevTemp() == getDevTemp()
                && example.getMinTemp() == getMinTemp()
                && example.getMaxTemp() == getMaxTemp());
    }
}
