package arrays;

import java.util.Arrays;

public class CountingSort {

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i + 1 != nums[i] && nums[nums[i] - 1] != nums[i]) {
                int correctIdx = nums[i] - 1;
                swap(nums, i, correctIdx);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 6, 4, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
