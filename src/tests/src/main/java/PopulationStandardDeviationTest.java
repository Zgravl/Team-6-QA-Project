import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import calculatorlogic.PopulationStandardDeviation;
package tests;
class PopulationStandardDeviationTest {

    @Test
    public void PopulationStandardDeviation_ValidListOfSamples_ReturnsStandardDeviation() {
        List<String> input = List.of("9", "6", "8", "5", "7");
        double expected = 1.4142135623730951;

        double result = PopulationStandardDeviation.calculatePopulationStandardDeviation(input);

        assertEquals(expected, result, 1e-9, "The computed population standard deviation should match the expected value.");
    }

    @Test
    public void PopulationStandardDeviation_ListOfAllZeros_ReturnsZero() {
        List<String> input = List.of("0", "0", "0", "0", "0");
        double expected = 0.0;

        double result = PopulationStandardDeviation.calculatePopulationStandardDeviation(input);

        assertEquals(expected, result, 1e-9, "The computed population standard deviation of all zeros should be zero.");
    }

    @Test
    public void PopulationStandardDeviation_EmptyList_ThrowsError() {
        List<String> input = List.of();

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> PopulationStandardDeviation.calculatePopulationStandardDeviation(input),
                "An empty list should throw an IllegalArgumentException."
        );
        assertEquals("Input must contain at least two valid numeric values.", exception.getMessage());
    }

    @Test
    public void PopulationStandardDeviation_ListWithOneSample_ThrowsError() {
        List<String> input = List.of("42");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> PopulationStandardDeviation.calculatePopulationStandardDeviation(input),
                "A list with one sample should throw an IllegalArgumentException."
        );
        assertEquals("Input must contain at least two valid numeric values.", exception.getMessage());
    }


    @Test
    public void PopulationStandardDeviation_ListWithNonNumericValues_ThrowsError() {
        List<String> input = List.of("5", "abc", "7");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> PopulationStandardDeviation.calculatePopulationStandardDeviation(input),
                "A list with non-numeric values should throw an IllegalArgumentException."
        );
        assertEquals("Invalid numeric value in input: abc", exception.getMessage());
    }

    @Test
    public void PopulationStandardDeviation_ListWithSpaces_IgnoresSpaces() {
        List<String> input = List.of(" 9 ", " ", "7", "", "6");
        double expected = 1.247219128924647;

        double result = PopulationStandardDeviation.calculatePopulationStandardDeviation(input);

        assertEquals(expected, result, 1e-9, "The computed population standard deviation should ignore empty lines and spaces.");
    }
}