public class ClockHands180 {
    public static int findMinimumTime(int H, int M) {
        // Constants for calculations
        final double HOUR_DEGREE_PER_HOUR = 7.5;  // Degrees moved by hour hand per hour
        final double HOUR_DEGREE_PER_MINUTE = 0.125; // Degrees moved by hour hand per minute
        final double MINUTE_DEGREE_PER_MINUTE = 6; // Degrees moved by minute hand per minute
        
        int minutesPassed = 0;

        while (true) {
            // Calculate the current hour and minute hand angles
            double hourAngle = H * HOUR_DEGREE_PER_HOUR + M * HOUR_DEGREE_PER_MINUTE;
            double minuteAngle = M * MINUTE_DEGREE_PER_MINUTE;

            // Calculate the absolute difference between the angles
            double angle = Math.abs(hourAngle - minuteAngle);
            angle = Math.min(angle, 360 - angle); // Get the smallest angle (clockwise or counterclockwise)

            // Check if the angle is 180 degrees
            if (Math.abs(angle - 180) < 1e-9) { // Account for floating-point precision
                return minutesPassed;
            }

            // Increment time by one minute
            M++;
            if (M == 60) {
                M = 0;
                H = (H + 1) % 48; // Wrap hours to stay within 0-47 range
            }
            minutesPassed++;
        }
    }

    public static void main(String[] args) {
        // Example input
        int H = 23, M = 45;

        // Find the minimum time to make the clock hands 180 degrees
        int result = findMinimumTime(H, M);
        System.out.println(result); // Output: 15
    }
}
