package SlidingWindow;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0, right = 0;
        while (left < nums.length - 1) {
            while (Math.abs(left - right) <= k) {
                right++;
                if (nums[left] == nums[right]) {
                    return true;
                }
            }
            left++;
        }

        

        return false;
    }
}
