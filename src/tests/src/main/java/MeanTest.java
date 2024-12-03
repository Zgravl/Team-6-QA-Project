import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
package calculatorlogic;
class MeanTest {

    @Test
    public void Mean_ValidListOfNumbers_ReturnsMean() {
        List<String> input = List.of("9", "6", "8", "5", "7");
        double expected = 7.0;

        double result = Mean.calculateMean(input);

        assertEquals(expected, result, 1e-9, "The computed mean should match the expected value.");
    }

    @Test
    public void Mean_EmptyList_ThrowsError() {
        List<String> input = List.of();

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Mean.calculateMean(input),
                "An empty list should throw an IllegalArgumentException."
        );
        assertEquals("Input must contain at least one valid numeric value.", exception.getMessage());
    }

    @Test
    public void Mean_ListWithNonNumericValues_ThrowsError() {
        List<String> input = List.of("5", "abc", "7");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Mean.calculateMean(input),
                "A list with non-numeric values should throw an IllegalArgumentException."
        );
        assertEquals("Invalid numeric value in input: abc", exception.getMessage());
    }

    @Test
    public void Mean_ListWithSpaces_IgnoresSpacesAndComputesMean() {
        List<String> input = List.of(" 9 ", " ", "7", "", "6");
        double expected = 7.333333333333333;

        double result = Mean.calculateMean(input);

        assertEquals(expected, result, 1e-9, "The computed mean should ignore empty lines and spaces.");
    }
}