import java.util.List;
package tests;

public class ZScore{
    public static double calculateZScore(List<String> input) throws IllegalArgumentException {
        // Ensure there is exactly one line of input
        if (input.size() != 1) {
            throw new IllegalArgumentException("Input must contain exactly one line.");
        }

        String line = input.get(0).trim();

        // Split the line into values separated by commas
        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("The input must contain exactly three numeric values separated by commas.");
        }

        double value, mean, stdDev;
        try {
            value = Double.parseDouble(parts[0].trim());
            mean = Double.parseDouble(parts[1].trim());
            stdDev = Double.parseDouble(parts[2].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("All three values must be numeric.");
        }

        // Ensure standard deviation is not zero
        if (stdDev == 0) {
            throw new IllegalArgumentException("Standard deviation cannot be zero.");
        }

        // Calculate the z-score
        return (value - mean) / stdDev;
    }
}