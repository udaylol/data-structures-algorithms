package arrays;

//    given an array of denoting heights of k towers
//    you can add or subtract k from every element
//    an infinite number of times such that
//    the difference between minimum and maximum heights
//    in the array is minimized

public class NormaliseHeights {
    static int normaliseHeights(int[] heights, int k) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int num : heights) {
            int val = num % k;
            left = Math.min(val, left);
            right = Math.max(val, right);
        }
        return Math.abs(right - left);
    }

    public static void main(String[] args) {
        int[] heights = {1, 5, 12};
        int k = 3;
        int ans = normaliseHeights(heights, k);
        System.out.println(ans);
    }
}