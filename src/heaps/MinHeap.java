package heaps;

import java.util.*;

class MinHeap {
    List<Integer> nums;

    MinHeap() {
        nums = new ArrayList<>();
    }

    static void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    void add(int val) {
        nums.add(val);
        int idx = nums.size() - 1;

        while (idx > 0) {
            int parent = (idx - 1) / 2;

            if (nums.get(idx) < nums.get(parent)) {
                swap(nums, idx, parent);
                idx = parent;
            } else {
                break;
            }
        }
    }

    void remove() {
        if (nums.isEmpty()) return;

        nums.set(0, nums.getLast());
        nums.removeLast();

        int i = 0;
        int n = nums.size();

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            int smallest = i;

            if (left < n && nums.get(left) < nums.get(smallest)) {
                smallest = left;
            }

            if (right < n && nums.get(right) < nums.get(smallest)) {
                smallest = right;
            }

            if (smallest == i) break;
            swap(nums, i, smallest);
            i = smallest;
        }
    }

    void print() {
        System.out.println(nums);
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.add(5);
        minHeap.add(10);
        minHeap.add(1);
        minHeap.add(3);
        minHeap.add(6);
        minHeap.add(21);
        minHeap.add(2);
        minHeap.add(4);

        minHeap.print();  // heap
        minHeap.remove(); // remove min
        minHeap.print();
    }
}
