import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
class ZScoreTest {

    @Test
    public void computeZScore_ValidParameters_ReturnsCorrectZScore() {
        // Arrange
        List<String> input = List.of("11.5, 7, 1.5811388300841898");
        double expected = 2.846049894151541;

        // Act
        double result = ZScore.calculateZScore(input);

        // Assert
        assertEquals(expected, result, 1e-9, "The computed z-score should match the expected value.");
    }

    @Test
    public void computeZScore_MissingOneParameter_ThrowsError() {
        // Arrange
        List<String> input = List.of("11.5, 7");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "A missing parameter should throw an IllegalArgumentException."
        );
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void computeZScore_ExtraParameters_ThrowsError() {
        // Arrange
        List<String> input = List.of("11.5, 7, 1.5811388300841898, 3");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "An extra parameter should throw an IllegalArgumentException."
        );
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void computeZScore_EmptyInput_ThrowsError() {
        // Arrange
        List<String> input = List.of("");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "An empty input should throw an IllegalArgumentException."
        );
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void computeZScore_NonNumericInput_ThrowsError() {
        // Arrange
        List<String> input = List.of("11.5, abc, 1.5811388300841898");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "Non-numeric input should throw an IllegalArgumentException."
        );
        assertEquals("All three values must be numeric.", exception.getMessage());
    }

    @Test
    public void computeZScore_StandardDeviationIsZero_ThrowsError() {
        // Arrange
        List<String> input = List.of("11.5, 7, 0");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "A standard deviation of zero should throw an IllegalArgumentException."
        );
        assertEquals("Standard deviation cannot be zero.", exception.getMessage());
    }

    @Test
    public void computeZScore_MultipleLines_ThrowsError() {
        // Arrange
        List<String> input = List.of("11.5, 7, 1.5811388300841898","5, 2, 1");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "Multiple lines of input should throw an IllegalArgumentException."
        );
        assertEquals("Input must contain exactly one line.", exception.getMessage());
    }
}