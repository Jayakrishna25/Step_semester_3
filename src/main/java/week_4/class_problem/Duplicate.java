package main.java.week_4.class_problem;
class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Output: " + containsDuplicate(nums1));
    }
}
