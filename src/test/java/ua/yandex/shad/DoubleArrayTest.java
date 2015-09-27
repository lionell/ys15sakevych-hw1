package ua.yandex.shad;

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
    public void testDefaultConstructor() {
        int expectedSize = 0;

        DoubleArray array = new DoubleArray();
        int actualSize = array.size();

        assertEquals(expectedSize, actualSize);
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