import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class dayTwoTest {


    private final dayTwo reporter = new dayTwo(); // Create an instance of the class to test

    @Test
    void safe_inBounds_allDecrease() {
        int[] input = {7,6,4,2,1};
        Boolean result = reporter.isSafeReport(input);
        Boolean expected = true; 
        assertEquals(expected, result);
    }

    @Test
    void unSafe_badIncrease() {
        int[] input = {1,2,7,8,9};
        Boolean result = reporter.isSafeReport(input);
        Boolean expected = false; 
        assertEquals(expected, result);
    }
    @Test
    void unSafe_badDecrease() {
        int[] input = {9,7,6,2,1};
        Boolean result = reporter.isSafeReport(input);
        Boolean expected = false; 
        assertEquals(expected, result);
    }

    @Test
    void unSafe_incrToDecr() {
        int[] input = {1,3,2,4,5};
        Boolean result = reporter.isSafeReport(input);
        Boolean expected = false; 
        assertEquals(expected, result);
    }

    @Test
    void unSafe_NoDiff() {
        int[] input = {8,6,4,4,1};
        Boolean result = reporter.isSafeReport(input);
        Boolean expected = false; 
        assertEquals(expected, result);
    }

    @Test
    void safe_InBounds_allIncrease() {
        int[] input = {1,3,6,7,9};
        Boolean result = reporter.isSafeReport(input);
        Boolean expected = true; 
        assertEquals(expected, result);
    }
}


