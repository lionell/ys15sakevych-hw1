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
        double[] actualNums = array.toArray();

        assertArrayEquals(expectedNums, actualNums, EPS);
    }

    @Test
    public void testIsEmpty_defaultConstructor_true() {
        boolean expectedResult = true;

        DoubleArray array = new DoubleArray();
        boolean actualResult = array.isEmpty();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIsEmpty_numsConstructor_false() {
        double[] nums = {1.0, 2.0};
        boolean expectedResult = false;

        DoubleArray array = new DoubleArray(nums);
        boolean actualResult = array.isEmpty();

        assertEquals(expectedResult, actualResult);
    }
}