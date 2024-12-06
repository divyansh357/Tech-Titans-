#include <iostream>
#include <string>

// Optimized function to count vowels
int countVowels(const std::string& input) {
    int count = 0;

    for (char c : input) {
        // Convert to lowercase using bitwise operation and check if it's a vowel
        switch (c | 32) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
                ++count;
        }
    }

    return count;
}

int main() {
    // Taking input from the user
    std::string A;
    std::cout << "Enter a string: ";
    std::getline(std::cin, A);  // Allows spaces in input

    // Call the countVowels function and output the result
    std::cout << "Number of vowels: " << countVowels(A) << std::endl;

    return 0;
}