class Solution {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(arr1.length == 0 || arr2.length == 0 || k <= 0) 
            return result;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (arr1[a[0]] + arr2[a[1]]) - (arr1[b[0]] + arr2[b[1]])
        );

        // Pehle element ke sath arr2[0] ka pair push karo
        for(int i = 0; i < Math.min(k, arr1.length); i++) {
            pq.offer(new int[]{i, 0});
        }

        while(k > 0 && !pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[0], j = top[1];

            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(arr1[i]);
            pair.add(arr2[j]);
            result.add(pair);

            // arr1[i] ke sath next arr2 value ko push karo
            if(j + 1 < arr2.length) {
                pq.offer(new int[]{i, j + 1});
            }

            k--;
        }
        return result;
    }
}
