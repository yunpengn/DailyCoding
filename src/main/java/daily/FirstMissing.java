package daily;

public class FirstMissing {
    public int findMissing(int[] nums) {
        // Swap all elements to their correct position if necessary.
        for (int i = 0; i < nums.length; i++) {
            // Just keep it there if not in the correct range.
            if (nums[i] <= 0 || nums[i] >= nums.length) {
                continue;
            }

            // Swap the element to its correct position otherwise.
            swap(nums, i, nums[i] - 1);
        }

        // Finds the first missing positive integer.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Returns the default value if the array is somehow "awesome".
        return nums.length;
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
