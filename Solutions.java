import java.util.HashMap;
import java.util.Map;

import hash_table.FindAllDuplicatesInArray;
import sliding_window.ContainsDuplicateII;
import sliding_window.FindPowerOfSubarray;
import sliding_window.MaximumSumOfDistinctSubarrWithK;

public class Solutions {
    public static void main(String[] args) {
        // int[] nums = {4,3,2,7,8,2,3,1};
        // var result = FindAllDuplicatesInArray.solution(nums);
        // System.out.println(result);
        // ContainsDuplicateII.containsNearbyDuplicate(nums, 2);
        // int[] nums = {1,2,3,4,3,2,5};
        // int k = 3;
        // // System.out.println(FindPowerOfSubarray.resultsArray(nums, k));
        // var ans = FindPowerOfSubarray.resultsArray(nums, k);
        // for (int i : ans) {
        //     System.out.print(i + " ");
        // }

        System.out.println(MaximumSumOfDistinctSubarrWithK.maximumSubarraySum(new int[]{1,1,4,2,9,9,9}, 3));
        
    }
}
