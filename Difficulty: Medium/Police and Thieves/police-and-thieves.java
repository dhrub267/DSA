// class Solution {
//     public int catchThieves(char[] arr, int k) {
//         // code here
        
//     }
// }


class Solution {
    public int catchThieves(char[] arr, int k) {
        ArrayList<Integer> police = new ArrayList<>();
        ArrayList<Integer> thief = new ArrayList<>();

        // Store indices
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') police.add(i);
            else if (arr[i] == 'T') thief.add(i);
        }

        int i = 0, j = 0;
        int count = 0;

        // Two pointer matching
        while (i < police.size() && j < thief.size()) {
            if (Math.abs(police.get(i) - thief.get(j)) <= k) {
                count++;
                i++;
                j++;
            } 
            else if (police.get(i) < thief.get(j)) {
                i++;
            } 
            else {
                j++;
            }
        }

        return count;
    }
}
