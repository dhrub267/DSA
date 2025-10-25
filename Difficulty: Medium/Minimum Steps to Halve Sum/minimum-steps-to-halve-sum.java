import java.util.*;

class Solution {
    public int minOperations(int[] arr) {
        double sum = 0;
        
        // Max heap to store values in reverse order
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : arr) {
            sum += num;
            maxHeap.add((double) num);
        }
        
        double target = sum / 2.0;
        int operations = 0;
        
        while (sum > target) {
            double top = maxHeap.poll();
            
            double half = top / 2.0;
            sum -= half;        // Reduce sum by half of removed value
            
            maxHeap.add(half);  // Insert the halved value back
            
            operations++;
        }
        
        return operations;
    }
}
