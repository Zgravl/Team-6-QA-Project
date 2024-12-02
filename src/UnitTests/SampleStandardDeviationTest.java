import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SampleStandardDeviationTest {

    @Test
    public void computeSampleStandardDeviation_ValidListOfSamples_ReturnsStandardDeviation() {
        // Arrange
        List<String> input = List.of("9", "6", "8", "5", "7");
        double expected = 1.5811388300841898;

        // Act
        double result = SampleStandardDeviation.calculateSampleStandardDeviation(input);

        // Assert
        assertEquals(expected, result, 1e-9, "The computed standard deviation should match the expected value.");
    }

    @Test
    public void computeSampleStandardDeviation_ListOfAllZeros_ReturnsZero() {
        // Arrange
        List<String> input = List.of("0", "0", "0", "0", "0");
        double expected = 0.0;

        // Act
        double result = SampleStandardDeviation.calculateSampleStandardDeviation(input);

        // Assert
        assertEquals(expected, result, 1e-9, "The computed standard deviation of all zeros should be zero.");
    }

    @Test
    public void computeSampleStandardDeviation_EmptyList_ThrowsError() {
        // Arrange
        List<String> input = List.of();

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> SampleStandardDeviation.calculateSampleStandardDeviation(input),
                "An empty list should throw an IllegalArgumentException."
        );
        assertEquals("Input must contain at least one valid numeric value.", exception.getMessage());
    }
}
