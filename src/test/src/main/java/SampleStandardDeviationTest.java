import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SampleStandardDeviationTest {

    @Test
    public void SampleStandardDeviation_ValidListOfSamples_ReturnsStandardDeviation() {
        //preq-UNIT-TEST-2
        //Arrange
        List<String> input = List.of("9", "6", "8", "5", "7");
        double expected = 1.5811388300841898;
        //Act
        double result = SampleStandardDeviation.calculateSampleStandardDeviation(input);
        //Assert
        assertEquals(expected, result, 1e-9, "The computed standard deviation should match the expected value.");
    }

    @Test
    public void SampleStandardDeviation_ListOfAllZeros_ReturnsZero() {
        //preq-UNIT-TEST-2
        //Arrange
        List<String> input = List.of("0", "0", "0", "0", "0");
        double expected = 0.0;
        //Act
        double result = SampleStandardDeviation.calculateSampleStandardDeviation(input);
        //Assert
        assertEquals(expected, result, 1e-9, "The computed standard deviation of all zeros should be zero.");
    }

    @Test
    public void SampleStandardDeviation_EmptyList_ThrowsError() {
        //preq-UNIT-TEST-2
        //Arrange
        List<String> input = List.of();
        //Act
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> SampleStandardDeviation.calculateSampleStandardDeviation(input),
                "An empty list should throw an IllegalArgumentException."
        );
        //Assert
        assertEquals("No valid numeric values provided.", exception.getMessage());
    }


    @Test
    public void SampleStandardDeviation_ListWithNonNumericValues_ThrowsError() {
        //preq-UNIT-TEST-2
        //Arrange
        List<String> input = List.of("5", "abc", "7");
        //Act
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> SampleStandardDeviation.calculateSampleStandardDeviation(input),
                "A list with non-numeric values should throw an IllegalArgumentException."
        );
        //Assert
        assertEquals("Invalid numeric value in input: abc", exception.getMessage());
    }

    @Test
    public void SampleStandardDeviation_ListWithSpaces_IgnoresSpaces() {
        //preq-UNIT-TEST-2
        //Arrange
        List<String> input = List.of(" 9 ", " ", "7", "", "6");
        double expected = 1.5275252316519468;
        //Act
        double result = SampleStandardDeviation.calculateSampleStandardDeviation(input);
        //Assert
        assertEquals(expected, result, 1e-9, "The computed sample standard deviation should ignore empty lines and spaces.");
    }
}
