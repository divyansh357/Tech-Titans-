import java.math.BigInteger;

public class ClosestPalindrome {
    public static String findClosestPalindrome(String n) {
        long number = Long.parseLong(n);

        // If the number is already a palindrome, exclude it
        if (isPalindrome(n)) {
            return findClosestPalindromeExclude(number);
        }

        // Find the closest palindrome directly
        long lower = findClosestLowerPalindrome(number);
        long higher = findClosestHigherPalindrome(number);

        // Return the closest one, breaking ties by the smaller number
        if (Math.abs(number - lower) <= Math.abs(number - higher)) {
            return String.valueOf(lower);
        } else {
            return String.valueOf(higher);
        }
    }

    // Check if a number is a palindrome
    private static boolean isPalindrome(String num) {
        int i = 0, j = num.length() - 1;
        while (i < j) {
            if (num.charAt(i) != num.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Find the nearest palindrome, excluding the number itself
    private static String findClosestPalindromeExclude(long number) {
        long lower = findClosestLowerPalindrome(number - 1);
        long higher = findClosestHigherPalindrome(number + 1);

        if (Math.abs(number - lower) <= Math.abs(higher - number)) {
            return String.valueOf(lower);
        } else {
            return String.valueOf(higher);
        }
    }

    // Find the closest smaller or equal palindrome
    private static long findClosestLowerPalindrome(long number) {
        for (long i = number; i >= 1; i--) {
            if (isPalindrome(String.valueOf(i))) {
                return i;
            }
        }
        return 1; // In the edge case, the smallest palindrome is 1
    }

    // Find the closest larger or equal palindrome
    private static long findClosestHigherPalindrome(long number) {
        for (long i = number; ; i++) {
            if (isPalindrome(String.valueOf(i))) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
        // Example input
        System.out.println(findClosestPalindrome("155"));  // Output: 151
        System.out.println(findClosestPalindrome("116"));  // Output: 111
        System.out.println(findClosestPalindrome("666"));  // Output: 656
    }
}
