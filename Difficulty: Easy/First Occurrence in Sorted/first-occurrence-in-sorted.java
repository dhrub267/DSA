class Solution {
    public int firstSearch(int[] arr, int tar) {
        // Code Here
        int idx=-1;
        int low=0;
        int high=arr.length-1;
        
        while(low<=high){
            int mid=(low+high)/2;
            
            if(tar<arr[mid]){
                high=mid-1;
            }
            
            else if(tar>arr[mid]){
                low=mid+1;
            }
            
            else{
                idx=mid;
                high=mid-1;
            }
            
        }
        return idx;
    }
}