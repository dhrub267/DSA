// /*
// class Node {
//     int data;
//     Node left;
//     Node right;

//     Node(int data) {
//         this.data = data;
//         left = null;
//         right = null;
//     }
// }
// */

// class Solution {
//     public ArrayList<Integer> bottomView(Node root) {
//         // code here
        
//     }
// }


class Solution {
    // Helper class to store node along with its horizontal distance
    class Pair {
        Node node;
        int hd;
        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        // TreeMap to store horizontal distance and corresponding node data
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        // Start with root node and hd = 0
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            Node temp = curr.node;
            int hd = curr.hd;

            // Update the map with the latest node at each horizontal distance
            map.put(hd, temp.data);

            // Add left and right children with updated horizontal distances
            if (temp.left != null) q.add(new Pair(temp.left, hd - 1));
            if (temp.right != null) q.add(new Pair(temp.right, hd + 1));
        }

        // Add the bottom view nodes from leftmost hd to rightmost hd
        ans.addAll(map.values());
        return ans;
    }
}
