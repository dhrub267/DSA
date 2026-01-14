class Solution {
    public int findFloor(int[] arr, int x) {
        // code here
        int n=arr.length;
        int low=0;
        int high=n-1;
        int idx=-1;
        while(low<=high){
            int mid=low + (high-low)/2;
            
            if(arr[mid]>x) high=mid-1;
            
            else{
                idx=mid;
                low=mid+1;
            }
        }
        
        return idx;
        
    }
}
