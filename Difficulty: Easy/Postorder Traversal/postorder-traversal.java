// /*
// class Node {
//     int data;
//     Node left, right;
//     Node(int val){
//         data = val;
//         left = right = null;
//     }
// }
// */

// class Solution {
//     public ArrayList<Integer> postOrder(Node root) {
//         // code here
        
//     }
// }


import java.util.*;

class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(Node node, ArrayList<Integer> list) {
        if (node == null) return;

        // 1️⃣ Left subtree
        traverse(node.left, list);

        // 2️⃣ Right subtree
        traverse(node.right, list);

        // 3️⃣ Root node
        list.add(node.data);
    }
}
