import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import daily.FirstMissing;

class FirstMissingTest {
    private FirstMissing tester = new FirstMissing();

    @Test
    void test1() {
        int[] input = new int[]{ 3, 4, -1, 1 };
        assertEquals(2, tester.findMissing(input));
    }

    @Test
    void test2() {
        int[] input = new int[]{ 1, 2, 0 };
        assertEquals(3, tester.findMissing(input));
    }
}
