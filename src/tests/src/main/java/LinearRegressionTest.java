import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LinearRegressionTest {
    @Test
    public void computeLinearRegression_ValidListOfXY_ReturnsCorrectFormula() {
        // Arrange
        List<String> input = List.of(
                "1.47, 52.21",
                "1.5, 53.12",
                "1.52, 54.48",
                "1.55, 55.84",
                "1.57, 57.2");
        String expected = "y = 50.414012738853500x + -22.160127388535017";

        // Act
        String result = LinearRegression.calculateLinearRegression(input);

        // Assert
        assertEquals(expected, result, "The computed regression formula should match the expected value.");
    }

    @Test
    public void computeLinearRegression_EmptyInput_ThrowsError() {
        // Arrange
        List<String> input = List.of("");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> LinearRegression.calculateLinearRegression(input),
                "An empty input should throw an IllegalArgumentException."
        );
        assertEquals("There must be at least two valid X, Y pairs.", exception.getMessage());
    }

    @Test
    public void computeLinearRegression_AllXValuesSame_ThrowsError() {
        // Arrange
        List<String> input = List.of("2, 3", "2, 5", "2, 7");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> LinearRegression.calculateLinearRegression(input),
                "All X values being the same should throw an IllegalArgumentException."
        );
        assertEquals("Cannot compute linear regression; all X values are the same.", exception.getMessage());
    }

    @Test
    public void computeLinearRegression_AllYValuesSame_ReturnsHorizontalLine() {
        // Arrange
        List<String> input = List.of("1, 5", "2, 5", "3, 5");
        String expected = "y = 0.000000000000000x + 5.000000000000000";

        // Act
        String result = LinearRegression.calculateLinearRegression(input);

        // Assert
        assertEquals(expected, result, "When all Y values are the same, the regression should return a horizontal line.");
    }

    @Test
    public void computeLinearRegression_AllZeroXY_ReturnsOrigin() {
        // Arrange
        List<String> input = List.of("0, 0", "0, 0", "0, 0");

        // Act
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> LinearRegression.calculateLinearRegression(input),
                "All X values being the same should throw an IllegalArgumentException."
        );
        assertEquals("Cannot compute linear regression; all X values are the same.", exception.getMessage());
    }

    @Test
    public void computeLinearRegression_InvalidXYPair_ThrowsError() {
        // Arrange
        List<String> input = List.of("1.5, 2.5", "abc, 3");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> LinearRegression.calculateLinearRegression(input),
                "Non-numeric values should throw an IllegalArgumentException."
        );
        assertEquals("Invalid numeric values in line: abc, 3", exception.getMessage());
    }

    @Test
    public void computeLinearRegression_SingleXYPair_ThrowsError() {
        // Arrange
        List<String> input = List.of("1.5, 2.5");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> LinearRegression.calculateLinearRegression(input),
                "A single X,Y pair should throw an IllegalArgumentException."
        );
        assertEquals("There must be at least two valid X, Y pairs.", exception.getMessage());
    }

    @Test
    public void computeLinearRegression_ExtraSpacesInInput_HandlesCorrectly() {
        // Arrange
        List<String> input = List.of("1.47,52.21", "1.5,53.12");
        String expected = "y = 30.333333333333194x + 7.620000000000211";

        // Act
        String result = LinearRegression.calculateLinearRegression(input);

        // Assert
        assertEquals(expected, result, "Extra spaces in input should be handled correctly.");
    }

    @Test
    public void computeLinearRegression_MixedValidAndInvalidPairs_ThrowsError() {
        // Arrange
        List<String> input = List.of("1.47, 52.21", "1.5");

        // Act and Assert
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> LinearRegression.calculateLinearRegression(input),
                "Invalid pairs should throw an IllegalArgumentException."
        );
        assertEquals("Each line must contain exactly two numeric values separated by a comma.", exception.getMessage());
    }
}