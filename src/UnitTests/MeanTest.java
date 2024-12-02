import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class MeanTest {

    @Test
    public void computeMean_ValidListOfNumbers_ReturnsMean() {
        // Arrange
        List<String> input = List.of("9", "6", "8", "5", "7");
        double expected = 7.0;

        // Act
        double result = Mean.calculateMean(input);

        // Assert
        assertEquals(expected, result, 1e-9, "The computed mean should match the expected value.");
    }

    @Test
    public void computeMean_EmptyList_ThrowsError() {
        // Arrange
        List<String> input = List.of();

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Mean.calculateMean(input),
                "An empty list should throw an IllegalArgumentException."
        );
        assertEquals("Input must contain at least one valid numeric value.", exception.getMessage());
    }

    @Test
    public void computeMean_ListWithNonNumericValues_ThrowsError() {
        // Arrange
        List<String> input = List.of("5", "abc", "7");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Mean.calculateMean(input),
                "A list with non-numeric values should throw an IllegalArgumentException."
        );
        assertEquals("Invalid numeric value in input: abc", exception.getMessage());
    }

    @Test
    public void computeMean_ListWithSpacesAndEmptyLines_IgnoresSpacesAndComputesMean() {
        // Arrange
        List<String> input = List.of(" 9 ", " ", "7", "", "6");
        double expected = 7.333333333333333;

        // Act
        double result = Mean.calculateMean(input);

        // Assert
        assertEquals(expected, result, 1e-9, "The computed mean should ignore empty lines and spaces.");
    }
}