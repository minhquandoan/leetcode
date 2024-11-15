package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindPowerOfSubarray {
    public static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];

        for (int i = 0, counter = 0; i < n; i++) {
            if (i > 0 && nums[i - 1]+ 1 == nums[i]) {
                counter++;
            } else {
                counter = 1;
            }

            if (i + 1 >= k) {
                ans[i - k + 1] = counter >= k ? nums[i] : -1;
            }
        }        
        return ans;
    }
}
