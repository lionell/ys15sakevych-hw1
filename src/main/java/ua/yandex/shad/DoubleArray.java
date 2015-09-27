package ua.yandex.shad;

public class DoubleArray {
    private double[] data;
    private DoubleArray(double... nums) {
        data = new double[nums.length];
    }
}