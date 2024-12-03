import java.util.ArrayList;
import java.util.List;

public class PopulationStandardDeviation{
    public static double calculatePopulationStandardDeviation(List<String> input) throws IllegalArgumentException {
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

        // Ensure there are at least two valid numeric values
        if (numbers.size() < 2) {
            throw new IllegalArgumentException("At least two valid numeric values are required.");
        }

        // Calculate the mean
        double sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        double mean = sum / numbers.size();

        // Calculate the population variance
        double varianceSum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            varianceSum += Math.pow(numbers.get(i) - mean, 2);
        }
        double populationVariance = varianceSum / numbers.size();

        // Return the population standard deviation
        return Math.sqrt(populationVariance);
    }
}