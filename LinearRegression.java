import java.util.ArrayList;
import java.util.List;

public class LinearRegression{
    public static String computeLinearRegression(List<String> input) throws IllegalArgumentException {
        List<Double> xValues = new ArrayList<>();
        List<Double> yValues = new ArrayList<>();

        // Parse the input, ignoring empty lines and spaces
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i).trim();
            if (!line.isEmpty()) {
                String[] parts = line.split(",");
                if (parts.length != 2) {
                    throw new IllegalArgumentException("Each line must contain exactly two numeric values separated by a comma.");
                }

                try {
                    double x = Double.parseDouble(parts[0].trim());
                    double y = Double.parseDouble(parts[1].trim());
                    xValues.add(x);
                    yValues.add(y);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid numeric values in line: " + line);
                }
            }
        }

        // Ensure there are at least two X, Y pairs
        if (xValues.size() < 2 || yValues.size() < 2) {
            throw new IllegalArgumentException("There must be at least two valid X, Y pairs.");
        }

        // Calculate the means of X and Y
        double sumX = 0, sumY = 0;
        for (int i = 0; i < xValues.size(); i++) {
            sumX += xValues.get(i);
            sumY += yValues.get(i);
        }
        double meanX = sumX / xValues.size();
        double meanY = sumY / yValues.size();

        // Calculate the slope (m) and intercept (b)
        double numerator = 0;
        double denominator = 0;
        for (int i = 0; i < xValues.size(); i++) {
            double x = xValues.get(i);
            double y = yValues.get(i);
            numerator += (x - meanX) * (y - meanY);
            denominator += Math.pow(x - meanX, 2);
        }

        if (denominator == 0) {
            throw new IllegalArgumentException("Cannot compute linear regression; all X values are the same.");
        }

        double slope = numerator / denominator;
        double intercept = meanY - slope * meanX;

        // Return the linear regression formula as a string
        return String.format("y = %.15fx + %.15f", slope, intercept);
    }
}
