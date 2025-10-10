// /*
// class Node {
//     int data;
//     Node left,right;
//     Node(int d)
//     {
//         data=d;
//         left=right=null;
//     }
// }
// */

// class Solution {
//     ArrayList<Integer> zigZagTraversal(Node root) {
//         // code here
        
//     }
// }


class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                
                if (leftToRight) {
                    level.add(node.data); // left to right
                } else {
                    level.add(0, node.data); // right to left
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.addAll(level);
            leftToRight = !leftToRight; // toggle direction
        }

        return result;
    }
}
