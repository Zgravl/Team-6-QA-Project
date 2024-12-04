import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class ZScoreTest {
    @Test
    public void ZScore_ValidParameters_ReturnsCorrectZScore() {
        //preq-UNIT-TEST-5
        //Arrange
        List<String> input = List.of("11.5, 7, 1.5811388300841898");
        double expected = 2.846049894151541;
        //Act
        double result = ZScore.calculateZScore(input);
        //Assert
        assertEquals(expected, result, 1e-9, "The computed z-score should match the expected value.");
    }

    @Test
    public void ZScore_MissingOneParameter_ThrowsError() {
        //preq-UNIT-TEST-5
        //Arrange
        List<String> input = List.of("11.5, 7");
        //Act
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "A missing parameter should throw an IllegalArgumentException."
        );
        //Assert
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void ZScore_ExtraParameters_ThrowsError() {
        //preq-UNIT-TEST-5
        //Arrange
        List<String> input = List.of("11.5, 7, 1.5811388300841898, 3");
        //Act
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "An extra parameter should throw an IllegalArgumentException."
        );
        //Assert
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void ZScore_EmptyInput_ThrowsError() {
        //preq-UNIT-TEST-5
        //Arrange
        List<String> input = List.of("");
        //Act
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "An empty input should throw an IllegalArgumentException."
        );
        //Assert
        assertEquals("The input must contain exactly three numeric values separated by commas.", exception.getMessage());
    }

    @Test
    public void ZScore_NonNumericInput_ThrowsError() {
        //preq-UNIT-TEST-5
        //Arrange
        List<String> input = List.of("11.5, abc, 1.5811388300841898");
        //Act
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "Non-numeric input should throw an IllegalArgumentException."
        );
        //Assert
        assertEquals("All three values must be numeric.", exception.getMessage());
    }

    @Test
    public void ZScore_StandardDeviationIsZero_ThrowsError() {
        //preq-UNIT-TEST-5
        //Arrange
        List<String> input = List.of("11.5, 7, 0");
        //Act
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "A standard deviation of zero should throw an IllegalArgumentException."
        );
        //Assert
        assertEquals("Standard deviation cannot be zero.", exception.getMessage());
    }

    @Test
    public void ZScore_MultipleLines_ThrowsError() {
        //preq-UNIT-TEST-5
        //Arrange
        List<String> input = List.of("11.5, 7, 1.5811388300841898","5, 2, 1");
        //Act
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> ZScore.calculateZScore(input),
                "Multiple lines of input should throw an IllegalArgumentException."
        );
        //Assert
        assertEquals("Input must contain exactly one line.", exception.getMessage());
    }
}
