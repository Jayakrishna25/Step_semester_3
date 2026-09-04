package main.java.week_4.assignment_problem;
class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        MaximumSubarray solver = new MaximumSubarray();
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solver.maxSubArray(nums1)); // Output: 6
        int[] nums2 = {-3, -1, -2};
        System.out.println(solver.maxSubArray(nums2)); // Output: -1
    }
}