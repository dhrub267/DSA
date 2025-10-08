/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

// class Solution {
//     public Node constructTree(int[] pre, int[] post) {
//         // code here
        
//     }
// }


/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int preIndex = 0;
    
    public Node constructTree(int[] pre, int[] post) {
        return construct(pre, post, 0, post.length - 1);
    }

    private Node construct(int[] pre, int[] post, int start, int end) {
        if (preIndex >= pre.length || start > end)
            return null;

        // Step 1: Create current root
        Node root = new Node(pre[preIndex]);
        preIndex++;

        // Step 2: If leaf node
        if (start == end || preIndex >= pre.length)
            return root;

        // Step 3: Find index of next preorder element in post[]
        int i;
        for (i = start; i <= end; i++) {
            if (post[i] == pre[preIndex])
                break;
        }

        // Step 4: Build left & right subtrees recursively
        if (i <= end) {
            root.left = construct(pre, post, start, i);
            root.right = construct(pre, post, i + 1, end - 1);
        }

        return root;
    }
}
