package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForZero() {
        boolean result = CourseToolkit.isEven(0);

        assertTrue(result);
    }

    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForTwo() {
        boolean result = CourseToolkit.isPrime(1);

        assertFalse(result);
    }

    @Test
    void isPrimeTwoReturnsTrue() {
        boolean result = CourseToolkit.isPrime(2);

        assertTrue(result);
    }

    @Test
    void isPrimeCompositeReturnsFalse() {
        boolean result = CourseToolkit.isPrime(4);

        assertFalse(result);
    }

    @Test
    void isPrimeSquareOfPrimeReturnsFalse() {
        boolean result = CourseToolkit.isPrime(49);

        assertFalse(result);
    }



    @Test void isPalindromeSimpleTrue() {
        boolean result = CourseToolkit.isPalindrome("level");
        assertTrue(result);
    }
    @Test void isPalindromeNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.isPalindrome(null));
    }
    @Test void isPalindromeCaseMatters() {
        boolean result = CourseToolkit.isPalindrome("Level");
        assertFalse(result);
    }



    @Test
    void averageReturnsArithmeticMean() {
        double result = CourseToolkit.average(new int[] {1, 2, 3, 4});

        assertEquals(2.5, result);
    }

    @Test
    void averageHandlesNegativeNumbers() {
        double result = CourseToolkit.average(new int[] {-1, -2, -3, -4});

        assertEquals(-2.5, result);
    }

    @Test
    void averageThrowsForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> CourseToolkit.average(new int[] {}));
    }
}
