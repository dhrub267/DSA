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
//     public int distCandy(Node root) {
//         // code here
        
//     }
// }



/*
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
*/

class Solution {
    int moves = 0; // global variable to count total moves
    
    public int distCandy(Node root) {
        distribute(root);
        return moves;
    }
    
    private int distribute(Node root) {
        if (root == null) return 0;
        
        int leftBalance = distribute(root.left);
        int rightBalance = distribute(root.right);
        
        // total moves needed for left + right subtrees
        moves += Math.abs(leftBalance) + Math.abs(rightBalance);
        
        // return current node's balance
        return root.data + leftBalance + rightBalance - 1;
    }
}
