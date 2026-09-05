class Solution {
    static int findFloor(int[] arr, int x) {
        // code here
        int low=0;
        int high=arr.length-1;
        int idx=-1;
        
        while(low<=high){
            int mid=(low+high)/2;
            if(x<arr[mid]){
                //go left
                high=mid-1;
            }
            else if(x>=arr[mid]){
                //go right
                idx=mid;
                low=mid+1;
            }
        }
        return idx;
    }
}
