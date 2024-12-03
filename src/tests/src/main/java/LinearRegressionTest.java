import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import calculator-logic.src.main.java;

public class LinearRegressionTest {
    @Test
    public void LinearRegression_ValidList_ReturnsCorrectFormula() {
        List<String> input = List.of(
                "1.47, 52.21",
                "1.5, 53.12",
                "1.52, 54.48",
                "1.55, 55.84",
                "1.57, 57.2");
        String expected = "y = 50.414012738853500x + -22.160127388535017";

        String result = LinearRegression.calculateLinearRegression(input);

        assertEquals(expected, result, "The computed regression formula should match the expected value.");
    }

    @Test
    public void LinearRegression_EmptyInput_ThrowsError() {
        List<String> input = List.of("");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> LinearRegression.calculateLinearRegression(input),
                "An empty input should throw an IllegalArgumentException."
        );
        assertEquals("There must be at least two valid X, Y pairs.", exception.getMessage());
    }

    @Test
    public void LinearRegression_AllXValuesSame_ThrowsError() {
        List<String> input = List.of("2, 3", "2, 5", "2, 7");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> LinearRegression.calculateLinearRegression(input),
                "All X values being the same should throw an IllegalArgumentException."
        );
        assertEquals("Cannot compute linear regression; all X values are the same.", exception.getMessage());
    }

    @Test
    public void LinearRegression_AllYValuesSame_ReturnsHorizontalLine() {
        List<String> input = List.of("1, 5", "2, 5", "3, 5");
        String expected = "y = 0.000000000000000x + 5.000000000000000";

        String result = LinearRegression.calculateLinearRegression(input);

        assertEquals(expected, result, "When all Y values are the same, the regression should return a horizontal line.");
    }

    @Test
    public void LinearRegression_AllZeroXY_ReturnsOrigin() {
        List<String> input = List.of("0, 0", "0, 0", "0, 0");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> LinearRegression.calculateLinearRegression(input),
                "All X values being the same should throw an IllegalArgumentException."
        );
        assertEquals("Cannot compute linear regression; all X values are the same.", exception.getMessage());
    }

    @Test
    public void LinearRegression_InvalidXYPair_ThrowsError() {
        List<String> input = List.of("1.5, 2.5", "abc, 3");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> LinearRegression.calculateLinearRegression(input),
                "Non-numeric values should throw an IllegalArgumentException."
        );
        assertEquals("Invalid numeric values in line: abc, 3", exception.getMessage());
    }

    @Test
    public void LinearRegression_SingleXYPair_ThrowsError() {
        List<String> input = List.of("1.5, 2.5");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> LinearRegression.calculateLinearRegression(input),
                "A single X,Y pair should throw an IllegalArgumentException."
        );
        assertEquals("There must be at least two valid X, Y pairs.", exception.getMessage());
    }

    @Test
    public void computeLinearRegression_ExtraSpacesInInput_ReturnsCorrectFormula() {
        List<String> input = List.of("1.47,52.21", "1.5,53.12");
        String expected = "y = 30.333333333333194x + 7.620000000000211";

        String result = LinearRegression.calculateLinearRegression(input);

        assertEquals(expected, result, "Extra spaces in input should be handled correctly.");
    }

    @Test
    public void LinearRegression_MixedValidAndInvalidPairs_ThrowsError() {
        List<String> input = List.of("1.47, 52.21", "1.5");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> LinearRegression.calculateLinearRegression(input),
                "Invalid pairs should throw an IllegalArgumentException."
        );
        assertEquals("Each line must contain exactly two numeric values separated by a comma.", exception.getMessage());
    }
}