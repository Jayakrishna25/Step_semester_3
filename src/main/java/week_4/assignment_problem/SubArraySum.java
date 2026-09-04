package main.java.week_4.assignment_problem;
import java.util.HashMap;
import java.util.Map;
class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        for (int num : nums) {
            currentSum += num;
            if (prefixMap.containsKey(currentSum - k)) {
                count += prefixMap.get(currentSum - k);
            }
            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        SubarraySumEqualsK solver = new SubarraySumEqualsK();
        int[] nums1 = {1, 1, 1};
        System.out.println(solver.subarraySum(nums1, 2));
        int[] nums2 = {1, -1, 0};
        System.out.println(solver.subarraySum(nums2, 0));
    }
}