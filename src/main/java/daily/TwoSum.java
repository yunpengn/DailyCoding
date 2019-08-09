package daily;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public boolean haveSum(int[] arr, int target) {
        Set<Integer> items = new HashSet<>();

        for (int n: arr) {
            if (items.contains(target - n)) {
                return true;
            }
            items.add(n);
        }

        return false;
    }
}
