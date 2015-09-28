package io.github.lionell;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test structure
 *
 * /@Test
 * public void test[UnitOfWork_StateUnderTest_ExpectedBehavior]() {
 *     // Arrange
 *     ...
 *     // Act
 *     ...
 *     // Assert
 * }
 */

public class DoubleArrayTest {

    public static final double EPS = 5e-5;

    @Test(expected = IllegalArgumentException.class)
    public void testCapacityConstructor_negativeCapacity_exception() {
        int capacity = -1;

        DoubleArray array = new DoubleArray(capacity);
    }

    @Test
    public void testDefaultConstructor_size() {
        int expectedSize = 0;

        DoubleArray array = new DoubleArray();
        int actualSize = array.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testDefaultConstructor_capacity() {
        int expectedCapacity = 10;

        DoubleArray array = new DoubleArray();
        int actualCapacity = array.capacity();

        assertEquals(expectedCapacity, actualCapacity);
    }

    @Test
    public void testNumsConstructor_size() {
        double[] nums = {1.0, 2.0, -1.0};
        int expectedSize = 3;

        DoubleArray array = new DoubleArray(nums);
        int actualSize = array.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testNumsConstructor_capacity() {
        double[] nums = {1.0, 2.0, -1.0};
        int expectedCapacity = 3;

        DoubleArray array = new DoubleArray(nums);
        int actualCapacity = array.capacity();

        assertEquals(expectedCapacity, actualCapacity);
    }

    @Test
    public void testNumsConstructor_modifyNumsArrayAfter() {
        double[] nums = {1.0, 2.0, -1.0};
        double[] expectedNums = nums.clone();

        DoubleArray array = new DoubleArray(nums);
        nums[0] = 2.0;
        double[] actualNums = array.toArray();

        assertArrayEquals(expectedNums, actualNums, EPS);
    }

    @Test
    public void testToArray_emptyArray() {
        double[] nums = {};
        double[] expectedNums = {};

        DoubleArray array = new DoubleArray(nums);
        double[] actualNums = array.toArray();

        assertArrayEquals(expectedNums, actualNums, EPS);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_emptyArray() {
        double[] nums = {};
        int index = 0;

        DoubleArray array = new DoubleArray(nums);
        array.get(index);
    }

    @Test
    public void testGet() {
        double[] nums = {1.0, 2.0, -1.0};
        int index = 1;
        double expectedResult = 2.0;

        DoubleArray array = new DoubleArray(nums);
        double actualResult = array.get(index);

        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_negativeIndex() {
        double[] nums = {1.0, -1.0, 2e-5};
        int index = -2;

        DoubleArray array = new DoubleArray(nums);
        array.get(index);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGet_indexGreaterThanSizeOfArray() {
        double[] nums = {1.0, -1.0, 2e-5};
        int index = 7;

        DoubleArray array = new DoubleArray(nums);
        array.get(index);
    }

    @Test
    public void testSet() {
        double[] nums = {1.0, 22.0, -1.0};
        int index = 1;
        double newValue = -0.7;
        double[] expectedArray = {1.0, -0.7, -1.0};

        DoubleArray array = new DoubleArray(nums);
        array.set(index, newValue);
        double[] actualArray = array.toArray();

        assertArrayEquals(expectedArray, actualArray, EPS);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet_negativeIndex() {
        double[] nums = {1.0, 2e-5, -2e-5};
        int index = -7;
        double newValue = 0.6;

        DoubleArray array = new DoubleArray(nums);
        array.set(index, newValue);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSet_indexGreaterThanSizeOfArray() {
        double[] nums = {0.0, 2e-5, -2e-5};
        int index = 4;
        double newValue = -4.5;

        DoubleArray array = new DoubleArray(nums);
        array.set(index, newValue);
    }

    @Test
    public void testEnsureCapacity_minCapacityIsLessThanCurrent() {
        double[] nums = {2.0, -1e2, 0.0, 3.0};
        int minCapacity = 3;
        int expectedCapacity = 4;

        DoubleArray array = new DoubleArray(nums);
        array.ensureCapacity(minCapacity);
        int actualCapacity = array.capacity();

        assertEquals(expectedCapacity, actualCapacity);
    }

    @Test
    public void testEnsureCapacity_minCapacityIsLessThanDoubledCurrent() {
        double[] nums = {2.0, -1e2, 0.1, 3.0};
        int minCapacity = 5;
        int expectedCapacity = 8;

        DoubleArray array = new DoubleArray(nums);
        array.ensureCapacity(minCapacity);
        int actualCapacity = array.capacity();

        assertEquals(expectedCapacity, actualCapacity);
    }

    @Test
    public void testEnsureCapacity_minCapacityIsMoreThanDoubledCurrent() {
        double[] nums = {2.0, -1e2, 1.0, 3.0};
        int minCapacity = 15;
        int expectedCapacity = 15;

        DoubleArray array = new DoubleArray(nums);
        array.ensureCapacity(minCapacity);
        int actualCapacity = array.capacity();

        assertEquals(expectedCapacity, actualCapacity);
    }

    @Test
    public void testAdd_arraySize() {
        double[] nums = {2.0, -1e2, 0.0, 3.0};
        double newValue = 4.0;
        int expectedSize = 5;

        DoubleArray array = new DoubleArray(nums);
        array.add(newValue);
        int actualSize = array.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testAdd_arrayCapacity() {
        double[] nums = {2.0, -1e2, 0.0, 3.0};
        double newValue = 4.0;
        int expectedCapacity = 8;

        DoubleArray array = new DoubleArray(nums);
        array.add(newValue);
        int actualCapacity = array.capacity();

        assertEquals(expectedCapacity, actualCapacity);
    }

    @Test
    public void testAdd_array() {
        double[] nums = {2.0, -1e2, 0.0, 3.0};
        double newValue = 4.0;
        double[] expectedArray = {2.0, -1e2, 0.0, 3.0, 4.0};

        DoubleArray array = new DoubleArray(nums);
        array.add(newValue);
        double[] actualArray = array.toArray();

        assertArrayEquals(expectedArray, actualArray, EPS);
    }

    @Test
    public void testIsEmpty_emptyArray_true() {
        boolean expectedResult = true;

        DoubleArray array = new DoubleArray();
        boolean actualResult = array.isEmpty();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsEmpty_notEmptyArray_false() {
        double[] nums = {1.0, 2.0};
        boolean expectedResult = false;

        DoubleArray array = new DoubleArray(nums);
        boolean actualResult = array.isEmpty();

        assertEquals(expectedResult, actualResult);
    }
}