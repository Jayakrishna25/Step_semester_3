package main.java.week_4.assignment_problem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class ThreeSum {
    public int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(new int[]{nums[i], nums[left], nums[right]});
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        ThreeSum solver = new ThreeSum();
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[][] res1 = solver.threeSum(nums1);
        System.out.println(Arrays.deepToString(res1));
        int[] nums2 = {0, 0, 0};
        int[][] res2 = solver.threeSum(nums2);
        System.out.println(Arrays.deepToString(res2));
    }
}
