import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class PopulationStandardDeviationTest {

    @Test
    public void PopulationStandardDeviation_ValidListOfSamples_ReturnsStandardDeviation() {
        //preq-UNIT-TEST-3
        //Arrange
        List<String> input = List.of("9", "6", "8", "5", "7");
        double expected = 1.4142135623730951;
        //Act
        double result = PopulationStandardDeviation.calculatePopulationStandardDeviation(input);
        //Assert
        assertEquals(expected, result, 1e-9, "The computed population standard deviation should match the expected value.");
    }

    @Test
    public void PopulationStandardDeviation_ListOfAllZeros_ReturnsZero() {
        //preq-UNIT-TEST-3
        //Arrange
        List<String> input = List.of("0", "0", "0", "0", "0");
        double expected = 0.0;
        //Act
        double result = PopulationStandardDeviation.calculatePopulationStandardDeviation(input);
        //Assert
        assertEquals(expected, result, 1e-9, "The computed population standard deviation of all zeros should be zero.");
    }

    @Test
    public void PopulationStandardDeviation_EmptyList_ThrowsError() {
        //preq-UNIT-TEST-3
        //Arrange
        List<String> input = List.of();
        //Act
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> PopulationStandardDeviation.calculatePopulationStandardDeviation(input),
                "An empty list should throw an IllegalArgumentException."
        );
        //Assert
        assertEquals("Input must contain at least two valid numeric values.", exception.getMessage());
    }

    @Test
    public void PopulationStandardDeviation_ListWithOneSample_ThrowsError() {
        //preq-UNIT-TEST-3
        //Arrange
        List<String> input = List.of("42");
        //Act
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> PopulationStandardDeviation.calculatePopulationStandardDeviation(input),
                "A list with one sample should throw an IllegalArgumentException."
        );
        //Assert
        assertEquals("Input must contain at least two valid numeric values.", exception.getMessage());
    }


    @Test
    public void PopulationStandardDeviation_ListWithNonNumericValues_ThrowsError() {
        //preq-UNIT-TEST-3
        //Arrange
        List<String> input = List.of("5", "abc", "7");
        //Act
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> PopulationStandardDeviation.calculatePopulationStandardDeviation(input),
                "A list with non-numeric values should throw an IllegalArgumentException."
        );
        //Assert
        assertEquals("Invalid numeric value in input: abc", exception.getMessage());
    }

    @Test
    public void PopulationStandardDeviation_ListWithSpaces_IgnoresSpaces() {
        //preq-UNIT-TEST-3
        //Arrange
        List<String> input = List.of(" 9 ", " ", "7", "", "6");
        double expected = 1.247219128924647;
        //Act
        double result = PopulationStandardDeviation.calculatePopulationStandardDeviation(input);
        //Assert
        assertEquals(expected, result, 1e-9, "The computed population standard deviation should ignore empty lines and spaces.");
    }
}
