package edu.course.lab01;

public final class CourseToolkit {

    private CourseToolkit() { }

    public static boolean isEven(int number) { return number % 2 == 0; }

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isPalindrome(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Не должно быть пусто");
        }
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }

    public static double average(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("values must not be null or empty");
        }
        long sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }

}