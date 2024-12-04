
import java.util.List;

public class RegressionPrediction {
    public static String predictYValue(List<String> input) throws IllegalArgumentException {
        // Ensure there is exactly one line of input
        if (input.size() != 1) {
            throw new IllegalArgumentException("Input must contain exactly one line with three numeric values separated by commas.");
        }

        String line = input.get(0).trim();

        // Split the line into values separated by commas
        String[] parts = line.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("The input must contain exactly three numeric values separated by commas.");
        }

        double x, m, b;
        try {
            x = Double.parseDouble(parts[0].trim());
            m = Double.parseDouble(parts[1].trim());
            b = Double.parseDouble(parts[2].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("All three values must be numeric.");
        }

        // Calculate the Y value using the regression formula
        double y = m * x + b;

        // Return the result in the specified format
        return String.format("y = %.15f", y);
    }
}
