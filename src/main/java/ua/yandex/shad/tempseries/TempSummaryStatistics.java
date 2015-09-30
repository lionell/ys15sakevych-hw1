package ua.yandex.shad.tempseries;

public class TempSummaryStatistics {

    public static final double EPS = 5e-5;

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
     * @param other should be instance of TempSummaryStatistics to compare
     * @return true, if Statistics are equal
     *         false, otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }
        TempSummaryStatistics example = (TempSummaryStatistics) other;
        return Math.abs(example.getAvgTemp() - getAvgTemp()) < EPS
                && Math.abs(example.getDevTemp() - getDevTemp()) < EPS
                && Math.abs(example.getMinTemp() - getMinTemp()) < EPS
                && Math.abs(example.getMaxTemp() - getMaxTemp()) < EPS;
    }

    /**
     * Overriding Object's hashCode implementation.
     * @return some hash of object
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) getAvgTemp();
        result = prime * result + (int) getDevTemp();
        result = prime * result + (int) getMinTemp();
        result = prime * result + (int) getMaxTemp();
        return result;
    }
}
