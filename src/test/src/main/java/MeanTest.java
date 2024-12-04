import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class MeanTest {

    @Test
    public void Mean_ValidListOfNumbers_ReturnsMean() {
        //preq-UNIT-TEST-4
        //Arrange
        List<String> input = List.of("9", "6", "8", "5", "7");
        double expected = 7.0;
        //Act
        double result = Mean.calculateMean(input);
        //Assert
        assertEquals(expected, result, 1e-9, "The computed mean should match the expected value.");
    }

    @Test
    public void Mean_EmptyList_ThrowsError() {
        //preq-UNIT-TEST-4
        //Arrange
        List<String> input = List.of();
        //Act
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Mean.calculateMean(input),
                "An empty list should throw an IllegalArgumentException."
        );
        //Assert
        assertEquals("Input must contain at least one valid numeric value.", exception.getMessage());
    }

    @Test
    public void Mean_ListWithNonNumericValues_ThrowsError() {
        //preq-UNIT-TEST-4
        //Arrange
        List<String> input = List.of("5", "abc", "7");
        //Act
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Mean.calculateMean(input),
                "A list with non-numeric values should throw an IllegalArgumentException."
        );
        //Assert
        assertEquals("Invalid numeric value in input: abc", exception.getMessage());
    }

    @Test
    public void Mean_ListWithSpaces_IgnoresSpacesAndComputesMean() {
        //preq-UNIT-TEST-4
        //Arrange
        List<String> input = List.of(" 9 ", " ", "7", "", "6");
        double expected = 7.333333333333333;
        //Act
        double result = Mean.calculateMean(input);
        //Assert
        assertEquals(expected, result, 1e-9, "The computed mean should ignore empty lines and spaces.");
    }
}
