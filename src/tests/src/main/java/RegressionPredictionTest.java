import org.example.RegressionPrediction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
package calculator-logic;
public class RegressionPredictionTest {

    @Test
    public void RegressionPrediction_ValidParameters_ReturnsCorrectPrediction() {
        List<String> input = List.of("1.535, 61.272186542107434, -39.061955918838656");
        String expected = "y = 54.990850423296244";

        String result = RegressionPrediction.predictYValue(input);

        assertEquals(expected, result, "The regression prediction should match the expected value.");
    }

    @Test
    public void RegressionPrediction_MissingParameters_ThrowsError() {
        List<String> input = List.of("1.535, 61.272186542107434");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> RegressionPrediction.predictYValue(input),
                "Missing parameters should throw an IllegalArgumentException."
        );
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void RegressionPrediction_ExtraSpaces_ReturnsCorrectPrediction() {
        List<String> input = List.of(" 1.535  ,  61.272186542107434  ,   -39.061955918838656 ");
        String expected = "y = 54.990850423296244";

        String result = RegressionPrediction.predictYValue(input);

        assertEquals(expected, result, "Extra spaces in the input should not affect the prediction calculation.");
    }

    @Test
    public void RegressionPrediction_InvalidNumericValues_ThrowsError() {
        List<String> input = List.of("1.535, abc, -39.061955918838656");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> RegressionPrediction.predictYValue(input),
                "Non-numeric values should throw an IllegalArgumentException."
        );
        assertEquals("All three values must be numeric.", exception.getMessage());
    }

    @Test
    public void RegressionPrediction_OnlyTwoValues_ThrowsError() {
        List<String> input = List.of("1.535, 61.272186542107434");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> RegressionPrediction.predictYValue(input),
                "Less than three values should throw an IllegalArgumentException."
        );
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void RegressionPrediction_MoreThanThreeValues_ThrowsError() {
        List<String> input = List.of("1.535, 61.272186542107434, -39.061955918838656, 42.0");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> RegressionPrediction.predictYValue(input),
                "More than three values should throw an IllegalArgumentException."
        );
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void RegressionPrediction_EmptyInput_ThrowsError() {
        List<String> input = List.of("");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> RegressionPrediction.predictYValue(input),
                "Empty input should throw an IllegalArgumentException."
        );
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void RegressionPrediction_MultipleLines_ThrowsError() {
        List<String> input = List.of("1.535, 61.272186542107434, -39.061955918838656", "2.0, 50.0, 10.0");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> RegressionPrediction.predictYValue(input),
                "Multiple lines of input should throw an IllegalArgumentException."
        );
        assertEquals("Input must contain exactly one line with three numeric values separated by commas.", exception.getMessage());
    }
}