import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class tests {

class MainTest {

    private final Main main = new Main(); // Create an instance of the class to test

    @Test
    void testAdd() {
        // Arrange
        int a = 5;
        int b = 3;

        // Act
        int result = main.add(a, b);

        // Assert
        assertEquals(8, result, "The add method should return the sum of two numbers.");
    }

    @Test
    void testIsPositive() {
        // Act & Assert
        assertTrue(main.isPositive(5), "Positive number should return true.");
        assertFalse(main.isPositive(-5), "Negative number should return false.");
    }
}

}
