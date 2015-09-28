package ua.yandex.shad.tempseries;

import io.github.lionell.DoubleArray;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    public static final double LOWER_BOUND = -273;

    private DoubleArray array;

    public TemperatureSeriesAnalysis() {
        array = new DoubleArray();
    }
    
    public TemperatureSeriesAnalysis(double[] temps) {
        checkLowerBound(temps);
        array = new DoubleArray(temps);
    }
    
    public double average() {
        return 0;
    }    
    
    public double deviation() {
        return 0;
    }
    
    public double min() {
        return 0;
    }
     
    public double max() {
        return 0;
    }
    
    public double findTempClosestToZero() {
        return 0;
    }
    
    public double findTempClosestToValue(double tempValue) {
        return 0;
}
    
    public double[] findTempsLessThen(double tempValue) {
        return null;
    }
    
    public double[] findTempsGreaterThen(double tempValue) {
        return null;
    }
    
    public TempSummaryStatistics summaryStatistics() {
        return null;
    }
    
    public int addTemps(double[] temps) {
        return 0;
    }

    /**
     * Package private method used in tests
     *
     * @return array with stored data
     */
    double[] getArray() {
        return array.toArray();
    }

    /**
     *
     */
    private void checkLowerBound(double[] temps) {
        for (double temp : temps) {
            if (temp < LOWER_BOUND) {
                throw new InputMismatchException();
            }
        }
    }
}
