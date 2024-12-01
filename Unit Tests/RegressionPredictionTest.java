import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class RegressionPredictionTest {

    @Test
    public void computeRegressionPrediction_ValidParameters_ReturnsCorrectPrediction() {
        // Arrange
        List<String> input = List.of("1.535, 61.272186542107434, -39.061955918838656");
        String expected = "y = 54.990850423296244";

        // Act
        String result = RegressionPrediction.predictYValue(input);

        // Assert
        assertEquals(expected, result, "The regression prediction should match the expected value.");
    }

    @Test
    public void computeRegressionPrediction_MissingParameters_ThrowsError() {
        // Arrange
        List<String> input = List.of("1.535, 61.272186542107434");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> RegressionPrediction.predictYValue(input),
                "Missing parameters should throw an IllegalArgumentException."
        );
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void computeRegressionPrediction_ExtraSpacesInInput_ReturnsCorrectPrediction() {
        // Arrange
        List<String> input = List.of(" 1.535  ,  61.272186542107434  ,   -39.061955918838656 ");
        String expected = "y = 54.990850423296244";

        // Act
        String result = RegressionPrediction.predictYValue(input);

        // Assert
        assertEquals(expected, result, "Extra spaces in the input should not affect the prediction calculation.");
    }

    @Test
    public void computeRegressionPrediction_InvalidNumericValues_ThrowsError() {
        // Arrange
        List<String> input = List.of("1.535, abc, -39.061955918838656");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> RegressionPrediction.predictYValue(input),
                "Non-numeric values should throw an IllegalArgumentException."
        );
        assertEquals("All three values must be numeric.", exception.getMessage());
    }

    @Test
    public void computeRegressionPrediction_OnlyTwoValuesProvided_ThrowsError() {
        // Arrange
        List<String> input = List.of("1.535, 61.272186542107434");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> RegressionPrediction.predictYValue(input),
                "Less than three values should throw an IllegalArgumentException."
        );
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void computeRegressionPrediction_MoreThanThreeValues_ThrowsError() {
        // Arrange
        List<String> input = List.of("1.535, 61.272186542107434, -39.061955918838656, 42.0");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> RegressionPrediction.predictYValue(input),
                "More than three values should throw an IllegalArgumentException."
        );
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void computeRegressionPrediction_EmptyInput_ThrowsError() {
        // Arrange
        List<String> input = List.of("");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> RegressionPrediction.predictYValue(input),
                "Empty input should throw an IllegalArgumentException."
        );
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void computeRegressionPrediction_InputWithMultipleLines_ThrowsError() {
        // Arrange
        List<String> input = List.of("1.535, 61.272186542107434, -39.061955918838656", "2.0, 50.0, 10.0");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> RegressionPrediction.predictYValue(input),
                "Multiple lines of input should throw an IllegalArgumentException."
        );
        assertEquals("Input must contain exactly one line with three numeric values separated by commas.", exception.getMessage());
    }
}