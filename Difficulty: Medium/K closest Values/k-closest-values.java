/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

// class Solution {
//     public ArrayList<Integer> getKClosest(Node root, int target, int k) {
//         // code here
        
//     }
// }


import java.util.*;

class Solution {
    // Helper function to do inorder traversal and collect node values
    void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);

        // Sort by closeness to target
        Collections.sort(inorderList, (a, b) -> {
            int diffA = Math.abs(a - target);
            int diffB = Math.abs(b - target);

            if (diffA == diffB)
                return a - b; // smaller one first if same diff
            return diffA - diffB; // smaller diff first
        });

        // Take first k elements
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k && i < inorderList.size(); i++) {
            ans.add(inorderList.get(i));
        }

        return ans;
    }
}
