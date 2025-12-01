class Solution {
    
    static class Node {
        Node[] child = new Node[2];
        int count = 0;
    }
    
    Node root = new Node();
    
    // Insert number in Trie
    void insert(int num) {
        Node cur = root;
        for(int bit = 15; bit >= 0; bit--) {
            int val = (num >> bit) & 1;
            if(cur.child[val] == null) cur.child[val] = new Node();
            cur = cur.child[val];
            cur.count++;
        }
    }
    
    // Count previous values y such that (num ^ y) < k
    int query(int num, int k) {
        Node cur = root;
        int ans = 0;
        for(int bit = 15; bit >= 0; bit--) {
            if(cur == null) break;
            int nb = (num >> bit) & 1;     // bit of num
            int kb = (k >> bit) & 1;       // bit of k
            
            if(kb == 1) {
                // We can choose those where XOR bit = 0 → same bit
                if(cur.child[nb] != null) ans += cur.child[nb].count;
                // Move to XOR bit = 1 → opposite
                cur = cur.child[1 - nb];
            } else {
                // Only XOR bit = 0 allowed → must move to same bit
                cur = cur.child[nb];
            }
        }
        return ans;
    }
    
    public int cntPairs(int[] arr, int k) {
        int count = 0;
        for(int x : arr) {
            count += query(x, k);   // count pairs formed with previous numbers
            insert(x);             // insert after querying
        }
        return count;
    }
}
