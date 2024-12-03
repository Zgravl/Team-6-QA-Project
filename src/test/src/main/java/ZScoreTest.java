import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class ZScoreTest {
    @Test
    public void ZScore_ValidParameters_ReturnsCorrectZScore() {
        List<String> input = List.of("11.5, 7, 1.5811388300841898");
        double expected = 2.846049894151541;

        double result = ZScore.calculateZScore(input);

        assertEquals(expected, result, 1e-9, "The computed z-score should match the expected value.");
    }

    @Test
    public void ZScore_MissingOneParameter_ThrowsError() {
        List<String> input = List.of("11.5, 7");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "A missing parameter should throw an IllegalArgumentException."
        );
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void ZScore_ExtraParameters_ThrowsError() {
        List<String> input = List.of("11.5, 7, 1.5811388300841898, 3");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "An extra parameter should throw an IllegalArgumentException."
        );
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void ZScore_EmptyInput_ThrowsError() {
        List<String> input = List.of("");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "An empty input should throw an IllegalArgumentException."
        );
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void ZScore_NonNumericInput_ThrowsError() {
        List<String> input = List.of("11.5, abc, 1.5811388300841898");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "Non-numeric input should throw an IllegalArgumentException."
        );
        assertEquals("All three values must be numeric.", exception.getMessage());
    }

    @Test
    public void ZScore_StandardDeviationIsZero_ThrowsError() {
        List<String> input = List.of("11.5, 7, 0");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "A standard deviation of zero should throw an IllegalArgumentException."
        );
        assertEquals("Standard deviation cannot be zero.", exception.getMessage());
    }

    @Test
    public void ZScore_MultipleLines_ThrowsError() {
        List<String> input = List.of("11.5, 7, 1.5811388300841898","5, 2, 1");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "Multiple lines of input should throw an IllegalArgumentException."
        );
        assertEquals("Input must contain exactly one line.", exception.getMessage());
    }
}