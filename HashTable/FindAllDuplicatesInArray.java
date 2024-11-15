package hash_table;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
    public static List<Integer> solution(int[] nums) {
        /*
        nums [4,3,2,7,8,2,3,1]
        each element, 4 -> index of 4 - 1 = 3, adjust element at index 3 (*-1)
        so for each element, if we first traverse, the element will be positive, after we adjust, the value will be negative
        so if there is duplicate, before adjust, check if it is negative (appear one before) -> add to ans
         */
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] < 0) {
                ans.add(x);
            }
            nums[x - 1] *= -1;
        }
        return ans;
    }
}
