package ua.yandex.shad;

public class DoubleArray {

    /**
     * The default capacity of new DoubleArrays.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Storage for data.
     */
    private double[] data;

    /**
     * Actual size of array.
     */
    private int size;

    /**
     * Construct new DoubleArray with initial capacity.
     *
     * @param capacity initial capacity of DoubleArray
     * @throws IllegalArgumentException if capacity is negative
     */
    public DoubleArray(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException();
        data = new double[capacity];
    }

    /**
     * Construct new DoubleArray with default capacity.
     */
    public DoubleArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     *
     *
     */
    public DoubleArray(double... nums) {
        data = nums.clone();
        size = nums.length;
    }

    /**
     * Returns the number of elements in array.
     *
     * @return array size
     */
    public int size() {
        return size;
    }

    /**
     * Checks if array is empty.
     *
     * @return true if there are no elements in array
     */
    public boolean isEmpty() {
        return size == 0;
    }
}