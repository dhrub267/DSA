import java.util.PriorityQueue;

class Solution {
    public void nearlySorted(int[] arr, int k) {
        if (arr == null || arr.length == 0) return;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n = arr.length;
        int index = 0;

        // Add first k+1 elements to the heap
        for (int i = 0; i < Math.min(k + 1, n); i++) {
            minHeap.add(arr[i]);
        }

        // For remaining elements, extract min and add new element
        for (int i = k + 1; i < n; i++) {
            arr[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }

        // Extract remaining elements from the heap
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}
