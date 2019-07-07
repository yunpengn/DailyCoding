import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MultiplyEveryoneTest {
    private MultiplyEveryone tester = new MultiplyEveryone();

    @Test
    void test() {
        int[] result = tester.arrayProduct(new int[]{1, 2, 3, 4, 5});
        int[] expected = new int[]{120, 60, 40, 30, 24};
        assertArrayEquals(expected, result);

        result = tester.arrayProduct(new int[]{3, 2, 1});
        expected = new int[]{2, 3, 6};
        assertArrayEquals(expected, result);
    }

    @Test
    void empty() {
        int[] result = tester.arrayProduct(new int[]{});
        assertArrayEquals(new int[]{}, result);
    }
}
