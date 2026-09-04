package main.java.week_4.assignment_problem;
import java.util.Arrays;
class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: answer[i] contains product of all elements to the left
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Backward pass: multiply by running product of elements to the right
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        ProductExceptSelf solver = new ProductExceptSelf();

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(solver.productExceptSelf(nums1))); // [24, 12, 8, 6]

        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(solver.productExceptSelf(nums2))); // [0, 0, 9, 0, 0]
    }
}