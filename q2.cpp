#include <iostream>
#include <cmath>
using namespace std;

// Function to calculate the angle difference between hour and minute hands
double calculateAngle(int H, int M) {
    // Calculate the angles of hour and minute hands
    double hourAngle = (H % 48) * 7.5 + (M * 7.5 / 60); // Hour hand: 7.5° per hour
    double minuteAngle = M * 6;                        // Minute hand: 6° per minute

    // Find the absolute difference and normalize within [0, 360]
    double diff = fabs(hourAngle - minuteAngle);
    return min(diff, 360 - diff); // Return the smaller angle
}

// Function to find the minimum time to reach 180° angle
int findMinimumTime(int H, int M) {
    for (int minutes = 0; minutes < 48 * 60; ++minutes) { // Iterate for all possible minutes in 48 hours
        int newH = (H + (M + minutes) / 60) % 48;         // Update hour (roll over at 48)
        int newM = (M + minutes) % 60;                   // Update minutes (roll over at 60)

        // Check if the angle between hands is 180°
        if (fabs(calculateAngle(newH, newM) - 180) < 1e-6) {
            return minutes; // Return the minimum time in minutes
        }
    }
    return -1; // Should never reach here
}

int main() {
    int H, M;
    cout << "Enter the current time (hours and minutes): ";
    cin >> H >> M;

    // Input validation
    if (H < 0 || H >= 48 || M < 0 || M >= 60) {
        cout << "Invalid time input!" << endl;
        return 1;
    }

    // Find and print the minimum time to make 180° angle
    cout << findMinimumTime(H, M) << endl;

    return 0;
}
