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

    @Test
    public void testDoubleArray_defaultConstructor_zeroSize() {
        DoubleArray array = new DoubleArray();
        int expectedSize = 0;
        int actualSize = array.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDoubleArray_withNegativeCapacity_exception() {
        int capacity = -1;
        DoubleArray array = new DoubleArray(capacity);
    }
}