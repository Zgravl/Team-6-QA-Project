import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
class PopulationStandardDeviationTest {

    @Test
    public void computePopulationStandardDeviation_ValidListOfSamples_ReturnsStandardDeviation() {
        // Arrange
        List<String> input = List.of("9", "6", "8", "5", "7");
        double expected = 1.4142135623730951;

        // Act
        double result = PopulationStandardDeviation.calculatePopulationStandardDeviation(input);

        // Assert
        assertEquals(expected, result, 1e-9, "The computed population standard deviation should match the expected value.");
    }

    @Test
    public void computePopulationStandardDeviation_ListOfAllZeros_ReturnsZero() {
        // Arrange
        List<String> input = List.of("0", "0", "0", "0", "0");
        double expected = 0.0;

        // Act
        double result = PopulationStandardDeviation.calculatePopulationStandardDeviation(input);

        // Assert
        assertEquals(expected, result, 1e-9, "The computed population standard deviation of all zeros should be zero.");
    }

    @Test
    public void computePopulationStandardDeviation_EmptyList_ThrowsError() {
        // Arrange
        List<String> input = List.of();

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> PopulationStandardDeviation.calculatePopulationStandardDeviation(input),
                "An empty list should throw an IllegalArgumentException."
        );
        assertEquals("Input must contain at least two valid numeric values.", exception.getMessage());
    }

    @Test
    public void computePopulationStandardDeviation_ListWithOneSample_ThrowsError() {
        // Arrange
        List<String> input = List.of("42");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> PopulationStandardDeviation.calculatePopulationStandardDeviation(input),
                "A list with one sample should throw an IllegalArgumentException."
        );
        assertEquals("Input must contain at least two valid numeric values.", exception.getMessage());
    }


    @Test
    public void computePopulationStandardDeviation_ListWithNonNumericValues_ThrowsError() {
        // Arrange
        List<String> input = List.of("5", "abc", "7");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> PopulationStandardDeviation.calculatePopulationStandardDeviation(input),
                "A list with non-numeric values should throw an IllegalArgumentException."
        );
        assertEquals("Invalid numeric value in input: abc", exception.getMessage());
    }

    @Test
    public void computePopulationStandardDeviation_ListWithSpacesAndEmptyLines_IgnoresSpacesAndComputesStandardDeviation() {
        // Arrange
        List<String> input = List.of(" 9 ", " ", "7", "", "6");
        double expected = 1.247219128924647;

        // Act
        double result = PopulationStandardDeviation.calculatePopulationStandardDeviation(input);

        // Assert
        assertEquals(expected, result, 1e-9, "The computed population standard deviation should ignore empty lines and spaces.");
    }
}