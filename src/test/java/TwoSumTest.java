import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import daily.TwoSum;

class TwoSumTest {
    private TwoSum tester = new TwoSum();

    @Test
    void test() {
        boolean result = tester.haveSum(new int[]{10, 5, 7}, 17);
        assertTrue(result);

        result = tester.haveSum(new int[]{10, 5, 7}, 11);
        assertFalse(result);
    }

    @Test
    void duplicate() {
        boolean result = tester.haveSum(new int[]{7, 5, 7}, 14);
        assertTrue(result);

        result = tester.haveSum(new int[]{7, 5, 7}, 12);
        assertTrue(result);

        result = tester.haveSum(new int[]{7, 5, 7}, 11);
        assertFalse(result);
    }

    @Test
    void empty() {
        boolean result = tester.haveSum(new int[]{}, 14);
        assertFalse(result);
    }
}
