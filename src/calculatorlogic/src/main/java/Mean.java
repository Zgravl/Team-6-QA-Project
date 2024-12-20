
import java.util.ArrayList;
import java.util.List;

public class Mean {
    public static double calculateMean(List<String> input) throws IllegalArgumentException {
        //preq-LOGIC-5
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
            throw new IllegalArgumentException("Input must contain at least one valid numeric value.");
        }

        // Calculate the mean
        double sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum / numbers.size();
    }
}
