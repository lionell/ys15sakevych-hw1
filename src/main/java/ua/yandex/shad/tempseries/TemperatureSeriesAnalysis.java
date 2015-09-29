package ua.yandex.shad.tempseries;

import io.github.lionell.DoubleArray;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    public static final double EPS = 5e-5;
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
        checkEmptyArray();
        double result = array.get(0);
        for (int i = 1; i < array.size(); ++i) {
            double temp = array.get(i);
            if (Math.abs(temp) < Math.abs(result)
                    || Math.abs(Math.abs(temp) - Math.abs(result)) < EPS
                    && result < temp) {
                result = temp;
            }
        }
        return result;
    }
    
    public double findTempClosestToValue(double tempValue) {
        checkEmptyArray();
        double result = array.get(0);
        for (int i = 1; i < array.size(); ++i) {
            double temp = array.get(i);
            if (Math.abs(temp - tempValue)
                    < Math.abs(result - tempValue)
                    || Math.abs(Math.abs(temp - tempValue)
                    - Math.abs(result - tempValue)) < EPS
                    && result < temp) {
                result = temp;
            }
        }
        return result;
}
    
    public double[] findTempsLessThen(double tempValue) {
        checkEmptyArray();
        DoubleArray temps = new DoubleArray();
        for (int i = 0; i < array.size(); ++i) {
            double temp = array.get(i);
            if (temp < tempValue) {
                temps.add(temp);
            }
        }
        return temps.toArray();
    }
    
    public double[] findTempsGreaterThen(double tempValue) {
        checkEmptyArray();
        DoubleArray temps = new DoubleArray();
        for (int i = 0; i < array.size(); ++i) {
            double temp = array.get(i);
            if (temp >= tempValue) {
                temps.add(temp);
            }
        }
        return temps.toArray();
    }
    
    public TempSummaryStatistics summaryStatistics() {
        checkEmptyArray();
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }
    
    public int addTemps(double[] temps) {
        checkLowerBound(temps);
        array.add(temps);
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
