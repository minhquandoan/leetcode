package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfDistinctSubarrWithK {
    public static long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        long currentMax = 0L;
        long currentSum = 0L; // Use long to avoid overflow issues

        while (right < nums.length) {
            int num = nums[right];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            currentSum += num;
            right++;

            // If the window size is greater than k, shrink from the left
            while (right - left > k) {
                int leftNum = nums[left];
                countMap.put(leftNum, countMap.get(leftNum) - 1);
                if (countMap.get(leftNum) == 0) {
                    countMap.remove(leftNum);
                }
                currentSum -= leftNum;
                left++;
            }

            // Check if the window size is exactly k and all elements are unique
            if (right - left == k && countMap.size() == k) {
                currentMax = Math.max(currentMax, currentSum);
            }
        }

        return currentMax;
    }
}
