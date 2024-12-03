
import java.util.ArrayList;
import java.util.List;

public class SampleStandardDeviation {
    public static double calculateSampleStandardDeviation(List<String> input) throws IllegalArgumentException {
        List<Double> numbers = new ArrayList<>();

        // Parse the input, ignoring empty lines and spaces
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            String trimmed = line.trim();
            if (!trimmed.isEmpty()) {
                try {
                    numbers.add(Double.parseDouble(trimmed));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid numeric value in input: " + trimmed);
                }
            }
        }

        // Ensure there's at least one valid numeric value
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("No valid numeric values provided.");
        }

        // Calculate the mean
        double sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            double num = numbers.get(i);
            sum += num;
        }
        double mean = sum / numbers.size();

        // Calculate the sample variance
        double varianceSum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            double num = numbers.get(i);
            varianceSum += Math.pow(num - mean, 2);
        }
        double sampleVariance = varianceSum / (numbers.size() - 1);

        // Return the sample standard deviation
        return Math.sqrt(sampleVariance);
    }
}