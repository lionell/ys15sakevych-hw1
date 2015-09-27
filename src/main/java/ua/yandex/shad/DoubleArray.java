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
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        data = new double[capacity];
    }

    /**
     * Construct new DoubleArray with default capacity.
     */
    public DoubleArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Construct new DoubleArray from variable length list
     *
     * @param nums example of array
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
     * Converts DoubleArray to array of doubles
     *
     * @return new instance of array of double with elements from DoubleArray
     */
    public double[] toArray() {
        return data.clone();
    }

    /**
     * Returns element of DoubleArray on 'index' position.
     *
     * @param index number of element in DoubleArray
     * @return element on 'index' position
     * @throws IndexOutOfBoundsException
     *         if index < 0 or index >= size of DoubleArray
     */
    public double get(int index) {
        checkBounds(index);
        return data[index];
    }

    /**
     * Set element of DoubleArray on 'index' position to 'value'.
     *
     * @param index number of element in DoubleArray
     * @param value new value of element on 'index' position
     * @throws IndexOutOfBoundsException
     *         if index < 0 or index >= size of DoubleArray
     */
    public void set(int index, double value) {
        checkBounds(index);
        data[index] = value;
    }

    /**
     * Adds new element to the end of array
     * @param value value of element to add
     */
    public void add(double value) {
        // TODO: Implement this method
    }

    /**
     * Checks if array is empty.
     *
     * @return true if there are no elements in array
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks that index is in right range
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException
     *         if index < 0 or index >= size of DoubleArray
     */
    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}