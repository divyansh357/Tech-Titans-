#include <iostream>
#include <string>
#include <algorithm>
#include <cmath>
using namespace std;

// Function to check if a number is a palindrome
bool isPalindrome(long long n) {
    string s = to_string(n);
    string rev = s;
    reverse(rev.begin(), rev.end());
    return s == rev;
}

// Function to generate the closest palindrome
long long closestPalindrome(long long n) {
    if (n <= 10) return n - 1; // For single-digit numbers, return the previous digit
    if (isPalindrome(n)) n--; // Move to the next number if `n` is already a palindrome

    long long lower = n - 1, higher = n + 1;

    // Expand outwards to find the closest palindrome
    while (true) {
        if (isPalindrome(lower)) return lower;   // Check lower first
        if (isPalindrome(higher)) return higher; // Then check higher
        lower--;
        higher++;
    }
}

int main() {
    long long n;
    cout << "Enter a positive number: ";
    cin >> n;

    if (n < 1 || n >= 1e18) {
        cout << "Invalid input! Number must be in the range [1, 10^18 - 1]." << endl;
        return 1;
    }

    cout << closestPalindrome(n) << endl;

    return 0;
}
