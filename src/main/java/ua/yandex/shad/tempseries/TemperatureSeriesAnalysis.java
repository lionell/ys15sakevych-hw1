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
        checkEmptyArray();
        double sum = 0.0;
        for (int i = 0; i < array.size(); ++i) {
            sum += array.get(i);
        }
        return sum / array.size();
    }    
    
    public double deviation() {
        checkEmptyArray();
        double avg = average();
        double sum = 0.0;
        for (int i = 0; i < array.size(); ++i) {
            sum += (array.get(i) - avg) * (array.get(i) - avg);
        }
        return Math.sqrt(sum / array.size());
    }
    
    public double min() {
        checkEmptyArray();
        double result = array.get(0);
        for (int i = 1; i < array.size(); ++i) {
            result = Math.min(result, array.get(i));
        }
        return result;
    }
     
    public double max() {
        checkEmptyArray();
        double result = array.get(0);
        for (int i = 1; i < array.size(); ++i) {
            result = Math.max(result, array.get(i));
        }
        return result;
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
     * Package private method used in tests.
     *
     * @return array with stored data
     */
    double[] getArray() {
        return array.toArray();
    }

    /**
     * Checks lower bound of element in a given array.
     *
     * @param temps given array
     * @throws InputMismatchException
     *         if in array exists temp lower than LOWER_BOUND
     */
    private void checkLowerBound(double[] temps) {
        for (double temp : temps) {
            if (temp < LOWER_BOUND) {
                throw new InputMismatchException();
            }
        }
    }

    /**
     * Checks if array is empty.
     *
     * @throws IllegalArgumentException
     *         if array is empty
     */
    private void checkEmptyArray() {
        if (array.size() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
